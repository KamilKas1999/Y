package com.kasprzak.kamil.demoapp.common.query;

import java.lang.reflect.ParameterizedType;

public interface QueryHandler<Q extends Query, R extends QueryResult> {
    default boolean supports(Query query) {
        return getQueryType().isInstance(query);
    }

    @SuppressWarnings("unchecked")
    private Class<Q> getQueryType() {
        var genericSuperclass = getClass().getGenericInterfaces();
        for (var type : genericSuperclass) {
            if (type instanceof ParameterizedType parameterizedType) {
                return (Class<Q>) parameterizedType.getActualTypeArguments()[0];
            }
        }
        throw new IllegalStateException("Cannot determine query type");
    }

    R handle(Q query);


}
