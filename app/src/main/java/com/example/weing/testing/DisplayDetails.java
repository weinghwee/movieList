package com.example.weing.testing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_details);
        Intent intent = getIntent();
        String message = intent.getStringExtra(Testing.detailsOfMovie);
        TextView textView = findViewById(R.id.detailsLayout);
        textView.setText(message);
    }
}
