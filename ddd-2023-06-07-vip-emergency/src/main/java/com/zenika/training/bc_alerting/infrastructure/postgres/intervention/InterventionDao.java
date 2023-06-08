package com.zenika.training.bc_alerting.infrastructure.postgres.intervention;

import org.springframework.data.repository.CrudRepository;


public interface InterventionDao extends CrudRepository<InterventionEntity, String> {
}
