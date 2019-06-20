package com.shahrasbi.animations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private boolean replaceImage = false;

    public void fade(View view) {
        Log.i("Info", "ImageView tapped");

        ImageView bartimageView = (ImageView) findViewById(R.id.bartimageView);
        ImageView homerimageView = (ImageView) findViewById(R.id.homerimageView);

        if(replaceImage){
            replaceImage = false;
            bartimageView.animate().alpha(1).setDuration(2000);
            homerimageView.animate().alpha(0).setDuration(2000);
        } else {
            replaceImage = true;
            bartimageView.animate().alpha(0).setDuration(2000);
            homerimageView.animate().alpha(1).setDuration(2000);
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
