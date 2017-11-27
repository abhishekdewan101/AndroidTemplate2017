package com.abhishek.androidtemplate.di.components;

import javax.inject.Singleton;

import com.abhishek.androidtemplate.di.modules.ApplicationModule;
import com.abhishek.androidtemplate.di.scopes.PerApplication;
import com.abhishek.androidtemplate.features.testfeature.MainActivity;

import dagger.Component;


/**
 * Created by abhishekdewan on 11/26/17.
 */

@Singleton
@PerApplication
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MainActivity mainActivity);
}
