package pln.malik.montana.healthcheck;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ElasticsearchConfiguration {

  @Bean
  RestHighLevelClient restHighLevelClient() {
    return new RestHighLevelClient(
      RestClient
        .builder(new HttpHost("elasticsearch", 9202))
        .setRequestConfigCallback(config -> config
          .setConnectTimeout(5_000)
          .setConnectionRequestTimeout(5_000)
          .setSocketTimeout(5_000)
        )
    );
  }
}
