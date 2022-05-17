package com.cat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.ResourceHandlerRegistry;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements SwaggerConfigInterface {

    private static final String DESCRIPTION_API = "#### Aplicação desenvolvida para fins de um processo seletivo. A mesma consta com banco de dados relacional mysql(RDS) na AWS \n" +
            "- **Fazemos o uso da api https://api.thecatapi.com/v1/ para popular o banco**: A api traz informações de raça, imagens entre outras\n";

    private static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
            "cat-api-itau API", DESCRIPTION_API, "1.0",
            "urn:tos", null,
            "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", List.of());

    public static final String CAT_CONTROLLER = "cat-controller";
    public static final String CAT_INSERT_DATABASE_CONTROLLER = "cat-insert-database-controller";


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(DEFAULT_API_INFO)
                .tags(
                        new Tag(CAT_CONTROLLER, "Consultas e inserção de informações de gatinhos", 0),
                        new Tag(CAT_INSERT_DATABASE_CONTROLLER, "Inserção direta no banco de dados caso o mesmo esteja vazio", 1)
                );
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.
                addResourceHandler("/swagger-ui/**")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("**/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

    }
}