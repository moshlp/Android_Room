package com.example.damian.myapplication;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.damian.myapplication.entities.Word;

import java.util.List;

public class WordViewModel extends AndroidViewModel {

    private WordRepository repository;
    private LiveData<List<Word>> words;

    public WordViewModel(Application application) {
        super(application);
        this.repository = new WordRepository(application);
        this.words = repository.getAll();
    }

    LiveData<List<Word>> getAll(){
        return words;
    }

    void insert(Word word){
        repository.insert(word);
    }
}
