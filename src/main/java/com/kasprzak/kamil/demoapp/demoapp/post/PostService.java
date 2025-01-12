package com.kasprzak.kamil.demoapp.demoapp.post;

import com.kasprzak.kamil.demoapp.demoapp.user.User;

import java.util.List;

public interface PostService {


    void createPost(final long userId, final String content);

    List<Post> getPosts();


    void deletePost(long id);

    void addComment(final long postId, final long userId, final String content);
}
