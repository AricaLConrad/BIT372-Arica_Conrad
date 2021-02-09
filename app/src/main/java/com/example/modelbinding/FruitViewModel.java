package com.example.modelbinding;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

@RequiresApi(api = Build.VERSION_CODES.R)
public class FruitViewModel extends ViewModel {
    private FakeRepository repo = new FakeRepository();

    public MutableLiveData<String> editTextContent = new MutableLiveData<>();

    private MutableLiveData<String> displayedEditTextContent = new MutableLiveData<>();

    public LiveData<String> getCurrentRandomFruitName() {
        return repo.getCurrentRandomFruitName();
    }

    public void onChangeRandomFruitClick() {
        repo.changeCurrentRandomFruitName();
    }

    public LiveData<String> getDisplayedEditTextContent() {
        return this.displayedEditTextContent;
    }

    public void onDisplayEditTextContentClick() {
        this.displayedEditTextContent.setValue(editTextContent.getValue());
    }

    public void onSelectRandomEditTextFruit() {
        editTextContent.setValue(repo.getRandomFruitName());
    }
}
