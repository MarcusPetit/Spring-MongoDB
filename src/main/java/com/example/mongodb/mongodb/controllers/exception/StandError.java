package com.example.mongodb.mongodb.controllers.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StandError {
    private  Long timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    public StandError() {
    }

    public StandError(Long timestamp, Integer status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }
}
