package com.alexander.multithreading;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class SecondFragment extends Fragment {

    TextView textView;
    MyAsyncTask asyncTask;

    public static SecondFragment newInstance(){
        SecondFragment fragment = new SecondFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ConstraintLayout layout = new ConstraintLayout(this.getContext());
        textView = new TextView(this.getContext());
        textView.setId(R.id.textView);
        layout.addView(textView);
        return layout;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        asyncTask = new MyAsyncTask();
        for (int i=0; i<100; i++){
            try {
                textView.setText(asyncTask.execute().get().toString());
            } catch (ExecutionException | InterruptedException e){
                e.printStackTrace();
            }
        }


    }
}
