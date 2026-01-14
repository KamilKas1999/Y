package com.kasprzak.kamil.demoapp.common.query;

import com.kasprzak.kamil.demoapp.common.exceptions.BusinesException;

public interface QueryExecutor {

    <T extends QueryResult> T execute(Query query, Class<T> resultType) throws BusinesException;
}
