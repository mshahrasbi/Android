package com.shahrasbi.databasedemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            SQLiteDatabase sqLiteDatabase = this.openOrCreateDatabase("Events", MODE_PRIVATE, null);
            sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS events (name VARCHAR, year INT(4))");

            //sqLiteDatabase.execSQL("INSERT INTO events (name, year) VALUES ('Milenieum', 2000)");
            //sqLiteDatabase.execSQL("INSERT INTO events (name, year) VALUES ('Started learning this course', 2017)");

            Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM events", null);
            int nameIndex = c.getColumnIndex("name");
            int yearIndex = c.getColumnIndex("year");

            c.moveToFirst();

            while (c.isAfterLast() == false) {
                Log.i("Results - name", c.getString(nameIndex));
                Log.i("Results - year", Integer.toString(c.getInt(yearIndex)));
                c.moveToNext();
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
