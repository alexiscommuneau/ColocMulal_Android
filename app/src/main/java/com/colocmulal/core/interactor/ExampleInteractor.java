package com.colocmulal.core.interactor;

import com.colocmulal.core.boundary.ExampleRepository;
import com.colocmulal.utils.threading.RunOnExecutionThread;
import com.colocmulal.utils.threading.RunOnPostExecutionThread;
import com.colocmulal.utils.trace.Trace;

import javax.inject.Inject;

public class ExampleInteractor {

    private final ExampleRepository repository;

    private ExampleListener listener;

    @Inject
    ExampleInteractor(ExampleRepository repository) {
        super();
        this.repository = repository;
    }

    @RunOnExecutionThread @Trace
    public void execute(ExampleListener listener) {
        this.listener = listener;
        handleSuccess(repository.getExampleMessage());
    }

    @RunOnPostExecutionThread
    private void handleSuccess(Integer result) {
        if (listener != null) {
            listener.onResult(result);
        }
    }

    public void done() {
        listener = null;
    }
}
