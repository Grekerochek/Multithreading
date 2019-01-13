package com.alexander.multithreading;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class SecondFragment extends Fragment {

    private TextView textView;
    private Button button;

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
        button = new Button(this.getContext());
        button.setText(R.string.newInt);
        layout.addView(textView);
        layout.addView(button);
        ConstraintLayout.LayoutParams layoutParamsText = (ConstraintLayout.LayoutParams) textView.getLayoutParams();
        ConstraintLayout.LayoutParams layoutParamsButton = (ConstraintLayout.LayoutParams) button.getLayoutParams();
        layoutParamsText.bottomToBottom = R.id.containerNew;
        layoutParamsText.topToTop = R.id.containerNew;
        layoutParamsText.startToStart = R.id.containerNew;
        layoutParamsText.endToEnd = R.id.containerNew;
        layoutParamsButton.startToStart = R.id.containerNew;
        layoutParamsButton.endToEnd = R.id.containerNew;
        textView.setLayoutParams(layoutParamsText);
        button.setLayoutParams(layoutParamsButton);
        return layout;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new MyAsyncTask().execute();
            }
        });
    }

    private class MyAsyncTask extends AsyncTask<Void, Integer, Integer> {

        public static final int DELAY = 2000;

        private Random random;


        public MyAsyncTask(){
            random = new Random();
        }

        @Override
        protected Integer doInBackground(Void... voids) {

            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e){
                Log.e("InterruptedException", e.getMessage());
            }
            return getRandomInt();
        }

        @Override
        protected void onPostExecute(Integer integer) {
            textView.setText(String.valueOf(integer));
        }

        private int getRandomInt(){
            return random.nextInt();
        }

    }
}
