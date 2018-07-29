package com.example.damian.myapplication.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.sql.Timestamp;

@Entity (tableName = "word_table")
public class Word {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    public String mWord;

    @NonNull
    @ColumnInfo(name = "creation_date")
    public Timestamp date;

    public Word(@NonNull String mWord) {
        this.mWord = mWord;
    }

    public String getmWord() {
        return mWord;
    }

    public void setmWord(String mWord) {
        this.mWord = mWord;
    }

    @NonNull
    public Timestamp getDate() {
        return date;
    }

    public void setDate(@NonNull Timestamp date) {
        this.date = date;
    }
}
