package com.colocmulal.di.common;

import android.app.Activity;

import com.colocmulal.app.example.ui.activity.ExampleActivity;
import com.colocmulal.di.PerActivity;
import com.colocmulal.di.example.ExampleSubcomponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@PerActivity
@Module(subcomponents = {ExampleSubcomponent.class})
public abstract class AndroidComponentsModule {

    @Binds
    @IntoMap
    @ActivityKey(ExampleActivity.class)
    abstract AndroidInjector.Factory<? extends Activity>
        bindExampleInjectorFactory(ExampleSubcomponent.Builder builder);
}
