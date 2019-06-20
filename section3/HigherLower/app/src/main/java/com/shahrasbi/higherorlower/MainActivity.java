package com.shahrasbi.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int randomNumber = 0;
    public void guessButtonClicked(View view) {
        Log.i("Info", "Guess button pressed: randomNumber is: " + randomNumber);

        EditText editText = findViewById(R.id.editText);
        int guessNumber = Integer.parseInt(editText.getText().toString());

        if (guessNumber == randomNumber){
            Toast.makeText(this, "You guessed right " , Toast.LENGTH_LONG).show();

            Random rand = new Random();
            randomNumber = rand.nextInt(50) + 1;
            // editText.setText("");
        }
        else if (guessNumber > randomNumber) {
            Toast.makeText(this, "You guessed higher, guess again ... " , Toast.LENGTH_LONG).show();
        }
        else if (guessNumber < randomNumber) {
            Toast.makeText(this, "You guessed lower, guess again ... " , Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random rand = new Random();
        randomNumber = rand.nextInt(50) + 1;
    }
}
