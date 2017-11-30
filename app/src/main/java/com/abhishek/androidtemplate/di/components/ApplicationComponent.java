package com.abhishek.androidtemplate.di.components;

import android.app.Application;

import javax.inject.Singleton;

import com.abhishek.androidtemplate.data.NotesRepository;
import com.abhishek.androidtemplate.data.local.NoteDao;
import com.abhishek.androidtemplate.data.local.NoteDatabase;
import com.abhishek.androidtemplate.data.remote.NoteRemoteDatabase;
import com.abhishek.androidtemplate.di.modules.ApplicationModule;
import com.abhishek.androidtemplate.di.scopes.PerApplication;

import dagger.Component;


/**
 * Created by abhishekdewan on 11/26/17.
 */

@Singleton
@PerApplication
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(NotesRepository notesRepository);

    Application provideApplication();
    NotesRepository provideNotesRepository();
    NoteDatabase provideNoteDatabase();
    NoteDao provideNoteDao();
    NoteRemoteDatabase provideRemoteDatabase();
}
