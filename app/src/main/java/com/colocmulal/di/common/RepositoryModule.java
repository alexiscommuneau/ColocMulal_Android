package com.colocmulal.di.common;

import com.colocmulal.core.boundary.ExampleRepository;
import com.colocmulal.data.ExampleRepositoryImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {
    @Provides @Singleton ExampleRepository provideExampleRepository(
        ExampleRepositoryImpl exampleRepository
    ) {
        return exampleRepository;
    }
}
