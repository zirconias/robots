package com.imdrissi.rbc.ace.robots.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
      .title("ACE ROBOT API")
      .description("ROBOT API FOR THE ACE PROGRAM.")
      .termsOfServiceUrl("terms of services")
      .contact(new Contact("islam drissi", "http://yes.imdrissi.com", "islam.drissi@gmail.com"))
      .license("MIT")
      .version("0.1")
      .build();
  }

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
      .groupName("ace")
      .apiInfo(apiInfo())
      .select()
      .paths(PathSelectors.any())
      .apis(RequestHandlerSelectors.any())
      .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
      .build();
  }

//  private Predicate<String> apiPaths() {
//    return or(
//      regex("/robot/*")
//    );
//  }

}
