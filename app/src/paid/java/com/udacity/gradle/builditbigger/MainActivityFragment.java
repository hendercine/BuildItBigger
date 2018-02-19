package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.hendercine.javajoker.JokeSource;
import com.hendercine.jokerdroid.JokeActivity;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

//    Button mTellJokeBtn;
//    private ProgressBar mSpinner;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

//        mTellJokeBtn = root.findViewById(R.id.tell_joke_btn);
//        mSpinner = root.findViewById(R.id.progress_bar);
//        mSpinner.setVisibility(View.GONE);
//        mTellJokeBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                tellJoke();
//            }
//        });

        return root;
    }

//    @Override
//    public void onStop() {
//        super.onStop();
//        mSpinner.setVisibility(View.GONE);
//    }
//
//    public void tellJoke() {
//        mSpinner.setVisibility(View.VISIBLE);
//        MyBean myBean = new MyBean();
//        myBean.setData(MyEndpoint.sayHi().toString());
//        String theJoke = myBean.getData();
//        MainActivity mainActivity = new MainActivity();
//        MainActivity.EndpointsAsyncTask asyncTask = mainActivity.new EndpointsAsyncTask();
//        asyncTask.execute(new Pair<Context, String>(getActivity(), theJoke));
//    }
}
