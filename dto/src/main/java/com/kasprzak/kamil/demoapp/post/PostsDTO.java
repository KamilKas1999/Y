package com.kasprzak.kamil.demoapp.post;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PostsDTO {

    private List<PostDTO> posts;

}


