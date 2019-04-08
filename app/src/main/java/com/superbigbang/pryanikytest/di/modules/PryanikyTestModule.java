package com.superbigbang.pryanikytest.di.modules;

import com.superbigbang.pryanikytest.model.PryanikyTestApi;
import com.superbigbang.pryanikytest.model.PryanikyTestService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = {ApiModule.class})
public class PryanikyTestModule {

    @Provides
    @Singleton
    public PryanikyTestService providePryanikyTestService(PryanikyTestApi PryanikyTestApi) {
        return new PryanikyTestService(PryanikyTestApi);
    }
}