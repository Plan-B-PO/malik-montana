package pln.malik.montana.healthcheck;

import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class HealthcheckApplication {

  public static void main(String[] args) {
    SpringApplication.run(HealthcheckApplication.class, args);
  }

}

@Configuration
class ElasticsearchConfiguration {

}
