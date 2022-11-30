package com.week9.week_nine_sq012austinuc.exceptions;

import lombok.Data;

@Data
public class InvalidRequestException extends RuntimeException {
    private String debugMessage;

    public InvalidRequestException(String message, String debugMessage) {
        super(message);
        this.debugMessage = debugMessage;
    }

    public InvalidRequestException(String message) {
        super(message);
    }
}
