package pln.malik.montana.healthcheck;

import org.springframework.stereotype.Repository;

@Repository
public interface ElasticsearchRepository <DTO> {

  DTO indexComputationOccurrence(DTO dto);

}
