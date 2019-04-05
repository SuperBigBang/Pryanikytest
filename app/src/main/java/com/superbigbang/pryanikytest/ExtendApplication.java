package com.superbigbang.pryanikytest;

import android.app.Application;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.superbigbang.pryanikytest.di.BaseComponent;
import com.superbigbang.pryanikytest.di.DaggerBaseComponent;
import com.superbigbang.pryanikytest.di.modules.ContextModule;

import timber.log.Timber;


public class ExtendApplication extends Application {

    private static BaseComponent sBaseComponent;

    public static BaseComponent getBaseComponent() {
        return sBaseComponent;
    }

    @VisibleForTesting
    public static void setBaseComponent(@NonNull BaseComponent baseComponent) {
        sBaseComponent = baseComponent;
    }

    public static Animation getAnimFadein() {
        return AnimationUtils.loadAnimation(ExtendApplication.getBaseComponent().getContext(), R.anim.fade_in);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
        sBaseComponent = DaggerBaseComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
    }
}