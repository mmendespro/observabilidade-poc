package net.local.poc.library.cqrs;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import net.local.poc.library.cqrs.events.CommandEvent;
import net.local.poc.library.cqrs.events.InternalEvent;
import net.local.poc.library.cqrs.events.QueryEvent;
import net.local.poc.library.cqrs.exceptions.ServiceBusInvalidObjectException;

@Component
public class ServiceBus {

    private ApplicationContext context;
    private ApplicationEventPublisher publisher;

    public ServiceBus(ApplicationContext context, ApplicationEventPublisher publisher) {
        this.context = context;
        this.publisher = publisher;
    }

    public void execute(Command command) {
        var event = new CommandEvent(command);
        execute(event);
    }

    public void execute(Query query) {
        var event = new QueryEvent(query);
        execute(event);
    }

    private void execute(InternalEvent event) {
        try {
            run(event);
        } catch (Exception exception) {
            event.setException(exception);
            throw exception;
        } finally {
            event.stopTimer();
            publisher.publishEvent(event);
        }
    }

    @SuppressWarnings("unchecked")
    private void run(InternalEvent event) {
        var beanName = event.getOrigin().substring(0, 1).toLowerCase() + event.getOrigin().substring(1);
        switch (event.getType()) {
            case COMMAND: 
                var handlerBeanName = beanName.replace("Command", "Handler");
                Handler<Command> handler = context.getBean(handlerBeanName, Handler.class);
                handler.handle((Command) event.getSource());
            break;
            case QUERY:
                var resolverBeanName = beanName.replace("Query", "Resolver");
                Resolver<Query> resolver = context.getBean(resolverBeanName, Resolver.class);
                resolver.resolve((Query) event.getSource());
            break;
            default:  throw new ServiceBusInvalidObjectException(event);
        }
    }
}
