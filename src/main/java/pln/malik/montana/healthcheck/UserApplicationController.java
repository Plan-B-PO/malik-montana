package pln.malik.montana.healthcheck;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Controller
public class UserApplicationController {

  private ComputationOccurrenceIndexerCommand computationOccurrenceIndexerCommand;

  Mono<ServerResponse> postInfo(ServerRequest request) {
    return computationOccurrenceIndexerCommand.execute(request);
  }

  RouterFunction<ServerResponse> route;

  {
    RouterFunctions.route()
      .POST("/info", this::postInfo).build();
  }
}
