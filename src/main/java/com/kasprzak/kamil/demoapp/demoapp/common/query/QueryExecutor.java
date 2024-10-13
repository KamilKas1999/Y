package com.kasprzak.kamil.demoapp.demoapp.common.query;

import com.kasprzak.kamil.demoapp.demoapp.common.command.Command;

public interface QueryExecutor {

    <T> T execute(Query query, Class<T> resultType) throws QueryHandlerNotFoundExeption;
}
