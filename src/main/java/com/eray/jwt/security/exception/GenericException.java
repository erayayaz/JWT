package com.eray.jwt.security.exception;

import lombok.Getter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class GenericException extends RuntimeException {
    private HttpStatus httpStatus;
    private ErrorCode errorCode;
    private String errorMessage;
}
