package com.shahrasbi.timerdemo;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private void timerMethod1(){
        // this timer runs through future, you need to have some
        // condition to stop it.
        final Handler handler = new Handler();
        Runnable run = new Runnable() {
            @Override
            public void run() {
                Log.i("Hay it's us", "A second passed by");

                handler.postDelayed(this, 1000);
            }
        };

        handler.post(run);
    }


    private void timerMethod2(){
        // this method is more controllable and counting down to some number.
        new CountDownTimer(10000, 1000){

            public void onTick(long millisecondUntilDone) {
                Log.i("Second Left1", String.valueOf(millisecondUntilDone / 1000));
            }

            public void onFinish() {
                Log.i("We are done!", "No more Countdown");
            }
        }.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // timerMethod1();
        timerMethod2();
    }
}
