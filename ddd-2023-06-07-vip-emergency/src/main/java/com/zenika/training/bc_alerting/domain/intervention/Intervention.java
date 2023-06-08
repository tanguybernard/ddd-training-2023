package com.zenika.training.bc_alerting.domain.intervention;

import com.zenika.training.bc_alerting.domain.intervention.events.AsignationTranspoteurFailedDomainEvent;
import com.zenika.training.bc_alerting.domain.transpoteur.Transporteur;
import com.zenika.training.shared.AggregateRoot;

public class Intervention extends AggregateRoot<InterventionId> {
    private final Clinique clinique;
    private TransporteurId transporteurId;

    private Intervention(InterventionId interventionId, Clinique clinique, TransporteurId transporteurId) {
        super(interventionId);
        this.clinique = clinique;
        this.transporteurId = transporteurId;
    }


    public static Intervention create(InterventionId interventionId, Clinique clinique, TransporteurId transporteurId) {
        return new Intervention(interventionId, clinique, transporteurId);

    }

    public static Intervention load(InterventionId interventionId, Clinique clinique, TransporteurId transporteurId) {
        return new Intervention(interventionId, clinique, transporteurId);

    }

    public TransporteurId getTransporteurId() {
        return transporteurId;
    }

    public void changeTransporteur(TransporteurId transporteurId){
        this.transporteurId = transporteurId;
        //new ChangeTransporteurDomain();
    }

    public void assignTranspoteur(Transporteur transporteur) throws Exception {

        if(transporteur != null){
            this.transporteurId = transporteur.getId();
        }
        else {
            this.record(new AsignationTranspoteurFailedDomainEvent(this.getId()));
            throw new  Exception();
        }

    }

    public void changeTranspoteur(Transporteur transporteur) {

    }
}
