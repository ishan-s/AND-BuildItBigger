package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.Jokr;
import com.example.jokr.JokrActivity;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*        SharedPreferences.OnSharedPreferenceChangeListener sharedPrefListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

                Log.i("$$$DEBUG$$$", "onSharedPreferenceChanged");
                Intent displayJokeIntent = new Intent(getApplicationContext(), JokrActivity.class);
                displayJokeIntent.putExtra("JOKE_IN", sharedPreferences.getString("JOKE_IN", "Error fetching joke!"));
                startActivity(displayJokeIntent);
            }
        };
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        sharedPreferences.registerOnSharedPreferenceChangeListener(sharedPrefListener);
        */
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
        Jokr jokr = new Jokr();

        /*
        Intent jokeDisplayIntent = new Intent(this, JokrActivity.class);
        jokeDisplayIntent.putExtra("JOKE_IN", jokr.getJoke());
        startActivity(jokeDisplayIntent);
        */
        new GetJokeAsyncTask(getApplicationContext()).execute();

        //Toast.makeText(this, jokr.getJoke(), Toast.LENGTH_SHORT).show();
    }


}
