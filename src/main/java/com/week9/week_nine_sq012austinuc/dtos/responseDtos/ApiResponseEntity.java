package com.week9.week_nine_sq012austinuc.dtos.responseDtos;

import lombok.*;
import org.springframework.http.HttpStatus;

@Data
public class ApiResponseEntity<T> {
    private String statusMessage;
    private HttpStatus status;
    private T data;

    public ApiResponseEntity (T data, String statusMessage, HttpStatus status) {
        this.status = status;
        this.data = data;
        this.statusMessage = statusMessage;
    }

}
