package net.local.poc.employee.service.application.exceptions;

public class DuplicateKeyException extends RuntimeException {

    public DuplicateKeyException() {
        super("Duplicated key found");
    }
    
}
