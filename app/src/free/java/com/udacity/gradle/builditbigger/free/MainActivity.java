package com.udacity.gradle.builditbigger.free;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.example.Jokr;
import com.example.jokr.JokrActivity;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.udacity.gradle.builditbigger.GetJokeAsyncTask;
import com.udacity.gradle.builditbigger.R;

import java.util.concurrent.ExecutionException;


public class MainActivity extends ActionBarActivity {

    InterstitialAd mInterstitialAd;
    String fetchedJoke = null;
    GetJokeAsyncTask getJokesTask = null;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressBarJoke);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712"); //test ad unit id

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
                displayJokeActivity();
            }
        });
        requestNewInterstitial();
    }

    private void displayJokeActivity() {
        try {

            //Test if ad was closed before the joke got loaded..
            while ((fetchedJoke=getJokesTask.get()) == null) {
                //Joke not fetched yet, can't do anything other than just show the spinner and wait..
                if(progressBar.getVisibility()==View.GONE)
                    progressBar.setVisibility(View.VISIBLE);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //Joke fetched now.. proceed with hiding the spinner & launching the activity
        progressBar.setVisibility(View.GONE);

        Intent displayJokeActivityIntent = new Intent(this, JokrActivity.class);
        displayJokeActivityIntent.putExtra("JOKE_IN", fetchedJoke);
        startActivity(displayJokeActivityIntent);
    }

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();

        mInterstitialAd.loadAd(adRequest);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        if(mInterstitialAd.isLoaded())
            mInterstitialAd.show();

        // For Free version with Interstital ads, joke activity should not be launched by the AsyncTask itself but on closing of the ad
        getJokesTask = new GetJokeAsyncTask(getApplicationContext(), null, false);
        getJokesTask.execute();

    }


}
