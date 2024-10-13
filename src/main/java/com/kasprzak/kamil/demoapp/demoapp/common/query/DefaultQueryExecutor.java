package com.kasprzak.kamil.demoapp.demoapp.common.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;


@Service
public class DefaultQueryExecutor implements QueryExecutor {

    @Autowired
    private List<QueryHandler> commandHandlers;

    @Override
    public <T> T execute(Query query, Class<T> resultType) throws QueryHandlerNotFoundExeption {
        return (T) commandHandlers.stream()
                .filter(handler -> isThisHandlerForThisCommand(query, handler))
                .findAny()
                .orElseThrow(throwExeption(query))
                .handle(query);
    }

    private Supplier<QueryHandlerNotFoundExeption> throwExeption(Query query) {
        return () -> new QueryHandlerNotFoundExeption(query.getClass().getSimpleName());
    }

    private boolean isThisHandlerForThisCommand(Query query, QueryHandler queryHandler) {
        return queryHandler.getClass().getSimpleName()
                .contains(query.getClass().getSimpleName());
    }
}
