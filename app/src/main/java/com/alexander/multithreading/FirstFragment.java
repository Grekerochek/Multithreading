package com.alexander.multithreading;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class FirstFragment extends Fragment implements LoaderManager.LoaderCallbacks<Integer> {

    public static final int LOAD_ID = 10000;
    public static final String STRING_KEY = "String-key";

    private Loader<Integer> loader;

    private View layout;

    public static FirstFragment newInstance(){
        FirstFragment fragment = new FirstFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = new LinearLayout(this.getContext());
        layout.setBackgroundColor(Color.BLUE);
        return layout;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loader = getActivity().getSupportLoaderManager().initLoader(LOAD_ID, null, this);
        loader.forceLoad();

    }

    @NonNull
    @Override
    public Loader<Integer> onCreateLoader(int id, @Nullable Bundle bundle) {
        Loader<Integer> loader = null;
        if (id == LOAD_ID){
            loader = new MyLoader(this.getContext());
        }
        return loader;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Integer> loader, Integer color) {
        layout.setBackgroundColor(color);
        loader.forceLoad();
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Integer> loader) {

    }
}
