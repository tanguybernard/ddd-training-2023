package com.zenika.training.bc_alerting.domain.ports;

import com.zenika.training.bc_alerting.domain.intervention.Intervention;
import com.zenika.training.bc_alerting.domain.intervention.InterventionId;

public interface InterventionRepository {


    void createIntervention(Intervention intervention);

    Intervention getIntervention(InterventionId id);
}
