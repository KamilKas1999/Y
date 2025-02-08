package com.kasprzak.kamil.demoapp.common.query;

public interface QueryHandler<T,N> {

    public N handle(T command);
}
