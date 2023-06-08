package com.zenika.training.bc_alerting.domain.intervention;

import com.zenika.training.shared.ValueObjectId;

public class InterventionId extends ValueObjectId<String> {
    public InterventionId(String id) {
        super(id);
    }
}
