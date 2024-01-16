package net.local.poc.organization.service.application.exceptions;

public class OrganizationNotFoundException extends RuntimeException {

    public OrganizationNotFoundException() {
        super("Organization not found");
    }
}
