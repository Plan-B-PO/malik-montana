package pln.malik.montana.healthcheck;

import lombok.Value;

import java.util.UUID;

@Value
public class ComputationOccurrenceRequest {

  UUID applicationUUID;
  ComputationOccurrenceEntity.UserApplicationStatus status;


}
