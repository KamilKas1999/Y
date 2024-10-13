package com.kasprzak.kamil.demoapp.demoapp.post.query;

import com.kasprzak.kamil.demoapp.demoapp.common.query.QueryResult;
import com.kasprzak.kamil.demoapp.demoapp.post.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Builder
@Data
public class PostsQueryResult implements QueryResult {

    List<Post> posts;
}
