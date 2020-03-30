package com.example.parseproject;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Score");

        query.whereEqualTo("username", "nick");
        query.setLimit(1);

        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {
                    if (objects != null && objects.size() > 0) {
                        for (ParseObject object : objects) {
                            Log.i("username", object.getString("username"));
                            Log.i("score", Integer.toString(object.getInt("score")));
                            Log.i("=======", "=====================================");
                        }
                    }

                } else {
                    e.printStackTrace();
                }
            }
        });
*/
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Score");

        query.whereGreaterThan("score", 50);

        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {
                    if (objects != null && objects.size() > 0) {
                        for (ParseObject object : objects) {

                            object.put("score", object.getInt("score") + 20);
                            object.saveInBackground();

                            Log.i("username", object.getString("username"));
                            Log.i("score", Integer.toString(object.getInt("score")));
                            Log.i("=======", "=====================================");
                        }
                    }

                } else {
                    e.printStackTrace();
                }
            }
        });


        ParseAnalytics.trackAppOpenedInBackground(getIntent());
    }



}
