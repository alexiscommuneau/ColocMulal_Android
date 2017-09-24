package com.colocmulal.di.logging;

import com.colocmulal.app.common.BaseActivity;
import com.colocmulal.app.common.BaseDialog;
import com.colocmulal.app.common.BaseDialogFragment;
import com.colocmulal.app.common.BaseFragment;
import com.colocmulal.app.common.BaseIntentService;
import com.colocmulal.app.common.BaseService;
import com.colocmulal.utils.aspect.TracerAspect;

import dagger.Subcomponent;

@Subcomponent
public interface LoggingComponent {
    void inject(BaseActivity injected);
    void inject(BaseDialog injected);
    void inject(BaseDialogFragment injected);
    void inject(BaseFragment injected);
    void inject(BaseIntentService injected);
    void inject(BaseService injected);

    void inject(TracerAspect tracerAspect);

    @Subcomponent.Builder
    interface Builder {
        LoggingComponent build();
    }
}
