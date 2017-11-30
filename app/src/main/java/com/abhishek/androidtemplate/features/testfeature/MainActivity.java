package com.abhishek.androidtemplate.features.testfeature;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;

import com.abhishek.androidtemplate.R;
import com.abhishek.androidtemplate.data.model.Note;
import com.abhishek.androidtemplate.di.scopes.PerApplication;
import com.abhishek.androidtemplate.features.BaseActivity;
import com.abhishek.androidtemplate.viewmodels.TestViewModel;


import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

public class MainActivity extends BaseActivity {

    @Inject
    @PerApplication
    Context mApplicatonContext;

    @Inject
    TestViewModel mTestViewModel;

    CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getComponent().inject(this);

        mCompositeDisposable.add(mTestViewModel.loadAllNotes()
                .subscribeOn(Schedulers.io())
                .subscribe(notes -> {print(notes);},
                        throwable -> throwable.printStackTrace()));


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mCompositeDisposable.add(mTestViewModel.addNote(new Note("Title 4","Detail 4","11-23-2901",4))
                        .subscribe(aBoolean -> {
                                Timber.e("Added Note");
                                },
                                throwable -> throwable.printStackTrace()));
            }
        },12000);
    }

    private void print(Note note) {
            Timber.e(note.toString());
    }

    @Override
    protected void onDestroy() {
        if (mCompositeDisposable != null && !mCompositeDisposable.isDisposed()) {
            mCompositeDisposable.dispose();
        }
        super.onDestroy();
    }
}
