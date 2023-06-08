package com.zenika.training.bc_alerting.configuration;

import com.zenika.training.bc_alerting.application.CreateIntervention;
import com.zenika.training.bc_alerting.domain.ports.InterventionRepository;
import com.zenika.training.bc_alerting.infrastructure.postgres.intervention.InterventionDao;
import com.zenika.training.bc_alerting.infrastructure.postgres.intervention.InterventionMapper;
import com.zenika.training.bc_alerting.infrastructure.postgres.intervention.InterventionPgRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DIConfiguration {

    @Bean
    public InterventionRepository interventionRepository(InterventionDao dao){
        return new InterventionPgRepository(dao, new InterventionMapper());
    }


    @Bean
    public CreateIntervention createIntervention(InterventionRepository interventionRepository){
        return new CreateIntervention(interventionRepository);
    }

}
