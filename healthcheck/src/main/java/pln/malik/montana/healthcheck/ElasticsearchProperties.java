package pln.malik.montana.healthcheck;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "elasticsearch")
@Data
class ElasticsearchProperties {

  private String hosts;
  private int connectTimeout;
  private int socketTimeout;

}
