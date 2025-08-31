package org.stockflow.exception;

import java.time.LocalDateTime;

public class ErrorResponse {
    private LocalDateTime timestamp;
    private String error;
    private String message;
    private int status;
    private String path;

    public ErrorResponse(LocalDateTime timestamp, String error, String message, int status, String path) {
        this.timestamp = timestamp;
        this.error = error;
        this.message = message;
        this.status = status;
        this.path = path;
    }

    // Getters only (you can add setters if needed)
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public String getPath() {
        return path;
    }
}
