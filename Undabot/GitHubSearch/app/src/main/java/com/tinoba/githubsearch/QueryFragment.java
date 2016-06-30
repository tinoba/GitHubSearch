package com.tinoba.githubsearch;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by tinoba on 1.7.2016..
 */
public class QueryFragment extends Fragment{
    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.query_fragment,container,false);
        return view;
    }
}
