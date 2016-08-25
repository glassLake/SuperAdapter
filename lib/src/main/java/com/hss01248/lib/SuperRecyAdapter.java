package com.hss01248.lib;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2016/8/22 0022.
 */
public  abstract   class SuperRecyAdapter extends RecyclerView.Adapter<MyRclyViewHolder> implements Refreshable {


    private List datas;
    private Activity context;





    public SuperRecyAdapter(@NonNull List datas, Activity context){
        this.datas = datas;
        this.context = context;

    }


    @Override
    public MyRclyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //ViewGroup rootView = (ViewGroup) View.inflate(context,layoutRes,null);
        return generateCoustomViewHolder(viewType);
    }



    protected abstract MyRclyViewHolder generateCoustomViewHolder(int viewType);

    @Override
    public void onBindViewHolder(MyRclyViewHolder holder, int position) {
        holder.assignDatasAndEvents(context,datas.get(position),position,position == getItemCount() -1,datas,this);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    @Override
    public void refresh(List newData) {
        if (newData == null){
            datas.clear();
            notifyDataSetChanged();
            return;
        }
        if (datas == null){
            datas = newData;
            notifyDataSetChanged();
        }else {
            datas.clear();
            datas.addAll(newData);
            notifyDataSetChanged();
        }
    }

    @Override
    public void addAll(List newData) {
        if (newData == null){
            return;
        }
        if (datas == null){
            datas = newData;
            notifyDataSetChanged();
        }else {
            datas.addAll(newData);
            notifyDataSetChanged();
        }
    }

    @Override
    public void clear() {
        if (datas != null){
            datas.clear();
            notifyDataSetChanged();
        }
    }

    @Override
    public void delete(int position) {
        if (datas != null && position < getItemCount()){
            datas.remove(position);
            notifyDataSetChanged();
        }
    }

    @Override
    public void add(Object object) {
        if (object != null){
            datas.add(object);
        }

    }

    public List getListData(){
        return datas;
    }

    /*public class  ViewHolder extends RecyclerView.ViewHolder {
        public  ViewGroup rootView;
        public ViewHolder(View itemView) {
            super(itemView);
            rootView = (ViewGroup) itemView;
            ButterKnife.bind(this,rootView);

        }

        public void assignDatasAndEvents(Activity context,Object data,int position){
            SuperRclyAdapter.this.assignDatasAndEvents(context,data,position);
        }


    }*/
}
