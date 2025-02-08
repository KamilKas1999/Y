package com.kasprzak.kamil.demoapp.common.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;


@Service
public class DefaultCommandExecutor implements CommandExecutor {

    @Autowired
    private List<CommandHandler> commandHandlers;

    @Override
    public void execute(Command command) throws CommandHandlerNotFoundExeption {
        commandHandlers.stream()
                .filter(handler -> isThisHandlerForThisCommand(command, handler))
                .findAny()
                .orElseThrow(throwExeption(command))
                .handle(command);
    }

    private Supplier<CommandHandlerNotFoundExeption> throwExeption(Command command) {
        return () -> new CommandHandlerNotFoundExeption(command.getClass().getSimpleName());
    }

    private boolean isThisHandlerForThisCommand(Command command, CommandHandler c) {
        return c.getClass().getSimpleName()
                .contains(command.getClass().getSimpleName());
    }
}
