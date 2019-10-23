package pln.malik.montana.healthcheck;

import lombok.Value;

import java.util.UUID;

@Value
public class ComputationOccurenceRequest {

  UUID applicationUUID;

  static class UserApplicationStatus {

  }
}
