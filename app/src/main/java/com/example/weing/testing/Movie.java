package com.example.weing.testing;

/**
 * Created by weing on 28/6/2018.
 */

public class Movie {
    String title;
    String description;

    Movie(){
        title=description=null;
    }
    Movie(String title,String description ){
        this.title=title;
        this.description=description;
    }
    public String toString(){
        String details="Title: "+title+"\n\nSummary: "+description+"\n";
        return details ;
    }
}
