package net.local.poc.department.service.application.exceptions;

public class DuplicateKeyException extends RuntimeException {

    public DuplicateKeyException() {
        super("Duplicated key found");
    }
    
}
