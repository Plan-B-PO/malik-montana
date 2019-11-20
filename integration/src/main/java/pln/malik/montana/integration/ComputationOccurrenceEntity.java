package pln.malik.montana.integration;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
@Value
@Document(indexName = "computation-occurrence")
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
