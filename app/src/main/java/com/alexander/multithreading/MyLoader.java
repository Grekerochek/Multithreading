package com.alexander.multithreading;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MyLoader extends AsyncTaskLoader<Integer> {

    private List<Integer> colors;
    private Random random;

    public MyLoader(@NonNull Context context) {
        super(context);
        colors = new ArrayList<>(Arrays.asList(Color.BLUE, Color.BLACK, Color.RED, Color.GRAY, Color.GREEN));
        random = new Random();
    }

    @Nullable
    @Override
    public Integer loadInBackground() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return getRandomColor();
    }
    private int getRandomColor(){
        return colors.get(random.nextInt(colors.size()));
    }
}
