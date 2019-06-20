package com.shahrasbi.otheranimations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private boolean inversAction = true;

    public void fade(View view){
        Log.i("Info", "ImageView pressed");

        ImageView bartImageView = (ImageView) findViewById(R.id.bartimageView);
        ImageView homerImageView = (ImageView) findViewById(R.id.homerimageView);

        if (inversAction) {
            inversAction = false;
            //bartImageView.animate().translationXBy(1000).setDuration(2000);
            //bartImageView.animate().rotation(180).alpha(0).setDuration(2000);
            bartImageView.animate().scaleX(0.5f).scaleY(0.5f).rotation(180).setDuration(2000);
        } else {
            inversAction = true;
            //bartImageView.animate().translationXBy(-1000).setDuration(2000);
            //bartImageView.animate().rotation(0).alpha(1).setDuration(2000);
            bartImageView.animate().scaleX(1).scaleY(1).rotation(0).setDuration(2000);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView bartImageView = (ImageView) findViewById(R.id.bartimageView);
        bartImageView.setX(-1000);
        bartImageView.animate().translationXBy(1000).rotation(3600).setDuration(2000);
    }
}
