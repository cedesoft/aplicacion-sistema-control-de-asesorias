package com.example.asesorias.ui.materias;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MateriasViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MateriasViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is materias fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}