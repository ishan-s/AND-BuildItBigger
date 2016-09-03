package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;


import com.example.ishan.jokr.backend.jokr.Jokr;
import com.example.jokr.JokrActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by Ishan on 03-09-2016.
 */
public class GetJokeAsyncTask extends AsyncTask<Void, Void, String>{
    private static Jokr jokrService = null;
    private Context context;

    public GetJokeAsyncTask(Context context){
        this.context = context;
    }

    @Override
    protected String doInBackground(Void... params) {
        if(jokrService==null){
            Jokr.Builder builder = new Jokr.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });

            jokrService = builder.build();
        }


        try {
            return jokrService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }

    }

    @Override
    protected void onPostExecute(String result) {
        //Toast.makeText(context, result, Toast.LENGTH_LONG).show();

        Intent displayJokeIntent = new Intent(context, JokrActivity.class);
        displayJokeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        displayJokeIntent.putExtra("JOKE_IN", result);
        context.startActivity(displayJokeIntent);
    }
}
