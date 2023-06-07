package com.zenika.training.shared.infrastructure;

public interface IntegrationEventHandler<Event extends IntegrationEvent> {

    void handle(Event evt);
}
