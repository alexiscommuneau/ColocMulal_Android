package com.colocmulal.core.error.exceptions;

import android.support.annotation.Nullable;

import com.colocmulal.core.error.Errors;
import com.colocmulal.core.error.ColocMulal_AndroidException;

public class ServerClientException extends ColocMulal_AndroidException {

    private final String message;

    public ServerClientException(@Nullable String message) {
        this.message = message;
    }

    public String getServerMessage() {
        return message;
    }

    @Override public int getId() {
        return Errors.SERVER_CLIENT;
    }
}
