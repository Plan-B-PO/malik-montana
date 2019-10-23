package pln.malik.montana.healthcheck;

import lombok.Value;

import java.util.UUID;

@Value
public class ComputationOccurrenceRequest {

  UUID applicationUUID;
  UserApplicationStatus status;


  static enum UserApplicationStatus {
    SUBMITTED, ASSIGNED, WORKING, COMPLETED, FAILED, REJECTED, ABORTED, PAUSED, INTERACTION_REQUIRED

  }
}
