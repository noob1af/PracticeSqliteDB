package com.example.sadikuchan.practicesqlitedb;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);


        ListView listView = (ListView) findViewById(R.id.list_View);

        ArrayList<String> list = new ArrayList<>();
        Cursor data = databaseHelper.getListContents();

        if(data.getCount() == 0){
            Toast.makeText(ListViewActivity.this, "No entry in database!", Toast.LENGTH_LONG).show();
        }
        else{
            while(data.moveToNext()){
                list.add(data.getString(3));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
                listView.setAdapter(listAdapter);
            }
        }
    }
}
