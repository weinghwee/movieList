package com.example.weing.testing;

/**
 * Created by weing on 28/6/2018.
 */

public class Movie {
    String title;
    String description;
    int thumbnail;

    Movie() {
        title = description = null;
    }

    Movie(String title,String description, int thumbnail) {
        this.title = title;
        this.description = description;
        this.thumbnail = thumbnail;
    }
}

