package com.abhishek.androidtemplate.features.testfeature;

import android.arch.lifecycle.Observer;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.abhishek.androidtemplate.R;
import com.abhishek.androidtemplate.data.model.Note;
import com.abhishek.androidtemplate.di.scopes.PerApplication;
import com.abhishek.androidtemplate.features.BaseActivity;
import com.abhishek.androidtemplate.viewmodels.TestViewModel;

import java.util.List;

import javax.inject.Inject;

import timber.log.Timber;


public class MainActivity extends BaseActivity {

    @Inject
    @PerApplication
    Context mApplicatonContext;

    @Inject
    TestViewModel mTestViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getComponent().inject(this);

        mTestViewModel.loadAllNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(@Nullable List<Note> notes) {
                Timber.d("Size of notes is " + notes.size());
            }
        });
    }
}
