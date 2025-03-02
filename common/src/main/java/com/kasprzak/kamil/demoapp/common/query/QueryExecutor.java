package com.kasprzak.kamil.demoapp.common.query;

public interface QueryExecutor {

    <T extends QueryResult> T execute(Query query, Class<T> resultType) throws QueryHandlerNotFoundException;
}
