package com.hss01248.lib;

import android.app.Activity;
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

    protected abstract int setLayoutRes();


    public void assingDatasAndEvents(Activity context, T bean){

    }




    public void assingDatasAndEvents(Activity context, T bean, int position){

    }
    public void assingDatasAndEvents(Activity context, T bean, boolean isLast){

    }
    public void assingDatasAndEvents(Activity context, T bean, boolean isLast, int position ){

    }



}
