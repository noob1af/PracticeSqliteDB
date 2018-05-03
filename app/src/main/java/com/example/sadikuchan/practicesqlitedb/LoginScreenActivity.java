package com.example.sadikuchan.practicesqlitedb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
    }

    public void gotoDisplayScreen(View view) {

        EditText usernameEditText = (EditText) findViewById(R.id.username);

        String usernameStr = usernameEditText.getText().toString();
        Intent loginIntent = new Intent(this, DisplayScreenActivity.class);

        loginIntent.putExtra("username",usernameStr);
        startActivity(loginIntent);
    }
}
