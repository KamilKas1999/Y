package com.kasprzak.kamil.demoapp.common.mapper;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DefaultMapperExecutor implements MapperExecutor {

    private final Map<String, Mapper<?, ?>> mappers = new HashMap<>();

    public DefaultMapperExecutor(List<Mapper<?, ?>> mapperList) {
        for (Mapper<?, ?> mapper : mapperList) {
            mappers.put(key(mapper.getSourceType(), mapper.getTargetType()), mapper);
        }
    }

    @SuppressWarnings("unchecked")
    public <S, T> T map(S source, Class<T> targetType) {
        String key = key(source.getClass(), targetType);
        Mapper<S, T> mapper = (Mapper<S, T>) mappers.get(key);
        if (mapper == null) {
            throw new IllegalArgumentException("No mapper found for " + key);
        }
        return mapper.map(source);
    }

    private String key(Class<?> source, Class<?> target) {
        return source.getName() + "->" + target.getName();
    }
}
