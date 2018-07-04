package com.example.weing.testing;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.List;

/**
 * Created by weing on 30/6/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{
    private Context myContext;
    private List<Movie> myMovieList;

    public RecyclerViewAdapter(Context mContext, List<Movie> myMovieList){
        this.myContext=mContext;
        this.myMovieList=myMovieList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater myInflater= LayoutInflater.from(myContext);
        view=myInflater.inflate(R.layout.cardview_movie,parent,false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int i) {
        holder.movieTitle.setText(myMovieList.get(i).title);
        holder.movieThumbnail.setImageResource(myMovieList.get(i).thumbnail);
        holder.moviePoster.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                                Intent intent = new Intent(myContext, DisplayDetails.class);
                                intent.putExtra("Movie Title", myMovieList.get(i).title);
                                intent.putExtra("Description", myMovieList.get(i).description);
                                intent.putExtra("moviethumbnail", myMovieList.get(i).thumbnail);
                                myContext.startActivity(intent);


                    }
                });


            }



    @Override
    public int getItemCount() {
        return myMovieList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView movieTitle;
        CardView moviePoster;
        ImageView movieThumbnail;

        public MyViewHolder(View myMovie){
            super(myMovie);
            movieTitle=(TextView)myMovie.findViewById(R.id.movie_title);
            moviePoster=(CardView)myMovie.findViewById(R.id.cardView);
            movieThumbnail=(ImageView)myMovie.findViewById(R.id.movie_image);
        }
    }

}
