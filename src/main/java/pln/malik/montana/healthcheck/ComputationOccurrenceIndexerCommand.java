package pln.malik.montana.healthcheck;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class ComputationOccurrenceIndexerCommand {

  private ComputationOccurrenceRepository computationOccurrenceRepository;

  private ConsumedCreditsService consumedCreditsService;

  private EstimatedPriceService estimatedPriceService;

  public Mono<Void> execute(Mono<ComputationOccurrenceRequest> request) {
    return request
      .map(req -> ComputationOccurrenceEntity.builder()
        .applicationUUID(req.getApplicationUUID())
        .status(req.getStatus())
        .consumedCredits(consumedCreditsService.calculate())
        .estimatedPrice(estimatedPriceService.calculate())
        .build())
      .flatMap(computationOccurrenceRepository::save)
      .then();
  }

}
