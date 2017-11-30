package com.abhishek.androidtemplate.data;

import android.app.Application;

import com.abhishek.androidtemplate.TemplateApplication;
import com.abhishek.androidtemplate.data.local.NoteDao;
import com.abhishek.androidtemplate.data.model.Note;
import com.abhishek.androidtemplate.data.remote.NoteRemoteDatabase;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by abhishekdewan on 11/26/17.
 */

public class NotesRepository {

    @Inject
    public NoteDao mNoteDao;

    @Inject
    public NoteRemoteDatabase mNoteRemoteDatabase;

    public NotesRepository(Application application) {
        ((TemplateApplication)application).getComponent().inject(this);
    }

    public PublishSubject<Note> getAllNotes() {
        return mNoteRemoteDatabase.getAllNotes();
    }

    public Observable<Boolean> addNote(Note note){
        return mNoteRemoteDatabase.addNote(note);
    }

}
