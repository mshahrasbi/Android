package com.shahrasbi.databasedemo3;

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

            SQLiteDatabase sqLiteDatabase = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);
            sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR, year INT(4))");

            //sqLiteDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Nick', 28)");
            //sqLiteDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Nick', 43)");
            //sqLiteDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Dave', 35)");

            sqLiteDatabase.execSQL("DELETE FROM users WHERE name = 'Dave' ");

            //Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM users ", null);
            //Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM users WHERE age > 29", null);
            //Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM users WHERE name = 'Nick' ", null);
            Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM users WHERE name LIKE 'N%' ", null);
            int nameIndex = c.getColumnIndex("name");
            int ageIndex = c.getColumnIndex("age");

            c.moveToFirst();

            while (c.isAfterLast() == false) {
                Log.i("User results - name", c.getString(nameIndex));
                Log.i("User results - age", Integer.toString(c.getInt(ageIndex)));
                c.moveToNext();
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
