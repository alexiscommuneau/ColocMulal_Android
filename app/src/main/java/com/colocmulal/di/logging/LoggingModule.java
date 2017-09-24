package com.colocmulal.di.logging;

import com.colocmulal.BuildConfig;
import com.colocmulal.Settings;
import com.colocmulal.utils.logging.Logger;
import com.colocmulal.utils.logging.NoOpLogger;
import com.colocmulal.utils.logging.TimberLogger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class LoggingModule {

    protected static final boolean SHOW_HASH = Settings.logging.show_hashs;
    protected static final boolean ENABLED = Settings.logging.enabled;

    @Provides @Singleton
    Logger provideLogger() {
        return getLogger();
    }

    protected Logger getLogger() {
        if (BuildConfig.DEBUG && ENABLED) {
            return new TimberLogger(SHOW_HASH);
        }
        return new NoOpLogger();
    }
}
