package com.colocmulal.di.common;

import com.colocmulal.app.ColocMulal_AndroidApplication;
import com.colocmulal.core.boundary.ExampleRepository;
import com.colocmulal.di.crashes.CrashesComponent;
import com.colocmulal.di.crashes.CrashesModule;
import com.colocmulal.di.logging.LoggingComponent;
import com.colocmulal.di.logging.LoggingModule;
import com.colocmulal.di.threading.ThreadingComponent;
import com.colocmulal.di.threading.ThreadingModule;
import com.colocmulal.di.trace.TracerModule;
import com.colocmulal.utils.logging.Logger;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
    LoggingModule.class,
    PreferencesModule.class,
    ServiceModule.class,
    TracerModule.class,
    RepositoryModule.class,
    AndroidInjectionModule.class,
    AndroidSupportInjectionModule.class,
    AndroidComponentsModule.class
})
public interface ApplicationComponent {
    void inject(ColocMulal_AndroidApplication application);

    Logger logger();

    ExampleRepository exampleRepository();

    LoggingComponent.Builder loggingComponentBuilder();
    CrashesComponent plus(CrashesModule module);
    ThreadingComponent plus(ThreadingModule module);
}
