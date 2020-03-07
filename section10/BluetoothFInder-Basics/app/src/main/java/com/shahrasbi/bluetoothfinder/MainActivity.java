package com.shahrasbi.bluetoothfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView statusTextView;
    private ListView listView;
    private Button searchButton;

    private BluetoothAdapter bluetoothAdapter;

    public void searchClicked(View view) {

        statusTextView.setText("Searching ...");
        searchButton.setEnabled(false);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        statusTextView = findViewById(R.id.statusTextView);
        listView = findViewById(R.id.listView);
        searchButton = findViewById(R.id.searchButton);
    }
}
