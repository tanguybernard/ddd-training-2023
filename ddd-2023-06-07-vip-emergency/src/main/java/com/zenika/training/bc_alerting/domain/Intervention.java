package com.zenika.training.bc_alerting.domain;

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

    public TransporteurId getTransporteurId() {
        return transporteurId;
    }

    public void changeTransporteur(TransporteurId transporteurId){
        this.transporteurId = transporteurId;
        //new ChangeTransporteurDomain();
    }
}
