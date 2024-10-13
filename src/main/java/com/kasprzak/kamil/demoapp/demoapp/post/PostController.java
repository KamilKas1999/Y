package com.kasprzak.kamil.demoapp.demoapp.post;

import com.kasprzak.kamil.demoapp.demoapp.common.command.CommandExecutor;
import com.kasprzak.kamil.demoapp.demoapp.common.query.QueryExecutor;
import com.kasprzak.kamil.demoapp.demoapp.post.command.create.CreatePostCommand;
import com.kasprzak.kamil.demoapp.demoapp.post.dto.CreatePostDTO;
import com.kasprzak.kamil.demoapp.demoapp.post.dto.PostsDTO;
import com.kasprzak.kamil.demoapp.demoapp.post.query.PostsQuery;
import com.kasprzak.kamil.demoapp.demoapp.post.query.PostsQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private QueryExecutor queryExecutor;

    @Autowired
    private CommandExecutor commandExecutor;

    @PostMapping
    public void createPost(final CreatePostDTO postDTO) {
        final var command = new CreatePostCommand(postDTO.getUserId(), postDTO.getContent());
        commandExecutor.execute(command);
    }

    @GetMapping
    public PostsDTO getUsers() {
        var query = new PostsQuery();
        var result = queryExecutor.execute(query, PostsQueryResult.class);
        return PostsDTO
                .builder()
                .users(result.getPosts())
                .build();
    }
}
