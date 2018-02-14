package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.hendercine.javajoker.JokeSource;
import com.hendercine.jokerdroid.JokeActivity;

import timber.log.Timber;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    Button mTellJokeBtn;
    private ProgressBar mSpinner;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_main, container, false);

        AdView mAdView = root.findViewById(R.id.adView);
        final InterstitialAd mInterstitialAd = new InterstitialAd(getContext());
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");

        mTellJokeBtn = root.findViewById(R.id.tell_joke_btn);
        mSpinner = root.findViewById(R.id.progress_bar);
        mSpinner.setVisibility(View.GONE);

        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
        mInterstitialAd.loadAd(adRequest);

        mInterstitialAd.setAdListener(new AdListener() {
                                          @Override
                                          public void onAdClosed() {
                                              tellJoke();
                                          }
                                      }
        );

        mTellJokeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSpinner.setVisibility(View.VISIBLE);
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                    mSpinner.setVisibility(View.GONE);
                } else {
                    Timber.d("The interstitial wasn't loaded yet.");
                    tellJoke();
                }
            }
        });

        return root;
    }

    @Override
    public void onStop() {
        super.onStop();
        mSpinner.setVisibility(View.GONE);
    }

    public void tellJoke() {
        Intent intent = new Intent(getContext(), JokeActivity.class);
        String joke = JokeSource.getJoke();
        intent.putExtra(JokeActivity.JOKE_KEY, joke);
        mSpinner.setVisibility(View.VISIBLE);
        startActivity(intent);
    }
}
