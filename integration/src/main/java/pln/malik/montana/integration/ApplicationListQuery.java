package pln.malik.montana.integration;

import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ApplicationListQuery {

  private final ComputationOccurrenceRepository computationOccurrenceRepository;

  public Mono<ApplicationListResponse> logic() {
    return computationOccurrenceRepository.findAll()
      .map(ComputationOccurrenceEntity::getApplicationUUID)
      .distinct()
      .collectList()
      .map(occurrences -> ApplicationListResponse.builder().applicationUUIDs(occurrences).build());
  }

  @Builder
  @Value
  public static class ApplicationListResponse {

    List<UUID> applicationUUIDs;

  }
}
