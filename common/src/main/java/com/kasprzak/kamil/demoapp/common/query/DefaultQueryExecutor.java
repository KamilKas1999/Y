package com.kasprzak.kamil.demoapp.common.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DefaultQueryExecutor implements QueryExecutor {

    @Autowired
    private List<QueryHandler<?, ?>> commandHandlers;

    @Override
    public <T extends QueryResult> T execute(Query query, Class<T> resultType) throws QueryHandlerNotFoundException {
        var handler = commandHandlers.stream()
                .filter(h -> h.supports(query))
                .map(h -> (QueryHandler<Query, QueryResult>) h) // Unikamy niepoprawnego rzutowania
                .findAny()
                .orElseThrow(() -> new QueryHandlerNotFoundException(query.getClass().getSimpleName()));

        var result = handler.handle(query);

        if (!resultType.isInstance(result)) {
            throw new ClassCastException("Expected result type: " + resultType + ", but got: " + result.getClass());
        }

        return resultType.cast(result);
    }
}
