package com.kasprzak.kamil.demoapp.demoapp.item.command;

import com.kasprzak.kamil.demoapp.demoapp.common.command.Command;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateItemCommand implements Command {

    private String name;
    private String description;
}
