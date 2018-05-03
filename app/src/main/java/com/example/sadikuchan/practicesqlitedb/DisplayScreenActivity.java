package com.example.sadikuchan.practicesqlitedb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_screen);

        String username = getIntent().getStringExtra("username");

        TextView usernameTextView = (TextView) findViewById(R.id.username_display);
        usernameTextView.setText(username);
    }
}
