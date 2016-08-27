package com.hss01248.superadapter;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2016/8/26.
 */
public class BaseApplication extends Application {

  public static   Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();

        mContext = this;
    }
}
