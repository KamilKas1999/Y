package com.kasprzak.kamil.demoapp.common.query;

public class QueryHandlerNotFoundException extends RuntimeException{

    public QueryHandlerNotFoundException(final String handlerName){
        super("Handler for " + handlerName + " not founded");
    }

}
