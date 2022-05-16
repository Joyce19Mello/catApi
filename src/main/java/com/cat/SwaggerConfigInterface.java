package com.cat;

import org.springframework.web.reactive.config.ResourceHandlerRegistry;

public interface SwaggerConfigInterface {
    void addResourceHandlers(ResourceHandlerRegistry registry);
}
