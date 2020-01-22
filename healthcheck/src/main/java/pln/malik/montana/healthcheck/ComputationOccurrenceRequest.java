package pln.malik.montana.healthcheck;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.UUID;

@Data
public class ComputationOccurrenceRequest {

  UUID applicationUUID;
  ComputationOccurrenceEntity.UserApplicationStatus status;


}
