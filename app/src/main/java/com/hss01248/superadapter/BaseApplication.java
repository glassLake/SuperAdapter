package com.hss01248.superadapter;

import android.app.Application;
import android.content.Context;

import com.hss01248.lib.ContextMaintainer;

/**
 * Created by Administrator on 2016/8/26.
 */
public class BaseApplication extends Application {

  public static   Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        ContextMaintainer.setContext(this);
        mContext = this;
    }
}
