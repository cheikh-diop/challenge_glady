package com.glady.userbenefit.exception;

public class BalanceNotEnoughtException extends RuntimeException {
    public BalanceNotEnoughtException(String message) {
        super(message);
    }
}

