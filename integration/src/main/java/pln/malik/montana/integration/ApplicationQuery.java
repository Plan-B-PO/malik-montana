package pln.malik.montana.integration;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class ApplicationQuery {

  private final ComputationOccurrenceRepository computationOccurrenceRepository;

  public Mono<Response> logic(Mono<Request> request) {
    return null;
  }

  @Builder
  @Value
  public class Request {


  }

  @Builder
  @Value
  public class Response {

  }
}
