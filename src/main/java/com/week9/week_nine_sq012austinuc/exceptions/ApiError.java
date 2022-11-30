package com.week9.week_nine_sq012austinuc.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {
    private HttpStatus statusCode;
    private String message;
    private String debugMessage;
}
