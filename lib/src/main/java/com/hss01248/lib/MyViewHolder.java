package com.hss01248.lib;

import android.app.Activity;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/4/15 0015.
 */
public abstract class MyViewHolder<T> {

    public ViewGroup rootView;


    public MyViewHolder(Activity context){
        rootView = (ViewGroup) View.inflate(context,setLayoutRes(),null);
        ButterKnife.bind(this,rootView);
    }

    protected abstract  @LayoutRes  int setLayoutRes();


    /**
     * 一般情况下，实现这个方法就足够了
     * @param context
     * @param bean
     */
    public  abstract void assingDatasAndEvents(Activity context, T bean);


    /**
     * 如果有需要，实现这个方法
     * @param context
     * @param bean
     * @param position
     * @param isLast
     */
    public void assingDatasAndEvents(Activity context, T bean, int position ,boolean isLast){
        assingDatasAndEvents(context,bean);


    }



}
