package pln.malik.montana.integration;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.w3c.dom.Node;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Document(indexName = "computation-occurrence")
class ComputationOccurrenceEntity {
  @Id
  private String id;

  private UUID applicationUUID;

  private UserApplicationStatus status;

  private BigDecimal consumedCredits;

  private BigDecimal estimatedPrice;

  enum UserApplicationStatus {
    SUBMITTED, ASSIGNED, WORKING, COMPLETED, FAILED, REJECTED, ABORTED, PAUSED, INTERACTION_REQUIRED

  }
}
