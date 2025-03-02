package com.kasprzak.kamil.demoapp.item.command;

import com.kasprzak.kamil.demoapp.item.ItemService;
import com.kasprzak.kamil.demoapp.common.command.CommandHandler;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateItemCommandHandler implements CommandHandler<CreateItemCommand> {

    private final ItemService itemService;

    @Override
    public void handle(final CreateItemCommand command) {
        itemService.createItem(command.getName(), command.getDescription());
    }
}
