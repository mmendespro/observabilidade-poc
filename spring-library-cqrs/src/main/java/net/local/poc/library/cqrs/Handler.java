package net.local.poc.library.cqrs;

public interface Handler<T extends Command> {
    void handle(T command);
}
