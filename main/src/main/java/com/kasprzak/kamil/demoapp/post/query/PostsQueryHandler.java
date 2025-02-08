package com.kasprzak.kamil.demoapp.post.query;

import com.kasprzak.kamil.demoapp.common.query.QueryHandler;
import com.kasprzak.kamil.demoapp.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostsQueryHandler implements QueryHandler<PostsQuery, PostsQueryResult> {

    private final PostService postService;

    public PostsQueryResult handle(PostsQuery query){
        var users =  postService.getPosts();
        return PostsQueryResult.builder()
                .postEntities(users)
                .build();
    }

}
