package com.ansel.coountrynews.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Junguo.L on 2017/7/4.
 *
 * 此类为所有activity基类，所有activity应继承此类
 */

public abstract class BaseActivity extends FragmentActivity {

    private boolean isSetStatusBar=true;

    //    public static Activity mActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
//        getSupportActionBar().hide();

        initView(savedInstanceState);
        initIntentOrSavedInstanceState(savedInstanceState);
        initData();
        initListener();
        if (isSetStatusBar) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                Window window = getWindow();
                window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                        WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

//        mActivity=this;
    }

    @Override
    protected void onPause() {
        super.onPause();
//        mActivity=null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * 初始化界面，子类必须实现
     * @param savedInstanceState
     */
    public abstract void initView(Bundle savedInstanceState);

    /**
     * 初始化界面，子类必须实现
     */
    public void isStatusBarTransparent(boolean isSetStatusBar){
        this.isSetStatusBar = isSetStatusBar;
    }

    /**
     * 初始化数据,子类必须实现
     */
    public abstract void initData();

    /**
     * 初始化监听，子类选择是否实现
     */
    public void initListener() {
    }

    public void initIntentOrSavedInstanceState(Bundle savedInstanceState) {
    }
}