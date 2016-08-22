package com.hss01248.lib;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/8/22 0022.
 */
public abstract class MyRclyViewHolder extends RecyclerView.ViewHolder   {

    public ViewGroup rootView;

    public MyRclyViewHolder(View itemView) {
        super(itemView);
        rootView = (ViewGroup) itemView;
        ButterKnife.bind(this,rootView);
    }

    public abstract void assignDatasAndEvents(Activity context, Object data, int position);
}
