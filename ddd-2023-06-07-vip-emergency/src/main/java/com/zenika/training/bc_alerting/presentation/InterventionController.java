package com.zenika.training.bc_alerting.presentation;

// Fichier : InterventionController.java

import com.zenika.training.bc_alerting.application.CreateIntervention;
import com.zenika.training.bc_alerting.domain.intervention.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/interventions")
public class InterventionController {

    @Autowired
    private final CreateIntervention createIntervention;

    public InterventionController(CreateIntervention createIntervention) {
        this.createIntervention = createIntervention;
    }

    @PostMapping
    public ResponseEntity<InterventionResponse> createIntervention(
            @RequestBody InterventionRequest request) {


        InterventionId id = new InterventionId(UUID.randomUUID().toString());
        Clinique clinique = new Clinique(new CliniqueId(request.getIdClinique()), new Addresse(new CodePostal("00000"), "City"));

        Intervention intervention = createIntervention.execute(
                id,
                new TransporteurId(request.getIdTransporteur()),
                clinique
        );

        InterventionResponse response = new InterventionResponse(intervention.getId().id);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}

