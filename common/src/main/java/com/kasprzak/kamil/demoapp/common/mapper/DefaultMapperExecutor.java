package com.kasprzak.kamil.demoapp.common.mapper;

import com.kasprzak.kamil.demoapp.common.query.Query;
import com.kasprzak.kamil.demoapp.common.query.QueryHandler;
import com.kasprzak.kamil.demoapp.common.query.QueryHandlerNotFoundException;
import com.kasprzak.kamil.demoapp.common.query.QueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DefaultMapperExecutor implements MapperExceutor{

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
