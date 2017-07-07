package com.ansel.coountrynews;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.ansel.coountrynews.fragment.MyFragment;
import com.ansel.coountrynews.fragment.NewsFragment;
import com.ansel.coountrynews.fragment.ServiceFragment;
import com.ansel.coountrynews.fragment.TvFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.iv_news)
    ImageView ivNews;
    @BindView(R.id.iv_tv)
    ImageView ivTv;
    @BindView(R.id.iv_service)
    ImageView ivService;
    @BindView(R.id.iv_interaction)
    ImageView ivInteraction;
    @BindView(R.id.iv_my)
    ImageView ivMy;
    @BindView(R.id.fl_content)
    FrameLayout flContent;

    private int position = 0;
    private NewsFragment newsFragment;
    private TvFragment tvFragment;
    private ServiceFragment serviceFragment;
    private MyFragment myFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
        initListener();
    }

    private void initView() {

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        newsFragment = new NewsFragment();
        ft.add(R.id.fl_content, newsFragment);

        tvFragment = new TvFragment();

        serviceFragment = new ServiceFragment();

        myFragment = new MyFragment();


        ft.commitAllowingStateLoss();
        fm.executePendingTransactions();
    }

    private void initListener() {
        ivNews.setOnClickListener(this);
        ivTv.setOnClickListener(this);
        ivService.setOnClickListener(this);
        ivInteraction.setOnClickListener(this);
        ivMy.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_news:
                if (position == 0) {
                    return;
                } else {
                    position = 0;
                }
                break;
            case R.id.iv_tv:
                if (position == 1) {
                    return;
                } else {
                    position = 1;
                }
                break;
            case R.id.iv_service:
                if (position == 2) {
                    return;
                } else {
                    position = 2;
                }
                break;
            case R.id.iv_interaction:
//                if (position == 3) {
//                    return;
//                } else {
//                    position = 3;
//                }
                break;
            case R.id.iv_my:
                if (position == 4) {
                    return;
                } else {
                    position = 4;
                }
                break;
            default:
                break;
        }

        refresh(position);
    }

    private void refresh(int position) {
        ivNews.setImageResource(position == 0 ? R.mipmap.bottom_news_color : R.mipmap.bottom_news);
        ivTv.setImageResource(position == 1 ? R.mipmap.bottom_tv_color : R.mipmap.bottom_tv);
        ivService.setImageResource(position == 2 ? R.mipmap.bottom_service_color : R.mipmap.bottom_service);
        ivInteraction.setImageResource(position == 3 ? R.mipmap.bottom_interaction_color : R.mipmap.bottom_interaction);
        ivMy.setImageResource(position == 4 ? R.mipmap.bottom_my_color : R.mipmap.bottom_my);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        switch (position) {
            case 0:

                ft.replace(R.id.fl_content, newsFragment);
                break;
            case 1:
                ft.replace(R.id.fl_content, tvFragment);
                break;
            case 2:
                ft.replace(R.id.fl_content, serviceFragment);
                break;
            case 3:
                break;
            case 4:
                ft.replace(R.id.fl_content, myFragment);
                break;
        }
        ft.commitAllowingStateLoss();
    }
}
