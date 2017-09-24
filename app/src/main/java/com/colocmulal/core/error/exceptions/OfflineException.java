package com.colocmulal.core.error.exceptions;

import com.colocmulal.core.error.Errors;
import com.colocmulal.core.error.ColocMulal_AndroidException;

public class OfflineException extends ColocMulal_AndroidException {
    @Override public int getId() {
        return Errors.OFFLINE;
    }
}
