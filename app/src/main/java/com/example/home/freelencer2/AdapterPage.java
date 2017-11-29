package com.example.home.freelencer2;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Home on 11/29/2017.
 */

class AdapterPage extends FragmentPagerAdapter{
    private final List<Fragment> mfragmentList = new ArrayList<>();
    private final List<String> mFragmentTitle = new ArrayList<>();
    public AdapterPage(FragmentManager fm) {
        super(fm);
    }
    public void addFragment(Fragment fragment, String title){
        mfragmentList.add(fragment);
        mFragmentTitle.add(title);
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitle.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return mfragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mfragmentList.size();
    }
}
