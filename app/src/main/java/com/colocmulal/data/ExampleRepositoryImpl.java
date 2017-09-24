package com.colocmulal.data;

import android.support.annotation.StringRes;

import com.colocmulal.R;
import com.colocmulal.core.boundary.ExampleRepository;
import com.colocmulal.utils.trace.Trace;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ExampleRepositoryImpl implements ExampleRepository {

    @Inject ExampleRepositoryImpl( ) {}

    @Override @StringRes @Trace
    public int getExampleMessage() {
        return R.string.read_me;
    }
}
