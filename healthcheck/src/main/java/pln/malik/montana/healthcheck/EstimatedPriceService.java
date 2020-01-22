package pln.malik.montana.healthcheck;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.ZonedDateTime;

@RequiredArgsConstructor
@Service
public class EstimatedPriceService {

  private final OperatingSystemService operatingSystemService;
  private final MalikProperties malikProperties;

  public BigDecimal calculate() {
   return malikProperties.priceFactor()
     .multiply(BigDecimal.valueOf(Duration.between(ZonedDateTime.now(), malikProperties.timeEnd()).getSeconds()) )
     .multiply(operatingSystemService.getCpuLoad());
  }
}
