package com.kasprzak.kamil.demoapp.common.command;

public interface CommandExecutor {

    void execute(Command command) throws CommandHandlerNotFoundExeption;
}
