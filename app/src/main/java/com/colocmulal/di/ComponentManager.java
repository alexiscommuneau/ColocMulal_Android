package com.colocmulal.di;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.colocmulal.di.common.ApplicationComponent;
import com.colocmulal.di.common.DaggerApplicationComponent;
import com.colocmulal.di.common.PreferencesModule;
import com.colocmulal.di.common.RepositoryModule;
import com.colocmulal.di.common.ServiceModule;
import com.colocmulal.di.crashes.CrashesComponent;
import com.colocmulal.di.crashes.CrashesModule;
import com.colocmulal.di.logging.LoggingComponent;
import com.colocmulal.di.logging.LoggingModule;
import com.colocmulal.di.threading.ThreadingComponent;
import com.colocmulal.di.threading.ThreadingModule;
import com.colocmulal.di.trace.TracerModule;

import java.io.File;

public class ComponentManager {

    private static ApplicationComponent applicationComponent;
    private static LoggingComponent loggingComponent;
    private static ThreadingComponent threadingComponent;
    private static CrashesComponent crashesComponent;

    public static void init(
        SharedPreferences preferences, File cacheDirectory, Context applicationContext
    ) {
        CrashesModule crashesModule = new CrashesModule();
        LoggingModule loggingModule = new LoggingModule();
        PreferencesModule preferencesModule = new PreferencesModule(preferences);
        ServiceModule serviceModule = new ServiceModule(cacheDirectory, applicationContext);
        TracerModule tracerModule = new TracerModule();
        RepositoryModule repositoryModule = new RepositoryModule();
        initApplicationComponent(
            loggingModule,
            preferencesModule,
            serviceModule,
            tracerModule,
            repositoryModule
        );
        initLoggingComponent();
        ThreadingModule threadingModule = new ThreadingModule();
        initThreadingComponent(threadingModule);
        initCrashesComponent(crashesModule);
    }

    public static ApplicationComponent getApplicationComponent() {
        return safeReturn(applicationComponent);
    }

    public static LoggingComponent getLoggingComponent() {
        return safeReturn(loggingComponent);
    }

    public static ThreadingComponent getThreadingComponent() {
        return safeReturn(threadingComponent);
    }

    public static CrashesComponent getCrashesComponent() {
        return safeReturn(crashesComponent);
    }

    private static void initApplicationComponent(
        LoggingModule loggingModule,
        PreferencesModule preferencesModule,
        ServiceModule serviceModule,
        TracerModule tracerModule,
        RepositoryModule repositoryModule
    ) {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .loggingModule(loggingModule)
            .tracerModule(tracerModule)
            .preferencesModule(preferencesModule)
            .serviceModule(serviceModule)
            .repositoryModule(repositoryModule)
            .build();
    }

    private static void initLoggingComponent() {
        loggingComponent = applicationComponent.loggingComponentBuilder().build();
    }

    private static void initThreadingComponent(ThreadingModule threadingModule) {
        threadingComponent = applicationComponent.plus(threadingModule);
    }

    private static void initCrashesComponent(CrashesModule crashesModule) {
        crashesComponent = applicationComponent.plus(crashesModule);
    }

    @NonNull
    private static <C> C safeReturn(C component) {
        if (component == null) {
            fail();
        }
        return component;
    }

    private static void fail() {
        String message = "ComponentManager.init() was not called on Application#onCreate()";
        throw new RuntimeException(message);
    }
}
