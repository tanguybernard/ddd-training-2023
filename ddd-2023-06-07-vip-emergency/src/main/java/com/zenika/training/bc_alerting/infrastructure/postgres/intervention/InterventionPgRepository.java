package com.zenika.training.bc_alerting.infrastructure.postgres.intervention;

import com.zenika.training.bc_alerting.domain.intervention.*;
import com.zenika.training.bc_alerting.domain.ports.InterventionRepository;

public class InterventionPgRepository implements InterventionRepository {


    private final InterventionDao interventionDao;
    private final InterventionMapper interventionMapper;

    public InterventionPgRepository(InterventionDao interventionDao, InterventionMapper interventionMapper){

        this.interventionDao = interventionDao;
        this.interventionMapper = interventionMapper;
    }
    @Override
    public void createIntervention(Intervention intervention) {
         interventionDao.save(this.interventionMapper.fromDomain(intervention));

    }

    @Override
    public Intervention getIntervention(InterventionId id) {

        return (interventionDao.findById(id.id)
                .stream()
                .map(interventionMapper::toDomain)
                .findAny()
                .orElseThrow(() -> new RuntimeException("message")));
    }
}
