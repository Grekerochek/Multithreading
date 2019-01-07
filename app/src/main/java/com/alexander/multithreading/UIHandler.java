package com.alexander.multithreading;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;


public class UIHandler extends Handler {

    public static final int DELAY = 2000;
    public static final int SHOW_INT = 1000;

    public UIHandler(){
        super(Looper.getMainLooper());
    }

    @Override
    public void handleMessage(Message msg) {
        handleUIMessage(msg);
    }

    private void handleUIMessage(Message msg) {
    }


}
