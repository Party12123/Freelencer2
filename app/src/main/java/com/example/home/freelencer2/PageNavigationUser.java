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

public class PageNavigationUser extends Fragment {
    private static final String TAG1 = "TapnavigationUser";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pagenavagation,container,false);

        return view;
    }
}
