package pln.malik.montana.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableWebFlux
@SpringBootApplication
public class IntegrationApplication {

  public static void main(String[] args) {
    SpringApplication.run(IntegrationApplication .class, args);
  }

}
