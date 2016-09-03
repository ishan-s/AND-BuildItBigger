package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.test.AndroidTestCase;

import java.util.concurrent.ExecutionException;

/**
 * Created by Ishan on 03-09-2016.
 */
public class GetJokeAsyncTaskTest extends AndroidTestCase {
    public void testGetJokeNotNull() {
        GetJokeAsyncTask task = new GetJokeAsyncTask(getContext());
        task.execute();

        String result = null;
        try{
            result = task.get();
        }catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertNotNull(result);
    }
}
