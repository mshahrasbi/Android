package com.shahrasbi.interactivitydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public void clickMe(View view) {

        EditText nameEditText = (EditText) findViewById(R.id.nameEditText);
        Log.i("Info", "Salam Mohammad, you pressed mw!");
        Log.i("Values", nameEditText.getText().toString());
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
