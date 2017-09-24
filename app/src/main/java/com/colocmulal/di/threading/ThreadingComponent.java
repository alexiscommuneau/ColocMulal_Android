package com.colocmulal.di.threading;

import com.colocmulal.utils.aspect.ThreadingAspect;

import dagger.Subcomponent;

@Subcomponent(modules = ThreadingModule.class)
public interface ThreadingComponent {
    void inject(ThreadingAspect aspect);
}
