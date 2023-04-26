package org.example.pong.request;

public class PongRequest {

    private String message;

    public PongRequest(String message) {
        this.message = message;
    }

    public PongRequest() {}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
