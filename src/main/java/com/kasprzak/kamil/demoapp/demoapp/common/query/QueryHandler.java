package com.kasprzak.kamil.demoapp.demoapp.common.query;

public interface QueryHandler<T,N> {

    public N handle(T command);
}
