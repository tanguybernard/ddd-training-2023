package com.zenika.training.bc_alerting.infrastructure.postgres.intervention;

import com.zenika.training.bc_alerting.domain.intervention.*;

public class InterventionMapper {

    public InterventionEntity fromDomain(Intervention intervention){

        InterventionEntity interventionEntity = new InterventionEntity();
        interventionEntity.id = intervention.getId().id;
        interventionEntity.idTransporteur = intervention.getTransporteurId().id();

        return interventionEntity;

    }

    public Intervention toDomain(InterventionEntity it){

        return Intervention.load(
                new InterventionId(it.id),
                new Clinique(new CliniqueId("c123"), new Addresse(new CodePostal("00000"), "City")),//fake
                new TransporteurId(it.idTransporteur));

    }

}
