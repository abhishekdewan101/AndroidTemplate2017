package com.abhishek.androidtemplate.features;

import android.support.v7.app.AppCompatActivity;

import com.abhishek.androidtemplate.TemplateApplication;
import com.abhishek.androidtemplate.di.components.ActivityComponent;
import com.abhishek.androidtemplate.di.components.ApplicationComponent;
import com.abhishek.androidtemplate.di.components.DaggerActivityComponent;
import com.abhishek.androidtemplate.di.modules.ActivityModule;

/**
 * Created by abhishekdewan on 11/26/17.
 */

public class BaseActivity extends AppCompatActivity {

    private ActivityComponent mComponent;

    public ActivityComponent getComponent() {
        if (mComponent == null) {
            mComponent = DaggerActivityComponent
                    .builder()
                    .applicationComponent(((TemplateApplication)getApplication()).getComponent())
                    .activityModule(new ActivityModule(this))
                    .build();
        }

        return mComponent;
    }
}
