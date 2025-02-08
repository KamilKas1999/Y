package com.kasprzak.kamil.demoapp.common.query;

public class QueryHandlerNotFoundExeption extends RuntimeException{

    public QueryHandlerNotFoundExeption(final String handlerName){
        super("Handler for " + handlerName + " not founded");
    }

}
