package com.ansel.coountrynews.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ansel.coountrynews.fragment.PageFragment;

/**
 * Created by Junguo.L on 2017/7/6.
 */


public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

//    private String[] tabTitles = new String[]{"tab1","tab2","tab3"};
    private String[] tabTitles = new String[]{"首页","政务","tab3","tab4","tab5","tab6","tab7","tab8","tab9"};
    private Context context;

    public SimpleFragmentPagerAdapter(FragmentManager fm, Context context, String[] title) {
        super(fm);
        this.context = context;
        this.tabTitles = title;
    }

    @Override
    public Fragment getItem(int position) {
        return PageFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}