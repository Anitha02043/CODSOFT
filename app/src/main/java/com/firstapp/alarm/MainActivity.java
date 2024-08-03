package com.firstapp.alarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private TextView currentTimeTextView;
    private TextView currentDateTextView;
    private Button setAlarmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentTimeTextView = findViewById(R.id.currentTimeTextView);
        currentDateTextView = findViewById(R.id.currentDateTextView);
        setAlarmButton = findViewById(R.id.setAlarmButton);

        updateCurrentTimeAndDate();

        setAlarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SetAlarmActivity.class);
                startActivity(intent);
            }
        });
    }

    private void updateCurrentTimeAndDate() {
        // Update time and date every second
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
                SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, MMM d, yyyy", Locale.getDefault());
                Date currentDate = new Date();

                currentTimeTextView.setText(timeFormat.format(currentDate));
                currentDateTextView.setText(dateFormat.format(currentDate));

                handler.postDelayed(this, 1000);
            }
        });
    }
}