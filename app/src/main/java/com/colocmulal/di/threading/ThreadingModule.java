package com.colocmulal.di.threading;

import com.colocmulal.utils.threading.JobExecutor;
import com.colocmulal.utils.threading.PostExecutionThread;
import com.colocmulal.utils.threading.ThreadExecutor;
import com.colocmulal.utils.threading.UiThread;

import dagger.Module;
import dagger.Provides;

@Module
public class ThreadingModule {

    @Provides
    ThreadExecutor provideExecutor(JobExecutor instance) {
        return instance;
    }

    @Provides
    PostExecutionThread providePostThread(UiThread instance) {
        return instance;
    }
}
