package pln.malik.montana.healthcheck;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;

@Configuration
@EnableSwagger2WebFlux
public class SwaggerConfiguration {

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
      .select()
      .apis(RequestHandlerSelectors.any())
      .paths(PathSelectors.any())
      .build();
  }

//  @Bean
//  public DocumentationPluginsBootstrapper documentationPluginsBootstrapper(
//   DocumentationPluginsManager documentationPluginsManager,
//   List<RequestHandlerProvider> handlerProviders,
//   DocumentationCache documentationCache,
//   ApiDocumentationScanner apiDocumentationScanner,
//   TypeResolver typeResolver,
//   Defaults defaults,
//   PathProvider pathProvider,
//   Environment environment
//  ) {
//    return  new DocumentationPluginsBootstrapper(documentationPluginsManager, handlerProviders, documentationCache, apiDocumentationScanner, typeResolver, defaults, pathProvider, environment);
//
//  }
}
