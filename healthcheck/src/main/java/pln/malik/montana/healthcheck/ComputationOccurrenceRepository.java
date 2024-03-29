package pln.malik.montana.healthcheck;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputationOccurrenceRepository extends ReactiveCrudRepository<ComputationOccurrenceEntity, String> {
}
