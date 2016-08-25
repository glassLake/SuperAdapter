package com.hss01248.lib;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2016/8/26.
 */
public class ContextMaintainer {

    public static Context context;
    public static void setContext(Application context){
        ContextMaintainer.context = context;
    }
}
