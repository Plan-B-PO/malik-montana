package pln.malik.montana.healthcheck;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Service
public class ConsumedCreditsService {

  public BigDecimal calculate() {
    return BigDecimal.ZERO;
  }
}
