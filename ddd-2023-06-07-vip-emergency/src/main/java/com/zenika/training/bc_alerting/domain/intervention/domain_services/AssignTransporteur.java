package com.zenika.training.bc_alerting.domain.intervention.domain_services;

import com.zenika.training.bc_alerting.domain.intervention.Intervention;
import com.zenika.training.bc_alerting.domain.ports.InterventionRepository;
import com.zenika.training.bc_alerting.domain.transpoteur.Transporteur;
import com.zenika.training.bc_alerting.domain.intervention.events.AsignationTranspoteurFailedDomainEvent;

public class AssignTransporteur {

    private final InterventionRepository interventionRepository;

    public AssignTransporteur(InterventionRepository interventionRepository){

        this.interventionRepository = interventionRepository;
    }


    public void check(Intervention intervention, Transporteur transporteur) throws Exception {

        Transporteur t = new Transporteur();//repoIntervention.getIntenvtionActiveFor(transport)
        intervention.assignTranspoteur(t);

    }



}
