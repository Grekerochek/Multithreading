package com.alexander.multithreading;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class SecondFragment extends Fragment {

    public static final int SHOW_INT = 1000;

    private TextView textView;
    private MyAsyncTask asyncTask;

    private Handler handler = new Handler(Looper.getMainLooper()) {

        @Override
        public void handleMessage(Message message) {
            if (message.what == SHOW_INT) {
                textView.setText(String.valueOf((int) message.obj));
            }
        }
    };

    public static SecondFragment newInstance(){
        SecondFragment fragment = new SecondFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ConstraintLayout layout = new ConstraintLayout(this.getContext());
        layout.setId(R.id.containerNew);
        textView = new TextView(this.getContext());
        textView.setId(R.id.textView);
        layout.addView(textView);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) textView.getLayoutParams();
        layoutParams.bottomToBottom = R.id.containerNew;
        layoutParams.topToTop = R.id.containerNew;
        layoutParams.startToStart = R.id.containerNew;
        layoutParams.endToEnd = R.id.containerNew;
        textView.setLayoutParams(layoutParams);
        return layout;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        asyncTask = new MyAsyncTask(handler);
        asyncTask.execute();
    }
}
