package com.colocmulal.core.error;

public abstract class ColocMulal_AndroidException extends Exception {
    public ColocMulal_AndroidException() {
    }

    public ColocMulal_AndroidException(String message) {
        super(message);
    }

    public abstract int getId();
}
