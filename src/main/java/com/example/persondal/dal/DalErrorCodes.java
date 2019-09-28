package com.example.persondal.dal;

public enum DalErrorCodes {

    ID_NOT_FOUND("The id could not be found"),
    TECHNICAL_ERROR("Technical error");

    private String message;

    DalErrorCodes(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}