package pln.malik.montana.healthcheck;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Component
@ConfigurationProperties(prefix = "malik")
@Data
public class MalikProperties {
  private String timeStart;
  private String timeEnd;
  private String priceFactor;

  public ZonedDateTime timeStart() {
    return ZonedDateTime.parse(timeStart);
  }

  public ZonedDateTime timeEnd() {
    return ZonedDateTime.parse(timeEnd);
  }

  public BigDecimal priceFactor() {
    return BigDecimal.valueOf(Double.parseDouble(priceFactor));
  }


}
