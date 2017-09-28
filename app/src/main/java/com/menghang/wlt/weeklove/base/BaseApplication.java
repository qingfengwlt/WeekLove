package com.menghang.wlt.weeklove.base;

import android.app.Application;

/**
 * Created by Administrator on 2017/8/27.
 */

public class BaseApplication extends Application {

    public static BaseApplication mInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance=this;
    }
}
