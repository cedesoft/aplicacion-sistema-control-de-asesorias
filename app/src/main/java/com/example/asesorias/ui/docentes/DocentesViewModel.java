package com.example.asesorias.ui.docentes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DocentesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DocentesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is docentes fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}