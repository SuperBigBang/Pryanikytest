package com.superbigbang.pryanikytest.di;

import android.content.Context;

import com.superbigbang.pryanikytest.adapter.provider.PryanikyTestModule;
import com.superbigbang.pryanikytest.di.modules.ContextModule;
import com.superbigbang.pryanikytest.model.PryanikyTestService;
import com.superbigbang.pryanikytest.screen.topLevelActivity.TopLevelPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ContextModule.class, PryanikyTestModule.class})
public interface BaseComponent {
    Context getContext();
    PryanikyTestService getPryanikyTestService();

    void inject(TopLevelPresenter presenter);
}
