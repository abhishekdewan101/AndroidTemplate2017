package com.abhishek.androidtemplate.data.remote;

import android.os.Handler;

import com.abhishek.androidtemplate.data.model.Note;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by abhishekdewan on 11/29/17.
 */

public class NoteRemoteDatabase {

    static List<Note> mRemoteDatabase = new ArrayList<Note>();
    long RESPONSE_DELAY_PARAMETER = 4;
    PublishSubject<Note> mNotePublishSubject;

    static {
        addTempNote(new Note("Remote Note 1","Something Something","10-11-1990",1));
        addTempNote(new Note("Remote Note 2","Something Something","10-11-1991",2));
        addTempNote(new Note("Remote Note 3","Something Something","10-11-1992",3));
    }

    private static void addTempNote(Note note) {
        mRemoteDatabase.add(note);
    }

    public PublishSubject<Note> getAllNotes() {
        mNotePublishSubject = PublishSubject.create();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                for (Note note : mRemoteDatabase) {
                    mNotePublishSubject.onNext(note);
                }
            }
        },3000);

        return mNotePublishSubject;
    }

    public Observable<Boolean> addNote(Note note) {
        return Observable.defer(() -> Observable.create((ObservableOnSubscribe<Boolean>) e -> {
            mRemoteDatabase.add(note);
            mNotePublishSubject.onNext(note);
            e.onNext(true);
            e.onComplete();
        }));

    }

}
