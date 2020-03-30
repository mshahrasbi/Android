package com.shahrasbi.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.security.spec.ECField;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TestSharedPreference();
        // ReTestSharedPreference();

        TestSharedPreferenceArrays();
    }

    private void TestSharedPreference() {
        // get to the shared preferences
        SharedPreferences  sharedPreferences = this.getSharedPreferences("com.shahrasbi.sharedpreferences", Context.MODE_PRIVATE);

        sharedPreferences.edit().putString("username", "John").apply();

        String username = sharedPreferences.getString("username", "");
        Log.i("This is the username", username);

        //Toast.makeText(this, "This is the username " + username, Toast.LENGTH_SHORT).show();
    }

    private void ReTestSharedPreference() {
        // get to the shared preferences
        SharedPreferences  sharedPreferences = this.getSharedPreferences("com.shahrasbi.sharedpreferences", Context.MODE_PRIVATE);

        String username = sharedPreferences.getString("username", "");
        Log.i("This is the username", username);

        //Toast.makeText(this, "This is the username " + username, Toast.LENGTH_SHORT).show();
    }

    private void TestSharedPreferenceArrays() {
        // get to the shared preferences
        SharedPreferences  sharedPreferences = this.getSharedPreferences("com.shahrasbi.sharedpreferences", Context.MODE_PRIVATE);

        ArrayList<String> friends = new ArrayList<>();
        friends.add("Fido");
        friends.add("Sarah");
        friends.add("Mahroo");
        friends.add("Mo");
        friends.add("Maj");

        try {
            sharedPreferences.edit().putString("friends", ObjectSerializer.serialize(friends)).apply();

            Log.i("friends", ObjectSerializer.serialize(friends));
        } catch(Exception e) {
            e.printStackTrace();
        }

        try {
            ArrayList<String> newFriends = new ArrayList<>();
            newFriends = (ArrayList<String>) ObjectSerializer.deserialize(sharedPreferences.getString("friends", ObjectSerializer.serialize(new ArrayList<String>())));

            Log.i("New Friends", newFriends.toString());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
