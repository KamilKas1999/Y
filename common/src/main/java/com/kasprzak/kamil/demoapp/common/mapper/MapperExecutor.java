package com.kasprzak.kamil.demoapp.common.mapper;

public interface MapperExecutor {

    public <S, T> T map(S source, Class<T> targetType);
}
