package com.shahrasbi.multipleactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //private Button goToNextButton;

    public void goToNext(View view) {
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);

        intent.putExtra("age", 23);

        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //this.goToNextButton.findViewById(R.id.goToNextButton);
    }
}
