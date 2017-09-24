package com.colocmulal.di.example;

import com.colocmulal.app.example.ui.activity.ExampleActivity;
import com.colocmulal.di.PerActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@PerActivity
@Subcomponent(
    modules = {ExampleModule.class}
)
public interface ExampleSubcomponent extends AndroidInjector<ExampleActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ExampleActivity> {}
}
