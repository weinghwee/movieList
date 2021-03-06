package com.example.weing.testing;


import android.util.Log;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class Testing extends AppCompatActivity {
     ArrayList<Movie> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        openConnection();
//        list.add(new Movie("Blade Runner","BBBBBBBBBBBBBB",R.drawable.blade_runner));
//        list.add(new Movie("Extinction","EEEEEEEEEEEEE",R.drawable.extinction));
//        list.add(new Movie("Vacation","VVVVVVVVVVV",R.drawable.vacation));
//        list.add(new Movie("Top Gun","TTTTTTTTTTT",R.drawable.top_gun));
//        list.add(new Movie("Hitman,s BodyGuard","HHHHHHHHHHHHHH",R.drawable.hitman));
//        list.add(new Movie("Matrix","MMMMMMMMMMM",R.drawable.matrix));
//        Log.d(tmp,list.size()+"");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing);
        RecyclerView myrv=(RecyclerView)findViewById(R.id.movieList);
        RecyclerViewAdapter myAdapter= new RecyclerViewAdapter(this,list);
        myrv.setLayoutManager(new GridLayoutManager(this, 2));
        myrv.setAdapter(myAdapter);



        }

        public void openConnection(){
            final RequestQueue queue= Volley.newRequestQueue(this);
            String url ="https://api.themoviedb.org/3/movie/popular?api_key=a87b09af86c6db30567f6555a7473901";
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonObject=new JSONObject(response);
                                JSONArray array = jsonObject.getJSONArray("results");
                                for(int i=0;i<array.length();i++){
                                    list.add(new Movie(array.getJSONObject(i).getString("title"),array.getJSONObject(i).getString("overview"),R.drawable.blade_runner));
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            queue.add(stringRequest);
        }


    /** Called when the user taps the Send button */
//    public void createButton(final ArrayList<Movie> list) {
//        parent = (LinearLayout) findViewById(R.id.parentLayout);
//        for (int i = 0; i < list.size(); i++) {
//            String tempMovieTitle=chooseMoviePoster(list.get(i));
//            int id = getResources().getIdentifier(tempMovieTitle, "drawable", getPackageName());
////            tempMovieDetails = list.get(i).toString();
//            newMovieImageButton = new ImageButton(Testing.this);
//            newMovieImageButton.setImageResource(id);
//            newMovieImageButton.setId(i + 1);
//            newMovieImageButton.setTag(list.get(i).title);
//            newMovieImageButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    String a=(String)view.getTag();
//                    tempMovieDetails=chooseDesription(a,list);
//                    Intent intent = new Intent(Testing.this, DisplayDetails.class);
//                    intent.putExtra(detailsOfMovie, tempMovieDetails);
//                    startActivity(intent);
//                }
//            });
//
//            parent.addView(newMovieImageButton);
//
//        }
//    }
//
//    public String chooseMoviePoster(Movie newMovie){
//        if(newMovie.title.equals("Blade Runner"))
//            return "blade_runner";
//        else if(newMovie.title.equals("Matrix"))
//            return "matrix";
//        else if(newMovie.title.equals("Extinction"))
//            return "extinction";
//        else if(newMovie.title.equals("Hitman's BodyGuard"))
//            return "hitman";
//        else if(newMovie.title.equals("Vacation"))
//            return "vacation";
//        else if(newMovie.title.equals("Top Gun"))
//            return "top_gun";
//        else return null;
//    }
//
//    public String chooseDesription(String a, ArrayList<Movie> list){
//        for(int i=0;i<list.size();i++){
//            if(a.equals(list.get(i).title))
//                return list.get(i).toString();
//
//
//        }
//        return null;
//    }


}
