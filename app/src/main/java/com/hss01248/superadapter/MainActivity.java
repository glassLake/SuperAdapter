package com.hss01248.superadapter;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.hss01248.lib.MyRclyViewHolder;
import com.hss01248.lib.SuperRecyAdapter;

import java.util.ArrayList;

import butterknife.Bind;

public class MainActivity extends Activity {

    RecyclerView mRecyclerView;
    ArrayList<String> datas ;

    SuperRecyAdapter mAdapter;
   public static Activity mActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mActivity = this;
        mRecyclerView = (RecyclerView) findViewById(R.id.lv);
        datas = new ArrayList<>();

        datas.add("0");
        datas.add("two");
        datas.add("3");
        datas.add("four");
        datas.add("5");
        datas.add("six");

        datas.add("7");
        datas.add("eight");
        datas.add("9");
        datas.add("ten");
        datas.add("11");
        datas.add("twelve");

        datas.add("13");
        datas.add("fourteen");
        datas.add("15");
        datas.add("sixteen");
        datas.add("17");
        datas.add("eighteen");

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        mAdapter = new SuperRecyAdapter(datas,this) {

            public static final int TYPE_0 = 0;
            public static final int TYPE_1 = 1;
            @Override
            protected MyRclyViewHolder generateCoustomViewHolder(int viewType) {
                Log.e("jj",viewType+" viewType");

                switch (viewType){
                    case TYPE_0:
                      /* View view1 = View.inflate(mActivity,R.layout.holder_demo_list,null);
                        return new CustomHolder(view1);*/
                      long time0 =   System.currentTimeMillis();
                        MyRclyViewHolder viewHolder = MyRclyViewHolder.getSubInstance(mActivity,CustomHolder.class,R.layout.holder_demo_list);
                        long time1 = System.currentTimeMillis();
                        Log.e("00 getSubInstance",time1 - time0+"");
                        return viewHolder;
                    case TYPE_1:

                        long time2 =   System.currentTimeMillis();
                        View view2 = View.inflate(mActivity,R.layout.holder_demo_list_2,null);
                        MyRclyViewHolder holder = new CustomHolder2(view2);
                        long time3 = System.currentTimeMillis();
                        Log.e("00 new CustomHolder",time3 - time2+"");
                        return holder;
                    default:
                        return null;
                }

            }


            @Override
            public int getItemViewType(int position) {
                if (position % 2 == 0){//偶数位
                    return TYPE_0;
                }else {//奇数位
                    return TYPE_1;
                }

            }
        };

        mRecyclerView.setAdapter(mAdapter);





      /*  ListView listView = new ListView(this);
        ArrayList<String> datas = new ArrayList<>();

        SuperAdapter adapter = new SuperAdapter(datas, this) {
            @Override
            protected MyViewHolder generateNewHolder(int itemViewType) {
                return new CustomHolder(MainActivity.this);
            }
        };

        listView.setAdapter(adapter);


        adapter.add("hhhh");*/
    }





    public static  class CustomHolder extends MyRclyViewHolder {

        static {
            rootView = View.inflate(BaseApplication.mContext,R.layout.holder_demo_list,null);
        }

        @Bind(R.id.tv_text)
        TextView mTvText;

        public CustomHolder(View itemView) {
            super(itemView);
            Log.e("jj","CustomHolder");
        }


        @Override
        protected int setLayoutRes() {
            Log.e("jj","setLayoutRes");
            return R.layout.holder_demo_list;
        }

        @Override
        public void assignDatasAndEvents(Activity context, Object data) {
            mTvText.setText(data.toString());
        }


    }

   public static class CustomHolder2 extends MyRclyViewHolder {

        static {
            rootView = View.inflate(BaseApplication.mContext,R.layout.holder_demo_list_2,null);
        }

        @Bind(R.id.tv_text)
        TextView mTvText;

        public CustomHolder2(View itemView) {
            super(itemView);
        }


        @Override
        protected int setLayoutRes() {
            return R.layout.holder_demo_list_2;
        }

        @Override
        public void assignDatasAndEvents(Activity context, Object data) {
            mTvText.setText(data.toString());
        }


    }
}
