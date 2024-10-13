package com.kasprzak.kamil.demoapp.demoapp.common.command;

public interface CommandHandler<T> {

    public void handle(T command);
}
