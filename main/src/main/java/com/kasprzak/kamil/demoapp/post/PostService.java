package com.kasprzak.kamil.demoapp.post;

import java.util.List;

public interface PostService {


    void createPost(final long userId, final String content);

    List<PostEntity> getPosts();


    void deletePost(long id);

    void addComment(final long postId, final long userId, final String content);
}
