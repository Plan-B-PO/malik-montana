package pln.malik.montana.healthcheck;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.reactive.ReactiveElasticsearchClient;
import org.springframework.data.elasticsearch.client.reactive.ReactiveRestClients;
import org.springframework.data.elasticsearch.config.AbstractReactiveElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableReactiveElasticsearchRepositories;

@RequiredArgsConstructor
@Configuration
@EnableReactiveElasticsearchRepositories
class ElasticsearchConfiguration extends AbstractReactiveElasticsearchConfiguration {

  private final ElasticsearchProperties properties;

  @Override
  public ReactiveElasticsearchClient reactiveElasticsearchClient () {
    var clientConfiguration = ClientConfiguration.builder()
      .connectedTo(properties.getHosts())
      .withConnectTimeout(properties.getConnectTimeout())
      .withSocketTimeout(properties.getSocketTimeout())
      .build();
    return ReactiveRestClients.create(clientConfiguration);
  }
}

