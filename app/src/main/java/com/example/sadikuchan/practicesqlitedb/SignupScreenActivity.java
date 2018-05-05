package com.example.sadikuchan.practicesqlitedb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class SignupScreenActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_screen);
    }


    public void popUpMessage(View view) {
        EditText nameEditText = (EditText) findViewById(R.id.name_signup);
        EditText emailEditText = (EditText) findViewById(R.id.email_signup);
        EditText passEditText = (EditText) findViewById(R.id.password_signup);
        EditText confirmPassEditText = (EditText) findViewById(R.id.confirm_password_signup);

        String nameStr = nameEditText.getText().toString();
        String emailStr = emailEditText.getText().toString();
        String passStr = passEditText.getText().toString();
        String confPassStr = confirmPassEditText.getText().toString();

        if(!passStr.equals(confPassStr)){
            Toast mToast = Toast.makeText(SignupScreenActivity.this, "Password Incorrect!", Toast.LENGTH_SHORT);
            mToast.show();
        }
        else {
            Contact contact = new Contact();
            contact.setName(nameStr);
            contact.setEmail(emailStr);
            contact.setPass(passStr);

            databaseHelper.insertContact(contact);
        }

    }

    public void gotoListViewScreen(View view) {
        Intent listIntent = new Intent(this, ListViewActivity.class);
        startActivity(listIntent);
    }
}
