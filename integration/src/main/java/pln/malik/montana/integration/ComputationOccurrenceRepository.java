package pln.malik.montana.integration;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Repository
public interface ComputationOccurrenceRepository extends ReactiveCrudRepository<ComputationOccurrenceEntity, String> {

  Flux<ComputationOccurrenceEntity> findAllByApplicationUUID(UUID uuid);
}
