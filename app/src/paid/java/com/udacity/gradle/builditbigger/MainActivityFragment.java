package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hendercine.javajoker.JokeSource;
import com.hendercine.jokerdroid.JokeActivity;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    Button mTellJokeBtn;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        mTellJokeBtn = root.findViewById(R.id.tell_joke_btn);
        mTellJokeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tellJoke();
            }
        });

        return root;
    }

    public void tellJoke() {
        Intent intent = new Intent(getContext(), JokeActivity.class);
        String joke = JokeSource.getJoke();
        intent.putExtra(JokeActivity.JOKE_KEY, joke);
        startActivity(intent);
    }
}
