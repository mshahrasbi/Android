package com.shahrasbi.logindemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void login(View view) {

        EditText usernameEditText = findViewById(R.id.usernameeditText);
        EditText passwordEditText = findViewById(R.id.passwordeditText);

        
        Log.i("Info", "Login Button Pressed");
        Log.i("Info", usernameEditText.getText().toString());
        Log.i("Info", passwordEditText.getText().toString());

        Toast.makeText(this, "Hi there!", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
