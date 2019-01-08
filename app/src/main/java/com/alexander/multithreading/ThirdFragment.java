package com.alexander.multithreading;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class ThirdFragment extends Fragment {

    private RecyclerView recyclerView;
    private Adapter adapter;
    private ArrayList<String> array;
    private Thread thread;

    private Handler handler = new Handler(Looper.getMainLooper()) {

        @Override
        public void handleMessage(Message message) {
            if (message.what == MyThread.SHOW_STRING) {
                array.add((String) message.obj);
                adapter.setData(array);
            }
        }
    };

    public static ThirdFragment newInstance(){
        ThirdFragment fragment = new ThirdFragment();
        fragment.array = new ArrayList<>();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) { ;
        recyclerView = new RecyclerView(this.getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        adapter = new Adapter(array);
        recyclerView.setAdapter(adapter);
        return recyclerView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        thread = new MyThread(handler);
        thread.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        thread.interrupt();
    }
}
