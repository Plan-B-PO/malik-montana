package pln.malik.montana.healthcheck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableWebFlux
@SpringBootApplication
public class HealthcheckApplication {

  public static void main(String[] args) {
    SpringApplication.run(HealthcheckApplication.class, args);
  }

}


