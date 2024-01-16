package net.local.poc.library.cqrs;

public interface Resolver<T extends Query> {
    void resolve(T query);
}
