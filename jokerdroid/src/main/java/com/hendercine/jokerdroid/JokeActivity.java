package com.hendercine.jokerdroid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * BuildItBigger created by hendercine on 11/14/17.
 */

public class JokeActivity extends AppCompatActivity {

    public static final String JOKE_KEY = "Joke key";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
    }
}
