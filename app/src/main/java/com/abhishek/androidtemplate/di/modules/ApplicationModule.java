package com.abhishek.androidtemplate.di.modules;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.abhishek.androidtemplate.data.NotesRepository;
import com.abhishek.androidtemplate.data.local.NoteDao;
import com.abhishek.androidtemplate.data.local.NoteDatabase;
import com.abhishek.androidtemplate.di.scopes.PerActivity;
import com.abhishek.androidtemplate.di.scopes.PerApplication;
import com.abhishek.androidtemplate.viewmodels.TestViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by abhishekdewan on 11/26/17.
 */
@Module
public class ApplicationModule {
    Application mApplication;
    NoteDatabase mDatabase;

    public ApplicationModule(Application application) {
        this.mApplication = application;
        mDatabase = Room.databaseBuilder(mApplication,
                NoteDatabase.class,
                "Notes.db").build();
    }

    @Provides
    @PerApplication
    Application provideApplication() {return mApplication;}

    @Provides
    @Singleton
    NotesRepository provideNotesRepository(NoteDao noteDao) {return new NotesRepository(noteDao);}

    @Provides
    @PerApplication
    NoteDatabase provideNoteDatabase() {return this.mDatabase;}

    @Provides
    @PerApplication
    NoteDao provideNoteDao() {return this.mDatabase.noteDao();}
}
