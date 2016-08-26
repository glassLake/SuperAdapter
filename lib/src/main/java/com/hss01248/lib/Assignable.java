package com.hss01248.lib;

import android.app.Activity;

import java.util.List;

/**
 * Created by Administrator on 2016/8/26 0026.
 */
public interface Assignable<T> {

    <T> void assignDatasAndEvents(Activity context, T data, int position,
                                         boolean isLast, boolean isListViewFling, List datas, SuperRecycleAdapter superRecyAdapter);


     <T> void assignDatasAndEvents(Activity context, T data);
}
