package com.totonero.bettypeservice.web.advice;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BetTypeMessage {

    SERVER_ERROR("An unexpected error has occurred. Please try again"),
    NOT_FOUND("Requested resource could not be found"),
    BAD_REQUEST("Bad request"),
    BAD_REQUEST_ENUM("Requested enum not exists");


    private final String message;
}
