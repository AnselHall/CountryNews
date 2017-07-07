package com.ansel.coountrynews.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Junguo.L on 2017/7/5.
 */

public class HomeVPAdapter extends PagerAdapter {

    private List<View> listViews;

    public HomeVPAdapter(List<View> listViews) {
        this.listViews = listViews;
    }

    @Override
    public int getCount() {
        return listViews.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(listViews.get(position));

        return listViews.get(position);
    }
}
