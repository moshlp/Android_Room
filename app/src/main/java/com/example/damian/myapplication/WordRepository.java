package com.example.damian.myapplication;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.damian.myapplication.dao.WordDao;
import com.example.damian.myapplication.db.WordRoomDatabase;
import com.example.damian.myapplication.entities.Word;

import java.util.List;

public class WordRepository {

    public WordDao wordDao;
    public LiveData<List<Word>> words;

    WordRepository (Application application){
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application.getApplicationContext());
        wordDao = db.wordDao();
        words = wordDao.getAll();
    }

    LiveData<List<Word>> getAll(){
        return words;
    }

    public void insert(Word word){
        new InsertAsyncTask(wordDao).execute(word);
    }

    private static class InsertAsyncTask extends AsyncTask<Word,Void,Void>{

        private WordDao dao;

        InsertAsyncTask (WordDao dao){
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(final Word... params) {
            dao.insert(params[0]);
            return null;
        }
    }

}
