package com.nokhacode.userapp.exception;

import com.nokhacode.userapp.dto.ErrorDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<ErrorDetails> handleNotFoundException(NotFoundException ex){
        log.error(ex.getErrorMessage());
        ErrorDetails error = new ErrorDetails();
        error.setErrorCode(ex.getErrorCode());
        error.setMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler({BadRequest.class})
    public ResponseEntity<ErrorDetails> handleBadRequestException(BadRequest ex){
        log.error(ex.getErrorMessage());
        ErrorDetails error = new ErrorDetails();
        error.setErrorCode(ex.getErrorCode());
        error.setMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

}
