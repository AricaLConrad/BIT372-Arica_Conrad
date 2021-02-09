package com.example.modelbinding;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.modelbinding.databinding.ActivityFruitBinding;

@RequiresApi(api = Build.VERSION_CODES.R)
public class FruitActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);

        FruitViewModel vm = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(FruitViewModel.class);
        vm.getCurrentRandomFruitName().observe(this, fruit -> {
            Log.i("INFO", fruit);
        });
        vm.editTextContent.observe(this, f -> {
            Log.i("INFO", f);
        });
        vm.getDisplayedEditTextContent().observe(this, f -> {
            Log.i("INFO", f);
        });

        ActivityFruitBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_fruit);
        binding.setLifecycleOwner(this);
        binding.setViewmodel(vm);
    }
}