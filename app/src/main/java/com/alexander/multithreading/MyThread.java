package com.alexander.multithreading;

import android.os.Handler;
import android.os.Message;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MyThread extends Thread {

    public static final int SHOW_STRING = 1001;
    private static final int DELAY = 3000;
    private static List<String> maleNames = new ArrayList<>(Arrays.asList("John", "Bill", "Bob", "Oliver", "Jack", "Harry", "George", "William", "Henry"));

    private Random random;
    private Handler handler;

    public MyThread(Handler handler){
        random = new Random();
        this.handler = handler;
    }

    @Override
    public void run() {
        for (int i=0; i<100; i++){
            try {
                Thread.sleep(2000);
                showText(getRandomName());
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    private String getRandomName(){

        return maleNames.get(random.nextInt(maleNames.size()));
    }

    public void showText(String text){
        Message msg = new Message();
        msg.what = SHOW_STRING;
        msg.obj = text;
        handler.sendMessageDelayed(msg, DELAY);

    }
}
