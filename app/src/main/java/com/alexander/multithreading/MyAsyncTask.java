package com.alexander.multithreading;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;

import java.util.Random;

public class MyAsyncTask extends AsyncTask<Void, Integer, Integer> {

    public static final int SHOW_INT = 1000;
    public static final int DELAY = 2000;
    private Random random;
    private Handler handler;

    public MyAsyncTask(Handler handler){
        random = new Random();
        this.handler = handler;
    }

    @Override
    protected Integer doInBackground(Void... voids) {

        for (int i=0; i<100; i++){
            try {
                Thread.sleep(2000);
                showText(getRandomInt());
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        return getRandomInt();
    }

    private int getRandomInt(){
        return random.nextInt();
    }

    public void showText(Integer text){
        Message msg = new Message();
        msg.what = SHOW_INT;
        msg.obj = text;
        handler.sendMessageDelayed(msg, DELAY);

    }

}
