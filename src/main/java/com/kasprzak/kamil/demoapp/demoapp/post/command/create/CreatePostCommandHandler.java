package com.kasprzak.kamil.demoapp.demoapp.post.command.create;

import com.kasprzak.kamil.demoapp.demoapp.common.command.CommandHandler;
import com.kasprzak.kamil.demoapp.demoapp.post.PostService;
import com.kasprzak.kamil.demoapp.demoapp.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreatePostCommandHandler implements CommandHandler<CreatePostCommand> {

    private final PostService userService;

    @Override
    public void handle(CreatePostCommand command) {
        userService.createPost(command.getUserId(), command.getContent());
    }
}
