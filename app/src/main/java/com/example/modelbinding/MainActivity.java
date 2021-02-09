package com.example.modelbinding;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.modelbinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);

        // This creates a new User object and passes the User class's constructor some sample
        // data for the name and email values.
        User user = new User("John", "john.doe@outlook.com");

        // This is how the MutableLiveData is bound to the activity's layout.
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setLifecycleOwner(this);
        binding.setUser(user);

        Button btn = findViewById(R.id.next_btn);
        btn.setOnClickListener(v -> {
            startActivity(new Intent(this, FruitActivity.class));
        });
    }
}
