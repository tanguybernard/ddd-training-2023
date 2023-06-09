package com.zenika.training.shared;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class Entity<Id> {

    protected Id id;

    public Entity(Id id) {
        requireNonNull(id);
        this.id = id;
    }

    protected Entity() {
        // For persistence
    }

    public Id getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity<?> entity = (Entity<?>) o;
        return Objects.equals(id, entity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}