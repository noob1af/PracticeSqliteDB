package com.example.sadikuchan.practicesqlitedb;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginScreenActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
    }

    public void gotoDisplayScreen(View view) {

        EditText nameEditText = (EditText) findViewById(R.id.username);
        String nameStr = nameEditText.getText().toString();

        EditText passEditText = (EditText) findViewById(R.id.password);
        String passStr = passEditText.getText().toString();

        String password = databaseHelper.searchPass(nameStr);

        if(passStr.equals(password)){
            Intent loginIntent = new Intent(this, DisplayScreenActivity.class);
            loginIntent.putExtra("name", nameStr);
            startActivity(loginIntent);
        }
        else{
            Toast mToast = Toast.makeText(LoginScreenActivity.this, "Password Incorrect!", Toast.LENGTH_SHORT);
            mToast.show();
        }

    }

    public void gotoSignupScreen(View view) {
        Intent signupScreenIntent = new Intent(this, SignupScreenActivity.class);
        startActivity(signupScreenIntent);
    }
}
