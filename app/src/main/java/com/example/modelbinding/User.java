package com.example.modelbinding;
import androidx.lifecycle.MutableLiveData;

public class User {
    // In the activity_main.xml file, I added this line to the email EditText view:
    // android:text="@={user.email}"
    // This makes the live data two-way, where the text input (EditText) matches with the text
    // output (TextView). This means when the user types something in the text input view (EditText),
    // the output (TextView) above the input will show exactly what the user is typing at the same time.

    // This makes both the name and email strings be live data. Originally, it was only the name.
    public MutableLiveData<String> name;
    public MutableLiveData<String> email;

    // This constructor creates new MutableLiveData objects and then sets the values that are passed
    // to the constructor as the name and email values.
    public User(String name, String email) {
        this.name = new MutableLiveData<>();
        this.name.setValue(name);
        this.email = new MutableLiveData<>();
        this.email.setValue(email);
    }
}
