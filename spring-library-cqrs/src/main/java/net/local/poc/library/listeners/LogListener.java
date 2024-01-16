package net.local.poc.library.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import net.local.poc.library.cqrs.events.InternalEvent;

@Component
public class LogListener {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Async
    @EventListener
    void onEvent(InternalEvent event) {
        if (event.isSuccess()) {
            logger.info(event.toJson());
        } else {
            logger.error(event.toJson(), event.getException());
        }
    }
}
