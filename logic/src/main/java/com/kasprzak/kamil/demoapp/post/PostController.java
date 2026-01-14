package com.kasprzak.kamil.demoapp.post;

import com.kasprzak.kamil.demoapp.common.command.CommandExecutor;
import com.kasprzak.kamil.demoapp.common.exceptions.BusinesException;
import com.kasprzak.kamil.demoapp.common.mapper.MapperExecutor;
import com.kasprzak.kamil.demoapp.common.query.QueryExecutor;
import com.kasprzak.kamil.demoapp.post.command.comment.CommentPostCommand;
import com.kasprzak.kamil.demoapp.post.command.create.CreatePostCommand;
import com.kasprzak.kamil.demoapp.post.query.PostsQuery;
import com.kasprzak.kamil.demoapp.post.query.PostsQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private QueryExecutor queryExecutor;

    @Autowired
    private CommandExecutor commandExecutor;

    @Autowired
    private MapperExecutor mapperExecutor;

    @PostMapping
    public void createPost(@RequestBody final CreatePostRequest createPostRequest) {
        final var command = new CreatePostCommand(createPostRequest.getUserId(), createPostRequest.getContent());
        commandExecutor.execute(command);
    }

    @GetMapping
    public GetPostsResponse getPosts() throws BusinesException {
        var query = new PostsQuery(Optional.empty());
        var result = queryExecutor.execute(query, PostsQueryResult.class);
        return mapperExecutor.map(result, GetPostsResponse.class);
    }

    @GetMapping("/{userId}")
    public GetPostsResponse getPostsByUser(@PathVariable Long userId) throws BusinesException {
        var query = new PostsQuery(Optional.of(userId));
        var result = queryExecutor.execute(query, PostsQueryResult.class);
        return mapperExecutor.map(result, GetPostsResponse.class);
    }

    @PostMapping("/comment")
    public void commentPost(@RequestBody final CommentPostRequest commentPostRequest) {
        commandExecutor.execute(CommentPostCommand
                .builder()
                .postId(commentPostRequest.getPostId())
                .userId(commentPostRequest.getUserId())
                .text(commentPostRequest.getContent())
                .build());
    }
}
