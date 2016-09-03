package com.example.jokr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokrActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokr);

        Intent intent = getIntent();
        TextView jokeTV = (TextView) findViewById(R.id.tv_joke);
        jokeTV.setText(intent.getStringExtra("JOKE_IN"));
    }
}
