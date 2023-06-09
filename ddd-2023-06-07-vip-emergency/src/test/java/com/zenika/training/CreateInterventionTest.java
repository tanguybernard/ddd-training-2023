package com.zenika.training;

import com.zenika.training.bc_alerting.application.CreateIntervention;
import com.zenika.training.bc_alerting.domain.intervention.*;
import com.zenika.training.bc_alerting.domain.ports.InterventionRepository;
import com.zenika.training.bc_alerting.infrastructure.stubs.InMemoryInterventionRepository;
import org.junit.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateInterventionTest {

    @Test
    public void createIntervention() {


        InterventionRepository interventionRepository = new InMemoryInterventionRepository();
        TransporteurId idTransporteur = new TransporteurId("t123");
        Clinique clinique = new Clinique(new CliniqueId("c123"), new Addresse(new CodePostal("00000"), "City"));
        InterventionId id = new InterventionId(UUID.randomUUID().toString());
        CreateIntervention useCase = new CreateIntervention(interventionRepository);

        Intervention intervention = useCase.execute(id, idTransporteur, clinique);

        assertThat(intervention.getTransporteurId().equals(idTransporteur)).isTrue();


    }


}
