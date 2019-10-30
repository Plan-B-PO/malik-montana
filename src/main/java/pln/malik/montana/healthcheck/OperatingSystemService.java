package pln.malik.montana.healthcheck;

import org.springframework.stereotype.Service;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.math.BigDecimal;

@Service
public class OperatingSystemService {

  private OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean() ;

  public BigDecimal getCpuLoad() {
    return BigDecimal.valueOf(osBean.getSystemLoadAverage());
  }
}
