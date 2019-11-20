package pln.malik.montana.integration;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ApplicationListQuery {

  private final ComputationOccurrenceRepository computationOccurrenceRepository;

  public Mono<Response> logic(Mono<Request> request) {
    computationOccurrenceRepository.findAll().map(entity ->
      Response.ComputationOccurrence.builder()
        .applicationUUID(entity.getApplicationUUID())
        .id(entity.getId())
        .build()

    )
      .collectList()
      .map( occurrences)
    return null;
  }

  @Builder
  @Value
  public class Request {



  }

  @Builder
  @Value
  public class Response {

    List<ComputationOccurrence> applicationList;

    @Builder
    @Value
    public class ComputationOccurrence {
      String id;
      UUID applicationUUID;
    }



  }
}
