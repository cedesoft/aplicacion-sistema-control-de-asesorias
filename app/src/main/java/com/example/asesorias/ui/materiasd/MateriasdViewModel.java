package com.example.asesorias.ui.materiasd;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MateriasdViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MateriasdViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is materiasd fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}