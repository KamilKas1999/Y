package com.kasprzak.kamil.demoapp.common.mapper;

import com.kasprzak.kamil.demoapp.common.query.Query;
import com.kasprzak.kamil.demoapp.common.query.QueryResult;

public interface Mapper<S, T> {

    Class<S> getSourceType();
    Class<T> getTargetType();
    T map(S source);
}
