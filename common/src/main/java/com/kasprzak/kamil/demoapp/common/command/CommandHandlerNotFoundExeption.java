package com.kasprzak.kamil.demoapp.common.command;

public class CommandHandlerNotFoundExeption extends RuntimeException{

    public CommandHandlerNotFoundExeption(final String handlerName){
        super("Handler for " + handlerName + " not founded");
    }

}
