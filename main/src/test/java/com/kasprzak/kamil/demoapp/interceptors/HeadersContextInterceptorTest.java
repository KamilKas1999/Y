package com.kasprzak.kamil.demoapp.interceptors;

import com.kasprzak.kamil.demoapp.common.context.RequestHeadersContext;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import static org.junit.jupiter.api.Assertions.*;

class HeadersContextInterceptorTest {
    @Test
    void shouldPutHeadersIntoContext() {
        RequestHeadersContext context = new RequestHeadersContext();
        HeadersContextInterceptor interceptor = new HeadersContextInterceptor(context);

        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("headerName", "headerValue");

        interceptor.preHandle(request, new MockHttpServletResponse(), new Object());

        assertEquals("headerValue", context.get("headerName"));
    }
}