package com.colocmulal.core.error.exceptions;

import com.colocmulal.core.error.ColocMulal_AndroidException;
import com.colocmulal.core.error.Errors;

public class NetworkException extends ColocMulal_AndroidException {
    @Override public int getId() {
        return Errors.UNAVAILABLE_SERVICE;
    }
}
