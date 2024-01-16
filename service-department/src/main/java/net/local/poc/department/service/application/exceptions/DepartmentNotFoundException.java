package net.local.poc.department.service.application.exceptions;

public class DepartmentNotFoundException extends RuntimeException {

    public DepartmentNotFoundException() {
        super("Department not found");
    }
    
}
