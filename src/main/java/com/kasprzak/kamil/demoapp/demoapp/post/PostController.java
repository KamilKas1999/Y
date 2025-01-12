package com.kasprzak.kamil.demoapp.demoapp.post;

import com.kasprzak.kamil.demoapp.demoapp.common.command.CommandExecutor;
import com.kasprzak.kamil.demoapp.demoapp.common.query.QueryExecutor;
import com.kasprzak.kamil.demoapp.demoapp.post.command.comment.CommentPostCommand;
import com.kasprzak.kamil.demoapp.demoapp.post.command.create.CreatePostCommand;
import com.kasprzak.kamil.demoapp.demoapp.post.dto.*;
import com.kasprzak.kamil.demoapp.demoapp.post.query.PostsQuery;
import com.kasprzak.kamil.demoapp.demoapp.post.query.PostsQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private QueryExecutor queryExecutor;

    @Autowired
    private CommandExecutor commandExecutor;

    @PostMapping
    public void createPost(@RequestBody final CreatePostDTO postDTO) {
        final var command = new CreatePostCommand(postDTO.getUserId(), postDTO.getContent());
        commandExecutor.execute(command);
    }

    @GetMapping
    public PostsDTO getUsers() {
        var query = new PostsQuery();
        var result = queryExecutor.execute(query, PostsQueryResult.class);
        return PostsDTO
                .builder()
                .posts(result.getPosts()
                        .stream()
                        .map(post -> PostDTO
                                .builder()
                                .userId(post.getUser().getId())
                                .content(post.getContent())
                                .comments(post.getComments()
                                        .stream()
                                        .map(comment -> CommentDTO
                                                .builder()
                                                .id(comment.getId())
                                                .userId(comment.getId())
                                                .content(comment.getContent())
                                                .build())
                                        .toList())
                                .build())
                        .toList())
                .build();
    }

    @PostMapping("/comment")
    public void commentPost(@RequestBody final CommentPostDTO commentPostDTO) {
        commandExecutor.execute(CommentPostCommand
                .builder()
                .postId(commentPostDTO.getPostId())
                .userId(commentPostDTO.getUserId())
                .text(commentPostDTO.getContent())
                .build());
    }
}
