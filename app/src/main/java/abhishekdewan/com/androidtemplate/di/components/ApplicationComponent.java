package abhishekdewan.com.androidtemplate.di.components;

import javax.inject.Singleton;

import abhishekdewan.com.androidtemplate.di.scopes.PerApplication;
import abhishekdewan.com.androidtemplate.features.testfeature.MainActivity;
import dagger.Component;
import abhishekdewan.com.androidtemplate.di.modules.ApplicationModule;

/**
 * Created by abhishekdewan on 11/26/17.
 */

@Singleton
@PerApplication
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MainActivity mainActivity);
}
