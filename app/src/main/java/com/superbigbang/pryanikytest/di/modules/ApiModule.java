package com.superbigbang.pryanikytest.di.modules;

import com.superbigbang.pryanikytest.model.PryanikyTestApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module(includes = {RetrofitModule.class})
public class ApiModule {
    @Provides
    @Singleton
    public PryanikyTestApi providePryanikyTestApi(Retrofit retrofit) {
        return retrofit.create(PryanikyTestApi.class);
    }
}
