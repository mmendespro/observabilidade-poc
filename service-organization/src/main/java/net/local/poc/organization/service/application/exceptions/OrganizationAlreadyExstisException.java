package net.local.poc.organization.service.application.exceptions;

public class OrganizationAlreadyExstisException extends RuntimeException {

    public OrganizationAlreadyExstisException() {
        super("Organization already exists");
    }

}
