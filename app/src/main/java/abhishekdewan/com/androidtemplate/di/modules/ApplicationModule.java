package abhishekdewan.com.androidtemplate.di.modules;

import android.app.Application;
import android.content.Context;

import abhishekdewan.com.androidtemplate.di.scopes.PerApplication;
import dagger.Module;
import dagger.Provides;

/**
 * Created by abhishekdewan on 11/26/17.
 */
@Module
public class ApplicationModule {
    Application mApplication;

    public ApplicationModule(Application application) {
        this.mApplication = application;
    }

    @Provides
    @PerApplication
    Context getApplicationContext() {return mApplication.getApplicationContext();}
}
