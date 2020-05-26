package com.example.asesorias.ui.asesoriasd;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AsesoriasdViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AsesoriasdViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is asesoriasd fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}