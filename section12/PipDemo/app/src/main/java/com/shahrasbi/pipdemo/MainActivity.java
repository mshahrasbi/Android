package com.shahrasbi.pipdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    public void goPip(View view) {
        enterPictureInPictureMode();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode, Configuration newConfig) {
        super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig);

        TextView textView = findViewById(R.id.textView);
        Button GOpipButton = findViewById(R.id.GOpipButton);

        if (isInPictureInPictureMode) {
            // going into picture in picture
            GOpipButton.setVisibility(View.INVISIBLE);
            getSupportActionBar().hide();
            textView.setText("Welcome to Pip mode");
        } else {
            // going out of picture in picture
            GOpipButton.setVisibility(View.VISIBLE);
            getSupportActionBar().show();
            textView.setText("Hello World!");
        }
    }
}
