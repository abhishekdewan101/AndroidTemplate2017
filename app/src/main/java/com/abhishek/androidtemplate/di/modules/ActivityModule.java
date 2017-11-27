package com.abhishek.androidtemplate.di.modules;

import android.content.Context;

import com.abhishek.androidtemplate.data.NotesRepository;
import com.abhishek.androidtemplate.di.scopes.PerActivity;
import com.abhishek.androidtemplate.viewmodels.TestViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by abhishekdewan on 11/26/17.
 */

@Module
public class ActivityModule {
    private Context mContext;

    public ActivityModule(Context context) {
        this.mContext = context;
    }

    @Provides
    @PerActivity
    Context provideActivityContext() {return this.mContext;}

    @Provides
    TestViewModel provideTestViewModel(NotesRepository notesRepository) {return new TestViewModel(notesRepository);}
}
