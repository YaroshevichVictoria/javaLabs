package com.company.exception;

public class MenuException extends Exception {
    private int variant;

    public MenuException(String message, int variant) {
        super(message);
        this.variant = variant;
    }

    public int getVariant() {
        return this.variant;
    }
}