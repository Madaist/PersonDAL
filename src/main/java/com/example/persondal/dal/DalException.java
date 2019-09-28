package com.example.persondal.dal;

public class DalException extends Exception{

    private DalErrorCodes code;

    public DalException(DalErrorCodes code) {
        this.code = code;
    }

    public DalException(DalErrorCodes code, String message) {
        super(message);
        this.code = code;
    }

    public DalErrorCodes getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        if (super.getMessage() != null) {
            return super.getMessage();
        } else {
            return code.getMessage();
        }
    }

}

