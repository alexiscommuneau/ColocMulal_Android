package com.colocmulal.app.example.ui;

import android.support.annotation.StringRes;

import com.colocmulal.app.common.ViewContract;

public interface ExampleViewContract extends ViewContract {
    void showMessage(@StringRes int message);
}
