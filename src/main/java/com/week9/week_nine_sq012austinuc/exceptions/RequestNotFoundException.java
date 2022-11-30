package com.week9.week_nine_sq012austinuc.exceptions;

import lombok.Data;

@Data
public class RequestNotFoundException extends RuntimeException {
    private String debugMessage;

    public RequestNotFoundException(String message, String debugMessage) {
        super(message);
        this.debugMessage = debugMessage;
    }

    public RequestNotFoundException(String message) {
        super(message);
    }
}
