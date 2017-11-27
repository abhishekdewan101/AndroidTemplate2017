package com.abhishek.androidtemplate.features;

import android.support.v7.app.AppCompatActivity;
import com.abhishek.androidtemplate.di.components.ApplicationComponent;
import com.abhishek.androidtemplate.di.components.DaggerApplicationComponent;
import com.abhishek.androidtemplate.di.modules.ApplicationModule;

/**
 * Created by abhishekdewan on 11/26/17.
 */

public class BaseActivity extends AppCompatActivity {

    private ApplicationComponent mComponent;

    public ApplicationComponent getComponent() {
        if (mComponent == null) {
            mComponent = DaggerApplicationComponent
                    .builder()
                    .applicationModule(new ApplicationModule(this.getApplication()))
                    .build();
        }

        return mComponent;
    }
}
