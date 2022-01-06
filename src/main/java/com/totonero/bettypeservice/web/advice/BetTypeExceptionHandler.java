package com.totonero.bettypeservice.web.advice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.ResponseEntity.status;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.totonero.bettypeservice.exceptions.BadRequestException;
import com.totonero.bettypeservice.exceptions.ResourceNotFoundException;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class BetTypeExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(BetTypeExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(final Exception e) {
        log.info("stage=error, internal, exception={}", e.getLocalizedMessage());
        return status(INTERNAL_SERVER_ERROR)
                .body(this.constructErrorResponse(INTERNAL_SERVER_ERROR, BetTypeMessage.SERVER_ERROR.getMessage()));
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleNotFound(final Exception e) {
        return status(NOT_FOUND)
                .body(this.constructErrorResponse(NOT_FOUND, BetTypeMessage.NOT_FOUND.getMessage()));
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<ErrorResponse> handleBadRequest(final Exception e) {
        log.info("stage=error, bad-request, exception={}", e.getLocalizedMessage());
        return status(BAD_REQUEST)
                .body(this.constructErrorResponse(BAD_REQUEST, BetTypeMessage.BAD_REQUEST.getMessage()));
    }

    @ExceptionHandler({MethodArgumentTypeMismatchException.class, HttpMessageNotReadableException.class, InvalidFormatException.class})
    public ResponseEntity<ErrorResponse> handleBadRequestEnum(final Exception e) {
        log.info("stage=error, bad-request, exception={}", e.getLocalizedMessage());
        return status(BAD_REQUEST)
                .body(this.constructErrorResponse(BAD_REQUEST, BetTypeMessage.BAD_REQUEST_ENUM.getMessage()));
    }

    private ErrorResponse constructErrorResponse(final HttpStatus httpStatus, final String messages) {
        return ErrorResponse.builder()
                .timestamp(Instant.now())
                .status(httpStatus.value())
                .error(httpStatus.getReasonPhrase())
                .message(messages)
                .build();
    }

    @Setter
    @Getter
    @Builder
    private static class ErrorResponse {
        private Instant timestamp;

        private int status;

        private String error;

        @JsonProperty("error_description")
        private String message;
    }
}
