package com.example.parentalcontrol;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.parentalcontrol.models.User;

public class MainActivity extends Activity {

    private User currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);

        // TODO: Get currentUser from Intent
        // Example:
        // currentUser = getIntent().getParcelableExtra("user");

        // Display user info and screen time
        TextView textView = new TextView(this);
        textView.setText("Welcome, " + (currentUser != null ? currentUser.getName() : "User"));
        setContentView(textView);

        // TODO: Display screen time info and parental controls if user.isParent()
    }
}