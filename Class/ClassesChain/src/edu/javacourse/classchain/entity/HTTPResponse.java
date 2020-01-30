package edu.javacourse.classchain.entity;

public class HTTPResponse {
    private String body;

    public HTTPResponse(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
