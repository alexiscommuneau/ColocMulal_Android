package com.colocmulal.di.example;

import android.content.Context;

import com.colocmulal.app.example.ui.ExampleViewContract;
import com.colocmulal.app.example.ui.activity.ExampleActivity;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ExampleModule {
    @Binds abstract Context context(ExampleActivity activity);
    @Binds abstract ExampleViewContract viewContract(ExampleActivity activity);
}
