package com.example.parseproject;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.GetCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        ParseObject score = new ParseObject("Score");
        score.put("username", "nick");
        score.put("score", 45);
        score.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    // ok
                    Log.i("Success", "We save the score");
                } else {
                    e.printStackTrace();
                }
            }
        });
        */

        /*
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Score");
        query.getInBackground("<objectId>", new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject object, ParseException e) {
                if (e == null) {
                    // ok
                    if(object != null) {
                        object.put("score", 85);
                        object.saveInBackground();

                        Log.i("username", object.getString("username"));
                        Log.i("score", Integer.toString(object.getInt("score")));
                    }
                } else {
                    e.printStackTrace();
                }
            }
        });
         */

        // create a tweet class, username tweet, save it to parse, query it, update the tweet
        ParseObject tweet = new ParseObject("Tweet");
        tweet.put("username", "nick");
        tweet.put("tweet", "I like cars");
        tweet.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    // ok
                    Log.i("Success", "We save the tweet");
                } else {
                    e.printStackTrace();
                }
            }
        });

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Tweet");
        query.getInBackground("<objectId>", new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject object, ParseException e) {
                if (e == null) {
                    // ok
                    if(object != null) {
                        object.put("tweet", "Truck is fine too");
                        object.saveInBackground();

                        Log.i("username", object.getString("username"));
                        Log.i("tweet", object.getString("tweet"));
                    }
                } else {
                    e.printStackTrace();
                }
            }
        });


        ParseAnalytics.trackAppOpenedInBackground(getIntent());
    }



}
