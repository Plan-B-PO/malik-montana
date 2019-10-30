package pln.malik.montana.healthcheck;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RequestMapping(path = "/info")
public class UserApplicationController {

  private ComputationOccurrenceIndexerCommand computationOccurrenceIndexerCommand;

  @PostMapping
  public Mono<ResponseEntity<Void>> postInfo(@RequestBody Mono<ComputationOccurrenceRequest> request) {
    return computationOccurrenceIndexerCommand.execute(request).map(ResponseEntity::ok);
  }

}
