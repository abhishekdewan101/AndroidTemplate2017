package com.abhishek.androidtemplate;

import android.app.Application;

import com.abhishek.androidtemplate.di.components.ApplicationComponent;
import com.abhishek.androidtemplate.di.components.DaggerApplicationComponent;
import com.abhishek.androidtemplate.di.modules.ApplicationModule;

import timber.log.Timber;

/**
 * Template application that is used with dagger2 to
 * provide application wide dependency injection to
 * other activities and fragments.
 */

public class TemplateApplication extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        initTimber();
    }

    private void initTimber() {
        Timber.plant(new Timber.DebugTree());
    }
}
