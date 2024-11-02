package com.example.rohit.rest.entity;

public class StudentErrorResponse {

    private Integer response;
    private String message;
    private Long timeStamp;

    public StudentErrorResponse(Integer response, String message, Long timeStamp) {
        this.response = response;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public StudentErrorResponse() {
    }

    public Integer getResponse() {
        return response;
    }

    public void setResponse(Integer response) {
        this.response = response;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
