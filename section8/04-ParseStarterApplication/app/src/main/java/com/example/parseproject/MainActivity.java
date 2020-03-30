package com.example.parseproject;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        ParseUser user = new ParseUser();
        user.setUsername("nick");
        user.setPassword("password");

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    // ok
                    Log.i("Sign Up Ok!", "we are logged in!");
                } else {
                    e.printStackTrace();
                }
            }
        });
         */
        /*
        ParseUser.logInInBackground("nick", "password", new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e == null) {
                    if (user != null) {
                        Log.i("Success", "We logged in!");
                    } else {
                        e.printStackTrace();
                    }
                } else {
                    e.printStackTrace();
                }
            }
        });

         */

        if (ParseUser.getCurrentUser() != null) {
            Log.i("Signed In", ParseUser.getCurrentUser().getUsername());
        } else {
            Log.i("Not luck", "Not signed in");
        }

        ParseUser.logOut();

        ParseAnalytics.trackAppOpenedInBackground(getIntent());
    }



}
