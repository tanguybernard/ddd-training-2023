package com.zenika.training.shared.domain_event;

public interface EventHandler<Event extends DomainEvent> {

    void handle(Event evt) throws Exception;
}
