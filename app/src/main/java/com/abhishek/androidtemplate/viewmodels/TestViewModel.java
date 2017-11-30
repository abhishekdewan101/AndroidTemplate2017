package com.abhishek.androidtemplate.viewmodels;

import android.arch.lifecycle.ViewModel;

import com.abhishek.androidtemplate.data.NotesRepository;
import com.abhishek.androidtemplate.data.model.Note;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by abhishekdewan on 11/26/17.
 */

@Singleton
public class TestViewModel extends ViewModel {

    NotesRepository mNotesRepository;

    @Inject
    public TestViewModel(NotesRepository notesRepository) {
        this.mNotesRepository = notesRepository;
    }

    public PublishSubject<Note> loadAllNotes() {
        return mNotesRepository.getAllNotes();
    }

    public Observable<Boolean> addNote(Note note) {
       return mNotesRepository.addNote(note);
    }

}
