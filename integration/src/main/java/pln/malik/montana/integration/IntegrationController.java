package pln.malik.montana.integration;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/log")
public class IntegrationController {
  private final ApplicationListQuery applicationListQuery;
  private final ApplicationQuery applicationQuery;

  @GetMapping
  public Mono<ResponseEntity<ApplicationListQuery.ApplicationListResponse>> getApplicationsList() {
    return applicationListQuery.logic().map(ResponseEntity::ok);
  }

  @GetMapping("/{applicationUUID}")
  public Mono<ResponseEntity<ApplicationQuery.ApplicationResponse>> getApplicationLogs(@PathVariable("applicationUUID") UUID uuid) {
    return applicationQuery.logic(Mono.just(uuid)).map(ResponseEntity::ok);
  }
}
