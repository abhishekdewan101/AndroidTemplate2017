package abhishekdewan.com.androidtemplate.features.testfeature;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

import abhishekdewan.com.androidtemplate.R;
import abhishekdewan.com.androidtemplate.di.scopes.PerApplication;
import abhishekdewan.com.androidtemplate.features.BaseActivity;

public class MainActivity extends BaseActivity {

    @Inject
    @PerApplication
    Context mApplicatonContext;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getComponent().inject(this);
    }
}
