package com.alexander.multithreading;

import android.os.AsyncTask;
import android.os.Message;

import java.util.Random;

public class MyAsyncTask extends AsyncTask<Void, Integer, Integer> {

    public static final int SHOW_INT = 1000;

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

    public void showText(String text){
        Message msg = new Message();
        msg.what = SHOW_INT;
        msg.obj = text;
    }

}
