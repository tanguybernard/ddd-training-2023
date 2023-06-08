package com.zenika.training.bc_alerting.domain.intervention.events;

import com.zenika.training.bc_alerting.domain.intervention.InterventionId;
import com.zenika.training.shared.domain_event.DomainEvent;

import java.util.Date;

public class AsignationTranspoteurFailedDomainEvent implements DomainEvent {

    Date occuredOn = new Date();

    public AsignationTranspoteurFailedDomainEvent(InterventionId id){
        occuredOn = new Date();
    }

}
