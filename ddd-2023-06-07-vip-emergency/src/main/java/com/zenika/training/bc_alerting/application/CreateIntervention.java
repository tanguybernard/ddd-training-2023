package com.zenika.training.bc_alerting.application;

import com.zenika.training.bc_alerting.domain.intervention.domain_services.AssignTransporteur;
import com.zenika.training.bc_alerting.domain.transpoteur.Transporteur;
import com.zenika.training.bc_alerting.domain.ports.InterventionRepository;
import com.zenika.training.bc_alerting.domain.intervention.Clinique;
import com.zenika.training.bc_alerting.domain.intervention.Intervention;
import com.zenika.training.bc_alerting.domain.intervention.InterventionId;
import com.zenika.training.bc_alerting.domain.intervention.TransporteurId;
import com.zenika.training.shared.domain_event.DomainEventPublisher;

public class CreateIntervention {

    private final InterventionRepository interventionRepository;

    public CreateIntervention(InterventionRepository interventionRepository){

        this.interventionRepository = interventionRepository;
    }

    public Intervention execute(InterventionId id, TransporteurId idTransporteur, Clinique clinique){

        Transporteur t = new Transporteur();
        Intervention i = Intervention.create(id, clinique, idTransporteur);

        try {

            AssignTransporteur assignTransporteur = new AssignTransporteur(interventionRepository);
            assignTransporteur.check(i,t);
            this.interventionRepository.createIntervention(i);

        }
        catch (Exception e){

        }
        finally {
            i.pullDomainEvents().forEach(DomainEventPublisher::dispatch);
        }


        return i;

    }
}
