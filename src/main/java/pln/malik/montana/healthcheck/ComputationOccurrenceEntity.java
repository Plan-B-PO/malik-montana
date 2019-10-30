package pln.malik.montana.healthcheck;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
@Value
class ComputationOccurrenceEntity {
  @Id
  String id;

  UUID applicationUUID;

  UserApplicationStatus status;

  BigDecimal consumedCredits;

  BigDecimal estimatedPrice;

  enum UserApplicationStatus {
    SUBMITTED, ASSIGNED, WORKING, COMPLETED, FAILED, REJECTED, ABORTED, PAUSED, INTERACTION_REQUIRED

  }
}
