package com.shahrasbi.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*
        final ArrayList<String> myFamily = new ArrayList<String>();
        myFamily.add("Mahroo");
        myFamily.add("Majeed");
        myFamily.add("AliAkbar");
        myFamily.add("Mahri");
        myFamily.add("Farzaneh");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myFamily);


        ListView myListView = findViewById(R.id.myListView);
        myListView.setAdapter(arrayAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Log.i("Person selected: ", myFamily.get(position));
            }
        });
*/

        final ArrayList<String> myFriends = new ArrayList<String>(asList("Sam", "Bruce", "Todd", "James", "Jim"));

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myFriends);

        ListView myListView = findViewById(R.id.myListView);
        myListView.setAdapter(arrayAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText( getApplicationContext(), "Hello " + myFriends.get(position), Toast.LENGTH_LONG).show();
            }
        });


    }
}
