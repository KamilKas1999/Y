package com.kasprzak.kamil.demoapp.common.mapper;

public interface MapperExceutor {

    public <S, T> T map(S source, Class<T> targetType);
}
