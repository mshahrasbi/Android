package com.shahrasbi.imagedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void NextImage(View view) {

        ImageView image = (ImageView) findViewById(R.id.imageView);
        String imageTag = (String) image.getTag();

        if (imageTag == null) {
            image.setImageResource(R.drawable.tige2);
            image.setTag("tige2");
        } else if (imageTag == "tige2") {
            image.setImageResource(R.drawable.tige3);
            image.setTag("tige3");
        } else if (imageTag == "tige3") {
            image.setImageResource(R.drawable.tige1);
            image.setTag("tige1");
        } else if (imageTag == "tige1") {
            image.setImageResource(R.drawable.tige2);
            image.setTag("tige2");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
