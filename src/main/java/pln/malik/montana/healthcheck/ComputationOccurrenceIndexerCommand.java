package pln.malik.montana.healthcheck;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class ComputationOccurrenceIndexerCommand {

  private ElasticsearchRepository elasticsearchRepository;

  private ConsumedCreditsCalculationService consumedCreditsCalculationService;

  private EstimatedPriceCalculationService estimatedPriceCalculationService;

  public Mono<ComputationOccurrenceResponse> execute(Mono<ComputationOccurrenceRequest> request) {

    return Mono.empty();
  }

}
