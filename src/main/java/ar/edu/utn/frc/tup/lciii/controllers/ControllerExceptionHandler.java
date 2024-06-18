package ar.edu.utn.frc.tup.lciii.controllers;

import ar.edu.utn.frc.tup.lciii.dtos.common.ErrorApi;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.support.MetaDataAccessException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorApi> handlerError(Exception exception){
        ErrorApi error = buildError(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    @ExceptionHandler(MetaDataAccessException.class)
    public ResponseEntity<ErrorApi> handlerError(MethodArgumentNotValidException exception){
        ErrorApi error = buildError(exception.getMessage(), HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorApi> handlerError(ResponseStatusException exception){
        ErrorApi error = buildError(exception.getReason(), HttpStatus.valueOf(exception.getStatusCode().value()));
        return ResponseEntity.status(exception.getStatusCode()).body(error);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorApi> handlerError(EntityNotFoundException exception){
        ErrorApi error = buildError(exception.getMessage(), HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    private ErrorApi buildError(String message, HttpStatus status) {
        return ErrorApi.builder()
                .timestamp(String.valueOf(Timestamp.from(ZonedDateTime.now().toInstant())))
                .error(status.getReasonPhrase())
                .status(status.value())
                .message(message).build();
    }
}
