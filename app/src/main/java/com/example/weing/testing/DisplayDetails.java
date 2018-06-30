package com.example.weing.testing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayDetails extends AppCompatActivity {
    private TextView movietitle, moviedescription;
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_details);
        movietitle=(TextView)findViewById(R.id.movietitle);
        moviedescription=(TextView)findViewById(R.id.description);
        img=(ImageView)findViewById(R.id.moviethumbnail);
        Intent intent= getIntent();
        String title=intent.getExtras().getString("Movie Title");
        String Description=intent.getExtras().getString("Description");
        int image=intent.getExtras().getInt("moviethumbnail");
        movietitle.setText(title);
        moviedescription.setText(Description);
        img.setImageResource(image);
    }
}
