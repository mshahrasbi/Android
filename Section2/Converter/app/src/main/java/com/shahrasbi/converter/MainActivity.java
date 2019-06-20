package com.shahrasbi.converter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void onClick(View view) {

        Log.i("Info", "Button Pressed!");

        EditText editText = (EditText) findViewById(R.id.editText2);

        String amountInPonds = editText.getText().toString();
        double amountInPondsInDouble = Double.parseDouble(amountInPonds);
        double amountInDollarsDouble = amountInPondsInDouble * 1.3;
        String amountInDollarsString = String.format("%.2f", amountInDollarsDouble);
        Log.i("Info", "Amount is " + amountInDollarsString);

        Toast.makeText(this, "Pound " + amountInPonds + " is $" + amountInDollarsString, Toast.LENGTH_LONG).show();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
