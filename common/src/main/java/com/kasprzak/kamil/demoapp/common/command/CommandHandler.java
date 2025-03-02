package com.kasprzak.kamil.demoapp.common.command;


public interface CommandHandler<T> {

    void handle(T command);
}
