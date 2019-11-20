package pln.malik.montana.integration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "elasticsearch")
@Data
class ElasticsearchProperties {

  private String hosts;
  private int connectTimeout;
  private int socketTimeout;

}
