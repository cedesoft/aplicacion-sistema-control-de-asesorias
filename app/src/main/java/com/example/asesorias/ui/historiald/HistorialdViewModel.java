package com.example.asesorias.ui.historiald;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HistorialdViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HistorialdViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is historiald fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }


}