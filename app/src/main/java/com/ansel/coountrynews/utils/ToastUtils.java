package com.ansel.coountrynews.utils;

import android.widget.Toast;

import com.ansel.coountrynews.App;

public class ToastUtils {

    private static Toast mToast;

    /**
     * 显示Toast
     */
    public static void showToast( CharSequence text) {
        if (mToast == null) {
            mToast = Toast.makeText(App.getInstance(), text, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(text);
        }
        mToast.show();
    }


}
