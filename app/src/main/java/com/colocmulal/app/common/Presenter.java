package com.colocmulal.app.common;

public abstract class Presenter<T extends ViewContract> {
    protected final T view;

    protected Presenter(T view) {
        this.view = view;
    }
}
