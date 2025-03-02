package com.kasprzak.kamil.demoapp.common.command;

public interface CommandExecutor {

    void execute(Command command) throws CommandHandlerNotFoundExeption;

    <T extends CommandResult> T execute(Command command, Class<T> resultType) throws CommandHandlerNotFoundExeption;
}
