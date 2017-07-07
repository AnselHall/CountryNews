package com.ansel.coountrynews.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ansel.coountrynews.R;
import com.ansel.coountrynews.adapter.SimpleFragmentPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Junguo.L on 2017/7/5.
 */

public class NewsFragment extends Fragment {
    @BindView(R.id.tl)
    TabLayout tl;
    @BindView(R.id.vp)
    ViewPager vp;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_news, null);
        ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String[] title = getResources().getStringArray(R.array.home_title);

        SimpleFragmentPagerAdapter simpleFragmentPagerAdapter = new SimpleFragmentPagerAdapter(getFragmentManager(), getActivity(),title);
        vp.setAdapter(simpleFragmentPagerAdapter);

        tl.setupWithViewPager(vp);
//        tl.setTabMode(TabLayout.MODE_FIXED);
        tl.setTabMode(TabLayout.MODE_SCROLLABLE);

    }

}
