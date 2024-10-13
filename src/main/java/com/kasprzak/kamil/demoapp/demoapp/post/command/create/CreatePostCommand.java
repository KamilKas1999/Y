package com.kasprzak.kamil.demoapp.demoapp.post.command.create;

import com.kasprzak.kamil.demoapp.demoapp.common.command.Command;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreatePostCommand implements Command {

    private long userId;
    private String content;
}
