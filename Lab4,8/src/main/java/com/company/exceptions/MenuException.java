package com.company.exceptions;

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


