package com.example.asesorias.ui.asesorias;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AsesoriasViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AsesoriasViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is asesorias fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}