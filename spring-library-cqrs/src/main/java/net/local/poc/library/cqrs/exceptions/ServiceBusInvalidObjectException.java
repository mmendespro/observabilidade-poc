package net.local.poc.library.cqrs.exceptions;

import net.local.poc.library.cqrs.events.InternalEvent;

public class ServiceBusInvalidObjectException extends RuntimeException {

    public ServiceBusInvalidObjectException(InternalEvent event) {
        super(String.format("ServiceBus does not recognizes Object of type: %s",
                event.getSource().getClass().getCanonicalName()));
    }
}
