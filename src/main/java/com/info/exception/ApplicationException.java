package com.info.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

@Getter
@NoArgsConstructor
public class ApplicationException extends RuntimeException {

    private HttpStatus status;
    private String message;
    private Throwable cause;
    private List<ApplicationError> errors;

    public ApplicationException(HttpStatus status, String message, List<ApplicationError> errors) {
        super(message);
        this.status = status;
        this.errors = errors;
        this.message = message;

    }

    public ApplicationException(HttpStatus status, String message, ApplicationError error) {
        this(status, message, Collections.singletonList(error));
    }


}
