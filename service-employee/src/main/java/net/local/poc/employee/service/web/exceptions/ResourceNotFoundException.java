package net.local.poc.employee.service.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        code = HttpStatus.NOT_FOUND,
        reason = "Resource not found with the given identifier")
public class ResourceNotFoundException extends RuntimeException {
}
