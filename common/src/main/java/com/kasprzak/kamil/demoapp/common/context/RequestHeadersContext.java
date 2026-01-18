package com.kasprzak.kamil.demoapp.common.context;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component
@RequestScope
public class RequestHeadersContext {

    private final Map<String, String> headers = new HashMap<>();

    public void put(String name, String value) {
        headers.put(name, value);
    }

    public String get(String name) {
        return headers.get(name);
    }

    public Map<String, String> getAll() {
        return Collections.unmodifiableMap(headers);
    }
}
