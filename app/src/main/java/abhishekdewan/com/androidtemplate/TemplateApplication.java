package abhishekdewan.com.androidtemplate;

import android.app.Application;

import abhishekdewan.com.androidtemplate.di.components.ApplicationComponent;
import abhishekdewan.com.androidtemplate.di.components.DaggerApplicationComponent;
import abhishekdewan.com.androidtemplate.di.modules.ApplicationModule;

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
    }
}
