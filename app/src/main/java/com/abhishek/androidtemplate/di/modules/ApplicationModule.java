package com.abhishek.androidtemplate.di.modules;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.abhishek.androidtemplate.data.NotesRepository;
import com.abhishek.androidtemplate.data.local.NoteDao;
import com.abhishek.androidtemplate.data.local.NoteDatabase;
import com.abhishek.androidtemplate.data.remote.NoteRemoteDatabase;
import com.abhishek.androidtemplate.di.scopes.PerApplication;

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
    NotesRepository provideNotesRepository() {return new NotesRepository(mApplication);}

    @Provides
    @PerApplication
    NoteDatabase provideNoteDatabase() {return this.mDatabase;}

    @Provides
    @PerApplication
    NoteDao provideNoteDao() {return this.mDatabase.noteDao();}

    @Provides
    @Singleton
    NoteRemoteDatabase provideNoteRemoteDatabase() {return new NoteRemoteDatabase();}
}
