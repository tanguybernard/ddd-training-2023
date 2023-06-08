
package com.zenika.training.bc_alerting.infrastructure.postgres.intervention;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class InterventionEntity
{
    @Id
    public  String id;


    public String idTransporteur;
}
