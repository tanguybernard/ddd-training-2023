package com.zenika.training;

import com.zenika.training.bc_alerting.infrastructure.postgres.intervention.InterventionPgRepository;
import com.zenika.training.bc_alerting.infrastructure.stubs.InMemoryInterventionRepository;
import com.zenika.training.bc_alerting.application.CreateIntervention;
import com.zenika.training.bc_alerting.domain.ports.InterventionRepository;
import com.zenika.training.bc_alerting.domain.intervention.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CreateInterventionIntegrationTest {


    @Autowired
    InterventionRepository interventionRepository;

    @Test
    public void createInterventionInteg() {

        TransporteurId idTransporteur = new TransporteurId("t123");
        Clinique clinique = new Clinique(new CliniqueId("c123"), new Addresse(new CodePostal("00000"), "City"));
        InterventionId id = new InterventionId(UUID.randomUUID().toString());
        CreateIntervention useCase = new CreateIntervention(interventionRepository);

        useCase.execute(id, idTransporteur, clinique);

        assertThat(interventionRepository.getIntervention(id).getTransporteurId().equals(new TransporteurId("t123"))).isTrue();

    }


}
