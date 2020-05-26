package com.example.asesorias.ui.perfild;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PerfildViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PerfildViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is perfild fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}