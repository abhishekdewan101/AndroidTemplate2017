package com.abhishek.androidtemplate.di.components;

import com.abhishek.androidtemplate.di.modules.ActivityModule;
import com.abhishek.androidtemplate.di.modules.ApplicationModule;
import com.abhishek.androidtemplate.di.scopes.PerActivity;
import com.abhishek.androidtemplate.features.testfeature.MainActivity;

import dagger.Component;

/**
 * Created by abhishekdewan on 11/26/17.
 */

@PerActivity
@Component(dependencies = {ApplicationComponent.class},modules = {ActivityModule.class})
public interface ActivityComponent {
    void inject(MainActivity mainActivity);
}
