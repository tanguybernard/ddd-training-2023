package com.zenika.training;

import com.zenika.training.bc_alerting.application.CreateIntervention;
import com.zenika.training.bc_alerting.domain.*;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateInterventionTest {

@Test

    public void createIntervention(){

    //GIVEN
    TransporteurId idTransporteur = new TransporteurId("t123");
    Clinique clinique = new Clinique(new CliniqueId("c123"), new Addresse(new CodePostal("00000"), "City"));

    //WHEN
    CreateIntervention useCase = new CreateIntervention();
    Intervention intervention = useCase.execute(idTransporteur, clinique);

    //THEN

    assertThat(intervention.getTransporteurId().equals(idTransporteur));






    }


}
