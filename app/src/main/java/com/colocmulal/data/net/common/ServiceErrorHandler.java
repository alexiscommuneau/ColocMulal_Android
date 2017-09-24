package com.colocmulal.data.net.common;

import com.colocmulal.data.net.retrofit.model.RestError;

public interface ServiceErrorHandler {
    void handleClientError(int code, RestError error);
}
