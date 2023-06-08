package com.zenika.training.bc_alerting.infrastructure.stubs;

import com.zenika.training.bc_alerting.domain.ports.InterventionRepository;
import com.zenika.training.bc_alerting.domain.intervention.Intervention;
import com.zenika.training.bc_alerting.domain.intervention.InterventionId;

import java.util.HashMap;

public class InMemoryInterventionRepository implements InterventionRepository {


    HashMap<InterventionId, Intervention> map = new HashMap<>();

    @Override
    public void createIntervention(Intervention intervention) {

        map.put(intervention.getId(), intervention);

    }

    @Override
    public Intervention getIntervention(InterventionId id) {
        return map.get(id);
    }
}
