package com.abhishek.androidtemplate.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;


/**
 * Created by abhishekdewan on 11/26/17.
 */


@Entity(tableName = "notes")
public class Note {

    @PrimaryKey(autoGenerate = true)
    private int mId;
    private String mTitle;
    private String mDetails;
    private String mCreatedAt;
    private int mColor;

    public Note(String title, String details, String createdAt, int color) {
        mTitle = title;
        mDetails = details;
        mCreatedAt = createdAt;
        mColor = color;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getDetails() {
        return mDetails;
    }

    public void setDetails(String details) {
        mDetails = details;
    }

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        mCreatedAt = createdAt;
    }

    public int getColor() {
        return mColor;
    }

    public void setColor(int color) {
        mColor = color;
    }

    enum NOTE_COLORS{
        RED,GREEN,BLUE,PURPLE,ORANGE,YELLOW
    }
}
