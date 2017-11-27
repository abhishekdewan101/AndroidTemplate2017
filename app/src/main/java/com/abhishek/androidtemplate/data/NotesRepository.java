package com.abhishek.androidtemplate.data;

import android.arch.lifecycle.LiveData;

import com.abhishek.androidtemplate.data.local.NoteDao;
import com.abhishek.androidtemplate.data.model.Note;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by abhishekdewan on 11/26/17.
 */

public class NotesRepository {

    public NoteDao mNoteDao;

    public NotesRepository(NoteDao noteDao){
        mNoteDao = noteDao;
    }

    public LiveData<List<Note>> getAllNotes() {
        return mNoteDao.getAllNotes();
    }

    public void addNote(Note note) {
        Observable.just(note)
                .subscribeOn(Schedulers.io())
                .subscribe(note1 -> {mNoteDao.insertNote(note);},
                        throwable -> {throwable.printStackTrace();});
    }

}
