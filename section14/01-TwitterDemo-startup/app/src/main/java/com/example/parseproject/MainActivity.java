package com.example.parseproject;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.LogInCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditTest;
    private EditText passwordEditTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Twitter: Login");

        usernameEditTest = findViewById(R.id.userNameEditText);
        passwordEditTest = findViewById(R.id.passwordEditText);

        ParseAnalytics.trackAppOpenedInBackground(getIntent());
    }


    public void signupLogin(View view) {
        ParseUser.logInInBackground(usernameEditTest.getText().toString(), passwordEditTest.getText().toString(), new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e == null) {
                    Log.i("Login", "Success!");
                } else {
                    ParseUser newUser = new ParseUser();
                    newUser.setUsername(usernameEditTest.getText().toString());
                    newUser.setPassword(passwordEditTest.getText().toString());

                    newUser.signUpInBackground(new SignUpCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null) {
                                Log.i("Signup", "Success!");
                            } else {
                                String errorMsg = e.getMessage().substring((e.getMessage().indexOf(" ")));
                                Toast.makeText(MainActivity.this, errorMsg, Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }

}
