package net.local.poc.department.service.application.exceptions;

public class DepartmentNotEmptyException extends RuntimeException {

    public DepartmentNotEmptyException() {
        super("Department is not empty");
    }
    
}
