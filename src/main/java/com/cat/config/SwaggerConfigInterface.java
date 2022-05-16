package com.cat.config;

import org.springframework.web.reactive.config.ResourceHandlerRegistry;

public interface SwaggerConfigInterface {
    void addResourceHandlers(ResourceHandlerRegistry registry);
}
