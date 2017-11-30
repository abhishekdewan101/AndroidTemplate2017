package com.abhishek.androidtemplate.data.local;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.abhishek.androidtemplate.data.model.Note;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;


/**
 * Created by abhishekdewan on 11/26/17.
 */

@Dao
public interface NoteDao {

    @Query("SELECT * from notes")
    Flowable<List<Note>> getAllNotes();

    @Insert
    void insertNote(Note note);
}
