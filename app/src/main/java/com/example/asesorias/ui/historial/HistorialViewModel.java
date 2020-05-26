package com.example.asesorias.ui.historial;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HistorialViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HistorialViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is historial fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }


}