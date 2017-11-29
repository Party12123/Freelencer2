package com.example.home.freelencer2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;

/**
 * Created by Home on 11/29/2017.
 */

public class PageNavigationPro extends Fragment {
    private static final String TAG2 = "TapnavigationPro";

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pagenavagationpro,container,false);
        return view;
    }
}
