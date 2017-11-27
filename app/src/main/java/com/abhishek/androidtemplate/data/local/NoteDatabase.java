package com.abhishek.androidtemplate.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.abhishek.androidtemplate.data.model.Note;


/**
 * Created by abhishekdewan on 11/26/17.
 */

@Database(entities = Note.class,version = 1,exportSchema = false)
public abstract class NoteDatabase extends RoomDatabase{

    public abstract NoteDao noteDao();
}
