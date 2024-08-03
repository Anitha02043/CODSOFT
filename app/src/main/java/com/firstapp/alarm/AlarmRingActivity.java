package com.firstapp.alarm;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AlarmRingActivity extends AppCompatActivity {
    private Button snoozeButton;
    private Button dismissButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_ring);

        snoozeButton = findViewById(R.id.snoozeButton);
        dismissButton = findViewById(R.id.dismissButton);

        // Start playing alarm sound here

        snoozeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement snooze logic
                finish();
            }
        });

        dismissButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Stop alarm sound
                finish();
            }
        });
    }
}
