package com.hss01248.lib;

import android.app.Activity;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/8/22 0022.
 */
public abstract class MyRclyViewHolder extends RecyclerView.ViewHolder   {

    public static View rootView;



    //,Activity activity,int layoutRes

      {
         rootView = View.inflate(ContextMaintainer.context,setLayoutRes(),null);
         Log.e("jj","father   rootview inflate");
     }


    public MyRclyViewHolder(View itemView) {
        super(rootView);
        ButterKnife.bind(this,rootView);
        Log.e("jj","father  MyRclyViewHolder()");
    }

    /*public MyRclyViewHolder(View itemView, Context context){

    }*/



    protected  abstract     @LayoutRes int setLayoutRes();

    public  void assignDatasAndEvents(Activity context, Object data, int position,
                                              boolean isLast, List datas, SuperRecyAdapter superRecyAdapter){
        assignDatasAndEvents(context,data);
    }

    public abstract void assignDatasAndEvents(Activity context, Object data);


}
