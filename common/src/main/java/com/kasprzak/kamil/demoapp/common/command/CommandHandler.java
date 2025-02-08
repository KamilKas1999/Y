package com.kasprzak.kamil.demoapp.common.command;

public interface CommandHandler<T> {

    public void handle(T command);
}
