package com.colocmulal.core.error.exceptions;

import com.colocmulal.core.error.ColocMulal_AndroidException;
import com.colocmulal.core.error.Errors;

public class UnexpectedException extends ColocMulal_AndroidException {
    @Override public int getId() {
        return Errors.GENERIC;
    }
}
