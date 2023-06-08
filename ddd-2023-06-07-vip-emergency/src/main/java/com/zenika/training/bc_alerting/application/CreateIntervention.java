package com.zenika.training.bc_alerting.application;

import com.zenika.training.bc_alerting.domain.Clinique;
import com.zenika.training.bc_alerting.domain.Intervention;
import com.zenika.training.bc_alerting.domain.InterventionId;
import com.zenika.training.bc_alerting.domain.TransporteurId;

import java.util.UUID;

public class CreateIntervention {


    public Intervention execute(TransporteurId idTransporteur, Clinique clinique){


        InterventionId id = new InterventionId(UUID.randomUUID().toString());

        return Intervention.create(id, clinique, idTransporteur);

    }
}
