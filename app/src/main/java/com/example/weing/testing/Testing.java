package com.example.weing.testing;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.io.File;
import java.util.ArrayList;

public class Testing extends AppCompatActivity {
    LinearLayout parent;
    ImageButton newMovieImageButton;
    static String detailsOfMovie;
    static String tempMovieDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ArrayList<Movie> list=new ArrayList<>();
        list.add(new Movie("Top Gun","sajdhksjahdkjashdjkahs"));
        list.add(new Movie("Extinction","asdkjasgdkjashd"));
        list.add(new Movie("Vacation","asdkjasgdkjashd"));
        list.add(new Movie("Hitman's BodyGuard","asdkjasgdkjashd"));
        list.add(new Movie("Matrix","asdkjasgdkjashd"));
        list.add(new Movie("Blade Runner","asdkjasdfsdsgdkjashd"));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing);
        createButton(list);
        }

    /** Called when the user taps the Send button */
    public void createButton(final ArrayList<Movie> list) {
        parent = (LinearLayout) findViewById(R.id.parentLayout);
        for (int i = 0; i < list.size(); i++) {
            String tempMovieTitle=chooseMoviePoster(list.get(i));
            int id = getResources().getIdentifier(tempMovieTitle, "drawable", getPackageName());
//            tempMovieDetails = list.get(i).toString();
            newMovieImageButton = new ImageButton(Testing.this);
            newMovieImageButton.setImageResource(id);
            newMovieImageButton.setId(i + 1);
            newMovieImageButton.setTag(list.get(i).title);
            newMovieImageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String a=(String)view.getTag();
                    tempMovieDetails=chooseDesription(a,list);
                    Intent intent = new Intent(Testing.this, DisplayDetails.class);
                    intent.putExtra(detailsOfMovie, tempMovieDetails);
                    startActivity(intent);
                }
            });

            parent.addView(newMovieImageButton);

        }
    }

    public String chooseMoviePoster(Movie newMovie){
        if(newMovie.title.equals("Blade Runner"))
            return "blade_runner";
        else if(newMovie.title.equals("Matrix"))
            return "matrix";
        else if(newMovie.title.equals("Extinction"))
            return "extinction";
        else if(newMovie.title.equals("Hitman's BodyGuard"))
            return "hitman";
        else if(newMovie.title.equals("Vacation"))
            return "vacation";
        else if(newMovie.title.equals("Top Gun"))
            return "top_gun";
        else return null;
    }

    public String chooseDesription(String a, ArrayList<Movie> list){
        for(int i=0;i<list.size();i++){
            if(a.equals(list.get(i).title))
                return list.get(i).toString();


        }
        return null;
    }


}
