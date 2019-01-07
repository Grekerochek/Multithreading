package com.alexander.multithreading;

import android.os.AsyncTask;

import java.util.Random;

public class MyAsyncTask extends AsyncTask<Void, Void, Integer> {

    private Random random;

    public MyAsyncTask(){
        random = new Random();
    }

    @Override
    protected Integer doInBackground(Void... voids) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return getRandomInt();
    }

    private int getRandomInt(){
        return random.nextInt();
    }
}
