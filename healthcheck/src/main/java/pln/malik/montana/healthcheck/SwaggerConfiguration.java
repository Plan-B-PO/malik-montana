package pln.malik.montana.healthcheck;

import com.fasterxml.classmate.TypeResolver;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.web.reactive.config.ResourceHandlerRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurationSupport;
import reactor.core.publisher.Mono;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;

import java.lang.reflect.Array;
import java.lang.reflect.WildcardType;
import java.util.Arrays;

import static springfox.documentation.schema.AlternateTypeRules.newRule;

@Configuration
@RequiredArgsConstructor
@EnableSwagger2WebFlux
class SwaggerConfiguration extends WebFluxConfigurationSupport {
  private ApiInfo apiInfo = new ApiInfoBuilder()
    .title("Integration")
    .description("Read logs")
    .version("1.0")
    .build();


  private final TypeResolver typeResolver;
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
      .apiInfo(apiInfo)
      .enable(true)
      .select()
      .paths(PathSelectors.any())
      .build()
      .alternateTypeRules(
        new RecursiveAlternateTypeRule(typeResolver, Arrays.asList(
          newRule(
            typeResolver.resolve(Mono.class, WildcardType.class),
            typeResolver.resolve(WildcardType.class)
          )
//          ,
//          newRule(
//            typeResolver.resolve(ResponseEntity.class, WildcardType.class),
//            typeResolver.resolve(WildcardType.class)
//          )
        )))
      ;

  }

  @Bean
  public ObjectMapper objectMapper() {
    ObjectMapper mapper = new ObjectMapper();
    mapper.findAndRegisterModules();
    return mapper;
  }

  @Bean
  public Jackson2JsonEncoder jackson2JsonEncoder(ObjectMapper mapper) {
    return new Jackson2JsonEncoder(mapper);
  }

  @Bean
  public Jackson2JsonDecoder jackson2JsonDecoder(ObjectMapper mapper) {
    return new Jackson2JsonDecoder(mapper);
  }

  @Override
  protected void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/**").addResourceLocations("classpath:META-INF/resources/");
  }

}
