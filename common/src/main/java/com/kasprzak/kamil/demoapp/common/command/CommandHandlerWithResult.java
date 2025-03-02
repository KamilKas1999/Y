package com.kasprzak.kamil.demoapp.common.command;


public interface CommandHandlerWithResult<C extends Command, R extends CommandResult> {
    R handle(C command);
}
