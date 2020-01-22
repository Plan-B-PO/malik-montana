package pln.malik.montana.integration;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ApplicationQuery {

  private final ComputationOccurrenceRepository computationOccurrenceRepository;

  public Mono<ApplicationResponse> logic(Mono<UUID> request) {
    return request
      .map(computationOccurrenceRepository::findAllByApplicationUUID)
      .flatMap(Flux::collectList)
      .map(ApplicationResponse::new);
  }

  @Builder
  @Value
  public static class ApplicationResponse {

    List<ComputationOccurrenceEntity> logs;

  }
}
