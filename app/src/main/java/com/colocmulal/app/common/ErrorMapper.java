package com.colocmulal.app.common;

import android.support.annotation.StringRes;

import com.colocmulal.R;
import com.colocmulal.core.error.Errors;

public class ErrorMapper {

    @StringRes
    public int getResId(int error) {
        switch (error) {
            case Errors.UNREACHABLE_SERVICE:
                return R.string.error_unreachable_service_message;
            case Errors.UNAVAILABLE_SERVICE:
                return R.string.error_unavailable_service_message;
            case Errors.GENERIC:
            default:
                return R.string.generic_error_message;
        }
    }
}
