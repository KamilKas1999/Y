package com.kasprzak.kamil.demoapp.demoapp.post.dto;

import com.kasprzak.kamil.demoapp.demoapp.post.Post;
import com.kasprzak.kamil.demoapp.demoapp.user.User;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PostsDTO {

    private List<Post> users;
}
