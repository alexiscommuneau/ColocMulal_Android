package com.colocmulal.core.error.exceptions;

import com.colocmulal.core.error.ColocMulal_AndroidException;
import com.colocmulal.core.error.Errors;

public class MappingException extends ColocMulal_AndroidException {

    public MappingException() {
        /* no-op */
    }

    public MappingException(String message) {
        super(message);
    }

    @Override public int getId() {
        return Errors.MAPPING;
    }
}
