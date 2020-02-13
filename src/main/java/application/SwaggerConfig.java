package application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("application")) 
                //.apis(RequestHandlerSelectors.any()) 
                .paths(PathSelectors.any())                          
                .build()
                .apiInfo(apiInfo()).tags(new Tag("Greeting API", "Welcome message"));
    }
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Greetings Microservice").version("1.0.0").build();
	}

}
