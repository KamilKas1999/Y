package com.kasprzak.kamil.demoapp.common.query;

public interface QueryExecutor {

    <T> T execute(Query query, Class<T> resultType) throws QueryHandlerNotFoundExeption;
}
