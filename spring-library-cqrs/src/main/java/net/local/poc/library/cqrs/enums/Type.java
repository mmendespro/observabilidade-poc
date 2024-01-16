package net.local.poc.library.cqrs.enums;

public enum Type {

    COMMAND("Command"),
    QUERY("Query");

    private String typeName;

    Type(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return typeName;
    }
}
