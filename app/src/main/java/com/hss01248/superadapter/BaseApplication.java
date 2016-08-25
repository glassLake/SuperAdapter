package com.hss01248.superadapter;

import android.app.Application;

import com.hss01248.lib.ContextMaintainer;

/**
 * Created by Administrator on 2016/8/26.
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ContextMaintainer.setContext(this);
    }
}
