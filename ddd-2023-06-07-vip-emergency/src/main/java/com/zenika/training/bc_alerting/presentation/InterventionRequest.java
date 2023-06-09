package com.zenika.training.bc_alerting.presentation;

// Fichier : InterventionRequest.java

public class InterventionRequest {

    private String idClinique;
    private String idTransporteur;

    public InterventionRequest(String idClinique, String idTransporteur) {
        this.idClinique = idClinique;
        this.idTransporteur = idTransporteur;
    }

    // Getters and setters

    public String getIdClinique() {
        return idClinique;
    }

    public void setIdClinique(String idClinique) {
        this.idClinique = idClinique;
    }

    public String getIdTransporteur() {
        return idTransporteur;
    }

    public void setIdTransporteur(String idTransporteur) {
        this.idTransporteur = idTransporteur;
    }
}

