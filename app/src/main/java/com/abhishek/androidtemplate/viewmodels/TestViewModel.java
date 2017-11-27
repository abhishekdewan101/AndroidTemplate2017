package com.abhishek.androidtemplate.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.abhishek.androidtemplate.data.NotesRepository;
import com.abhishek.androidtemplate.data.model.Note;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

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

    public LiveData<List<Note>> loadAllNotes() {
        return mNotesRepository.getAllNotes();
    }

}
