package com.kasprzak.kamil.demoapp.item;

import com.kasprzak.kamil.demoapp.common.command.CommandExecutor;
import com.kasprzak.kamil.demoapp.item.command.CreateItemCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private CommandExecutor commandExecutor;

    @PostMapping
    public void createItem(final CreateItemDTO createItemDTO) {
        final var command = new CreateItemCommand(createItemDTO.getName(), createItemDTO.getDescription());
        commandExecutor.execute(command);
    }
}
