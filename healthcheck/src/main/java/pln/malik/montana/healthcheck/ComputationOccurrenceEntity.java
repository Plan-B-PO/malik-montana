package pln.malik.montana.healthcheck;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Builder;
import lombok.Data;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
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
