package com.tunghh.footballdata.commonswidget;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by TungHH on 8/22/2016.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> mFragments = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm, Collection<Fragment> fragments) {
        super(fm);
        mFragments.addAll(fragments);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }


}
