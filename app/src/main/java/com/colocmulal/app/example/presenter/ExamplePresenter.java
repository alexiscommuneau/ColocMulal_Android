package com.colocmulal.app.example.presenter;

import android.support.annotation.StringRes;

import com.colocmulal.app.common.Presenter;
import com.colocmulal.app.example.ui.ExampleViewContract;
import com.colocmulal.core.interactor.ExampleInteractor;
import com.colocmulal.core.interactor.ExampleListener;
import com.colocmulal.utils.trace.Trace;

import javax.inject.Inject;

public class ExamplePresenter extends Presenter<ExampleViewContract> implements ExampleListener {

    private boolean viewIsAlreadyLoadedWithData;

    private final ExampleInteractor interactor;

    @Inject ExamplePresenter(ExampleViewContract view, ExampleInteractor interactor) {
        super(view);
        this.interactor = interactor;
        viewIsAlreadyLoadedWithData = false;
    }

    @Trace
    public void start() {
        if (viewIsAlreadyLoadedWithData) {
            return;
        }
        interactor.execute(this);
    }

    @Trace
    public void stop() {
        interactor.done();
    }

    @Override @Deprecated @Trace
    public void onResult(@StringRes int message) {
        viewIsAlreadyLoadedWithData = true;
        view.showMessage(message);
    }
}
