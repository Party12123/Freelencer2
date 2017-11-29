package com.example.home.freelencer2;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

public class Navigation extends Fragment{

    AdapterPage adapter;
    ViewPager viewPager;
    public Navigation(){

    }

    public static Fragment newInstance(){
        Navigation navigation = new Navigation();
        Bundle bundle = new Bundle();
        navigation.setArguments(bundle);
        return navigation;
    }
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_navigation,container,false);
        adapter = new AdapterPage(getFragmentManager());
        viewPager = view.findViewById(R.id.container);
        setupViewPage(viewPager);
        TabLayout tabLayout = view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }

    private void setupViewPage(ViewPager viewPager){
        AdapterPage adapterPage = new AdapterPage(getChildFragmentManager());
        adapterPage.addFragment(new PageNavigationUser(),"รายงาน");
        adapterPage.addFragment(new PageNavigationPro(),"Promotions");
        viewPager.setAdapter(adapterPage);
    }

}
