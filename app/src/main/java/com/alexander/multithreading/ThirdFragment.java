package com.alexander.multithreading;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;

public class ThirdFragment extends Fragment {

    public static String ARRAY = "ARRAY";

    public static ThirdFragment newInstance(){
        ThirdFragment fragment = new ThirdFragment();
        return fragment;
    }

    public static ThirdFragment newInstance(Bundle bundle){
        ThirdFragment fragment = new ThirdFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ConstraintLayout layout = new ConstraintLayout(this.getContext());
        RecyclerView recyclerView = new RecyclerView(this.getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
//        recyclerView.setAdapter(new Adapter(getArguments().getStringArrayList(ARRAY)));
        recyclerView.setAdapter(new Adapter(new ArrayList<String>(Arrays.asList("454"))));
        layout.addView(recyclerView);
        return layout;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
