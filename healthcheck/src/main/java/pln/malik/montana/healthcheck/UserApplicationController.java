package pln.malik.montana.healthcheck;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/info")
public class UserApplicationController {

  private final ComputationOccurrenceIndexerCommand computationOccurrenceIndexerCommand;

  @PostMapping
  public Mono<ResponseEntity<Void>> postInfo(@RequestBody ComputationOccurrenceRequest request) {
    return computationOccurrenceIndexerCommand.execute(Mono.just(request)).map(ResponseEntity::ok);
  }

}
