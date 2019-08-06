package com.shahrasbi.guessthecelebrity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button button0;
    private Button button1;
    private Button button2;
    private Button button3;


    private ArrayList<String> celebURLs = new ArrayList<String>();
    private ArrayList<String> celebNames = new ArrayList<String>();

    private int chosenCeleb = 0;
    private int locationOfCorrentAnswer = -1;
    private String[] answers = new String[4];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        imageView = findViewById(R.id.imageView);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);


        DownloadTask task = new DownloadTask();
        String result = null;

        try {
            result = task.execute("http://www.posh24.se/kandisar").get();

            String[] splitResult = result.split("<div class=\"ListedArticles\">");

            Pattern p = Pattern.compile("img src=\"(.*?)\"");
            Matcher m = p.matcher(splitResult[0]);

            while(m.find()) {
                celebURLs.add(m.group(1));
            }

            p = Pattern.compile("alt=\"(.*?)\"");
            m = p.matcher(splitResult[0]);

            while(m.find()) {
                celebNames.add(m.group(1));
            }

            newQuestion();

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    private void newQuestion(){

        try {
            Random rand = new Random();
            chosenCeleb = rand.nextInt(celebURLs.size());

            ImageDownloader imageTask = new ImageDownloader();
            Bitmap imageCeleb = imageTask.execute(celebURLs.get(chosenCeleb)).get();

            imageView.setImageBitmap(imageCeleb);

            locationOfCorrentAnswer = rand.nextInt(4);
            int incorrentAnswerLocation;

            for (int i = 0; i < 4; i++) {
                if (i == locationOfCorrentAnswer) {
                    answers[i] = celebNames.get(chosenCeleb);
                } else {
                    incorrentAnswerLocation = rand.nextInt(celebNames.size());

                    while(incorrentAnswerLocation == chosenCeleb) {
                        incorrentAnswerLocation = rand.nextInt(celebNames.size());
                    }

                    answers[i] = celebNames.get(incorrentAnswerLocation);
                }

                Log.i("Celeb Name: ", answers[i]);
            }

            button0.setText(answers[0]);
            button1.setText(answers[1]);
            button2.setText(answers[2]);
            button3.setText(answers[3]);

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public void celebChosen(View view) {
        if (view.getTag().toString().equals(Integer.toString(locationOfCorrentAnswer))){
            Toast.makeText(getApplicationContext(), "Correct!!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Wrong!! It was " + celebNames.get(chosenCeleb), Toast.LENGTH_SHORT).show();
        }

        newQuestion();
    }

    public class DownloadTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {

            String result = "";
            URL url;
            HttpURLConnection urlConnection = null;

            try
            {
                url = new URL(urls[0]);
                urlConnection = (HttpURLConnection) url.openConnection();

                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();

                while( data != -1 ){
                    char current = (char) data;
                    result += current;
                    data = reader.read();
                }

                Log.i("Contents of URL", result);
                return result;

            } catch(Exception ex) {

                ex.printStackTrace();
                return null;
            }
        }
    }

    public class ImageDownloader extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... urls) {

            try{
                URL url = new URL(urls[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream inputStream = connection.getInputStream();
                Bitmap myBitmap = BitmapFactory.decodeStream(inputStream);

                return myBitmap;
            } catch(Exception ex) {

                ex.printStackTrace();
                return null;
            }
        }
    }
}
