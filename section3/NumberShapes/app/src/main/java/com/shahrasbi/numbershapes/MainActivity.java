package com.shahrasbi.numbershapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    class Number {

        int number;

        public boolean isSquaredNumber() {
            double squaredNumber = Math.sqrt(number);
            boolean found = false;

            if (squaredNumber == Math.floor(squaredNumber)) {
                found = true;
            }

            return found;
        }

        public boolean isTriangularNumber() {
            int x = 1;
            int trianglarNumber = 1;
            boolean found = false;
            while (trianglarNumber < number){
                trianglarNumber = x*(x+1)/2;
                x+=1;

                if (trianglarNumber == number) found = true;
            }

            return found;
        }
    }



    public void onClick(View view) {
        Log.i("Info", "Button pressed");

        EditText editText = (EditText) findViewById(R.id.editText2);

        String message = "";

        if (editText.getText().toString().isEmpty()) {
            message = "Please enter a number";
        } else {
            Number num = new Number();
            num.number = Integer.parseInt(editText.getText().toString());

            if (num.isSquaredNumber() && num.isTriangularNumber()) {
                message = editText.getText().toString() + " is square and triangular!";
            } else if (num.isTriangularNumber()) {
                message = editText.getText().toString() + " is triangular!";
            } else if (num.isSquaredNumber()) {
                message = editText.getText().toString() + " is square!";
            } else {
                message = editText.getText().toString() + " is neither square nor triangular!";
            }
        }

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
