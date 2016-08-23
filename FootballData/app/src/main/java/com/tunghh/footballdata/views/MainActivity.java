package com.tunghh.footballdata.views;

import android.support.annotation.LayoutRes;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.tunghh.footballdata.R;

public class MainActivity extends BaseActivity implements TabLayout.OnTabSelectedListener {


    private final Class[] PAGE_FRAGMENTS = {
            CompetitionFragment.class,
            TeamFragment.class,
            PlayerFragment.class
    };

    private final String[] TABTITLE = {
            "Leagues", "Teams", "Players"
    };
    ViewPager viewpager;
    Toolbar toolBar;
    TabLayout tablayout;

    @LayoutRes
    int getContentView(){
        return R.layout.activity_main;
    }

    @Override
    void initLayout() {
        toolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);

        viewpager = (ViewPager) findViewById(R.id.viewpager);
        viewpager.setAdapter(new MainFragmentPagerAdapter(getSupportFragmentManager()));

        tablayout = (TabLayout) findViewById(R.id.tablayout);
        tablayout.setupWithViewPager(viewpager);

        for (int i = 0; i < PAGE_FRAGMENTS.length; ++i){
            tablayout.getTabAt(i).setText(TABTITLE[i]);
        }

    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewpager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }


    /*
     * FragmentPagerAdapter use for Viewpager init fragment.
     */
    public class MainFragmentPagerAdapter extends FragmentPagerAdapter {

        public MainFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return Fragment.instantiate(
                    MainActivity.this,PAGE_FRAGMENTS[position].getName());
        }

        @Override
        public int getCount() {
            return PAGE_FRAGMENTS.length;
        }
    }
}
