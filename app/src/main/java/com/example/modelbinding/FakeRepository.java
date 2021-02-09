package com.example.modelbinding;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;
import java.util.Random;

@RequiresApi(api = Build.VERSION_CODES.R)
public class FakeRepository {
    private List<String> fruitNames = List.of(
            "Apple", "Banana", "Orange", "Kiwi", "Grapes", "Fig",
            "Pear", "Strawberry", "Gooseberry", "Raspberry");

    private MutableLiveData<String> currentRandomFruitName;

    public LiveData<String> getCurrentRandomFruitName() {
        if (currentRandomFruitName == null) {
            currentRandomFruitName = new MutableLiveData<>();
            currentRandomFruitName.setValue(fruitNames.get(0));
        }
        return currentRandomFruitName;
    }

    public String getRandomFruitName() {
        Random rand = new Random();
        return fruitNames.get(rand.nextInt(fruitNames.size()));
    }

    public void changeCurrentRandomFruitName() {
        this.currentRandomFruitName.setValue(getRandomFruitName());
    }
}
