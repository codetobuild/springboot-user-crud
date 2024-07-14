package com.nokhacode.userapp.exception;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class BadRequest extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    private String errorCode;
    private String errorMessage;

    public BadRequest(String errorCode, String errorMessage){
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public BadRequest(String errorCode, String errorMessage, Throwable cause){
        super(errorMessage, cause);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
