package com.hss01248.superadapter;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.hss01248.lib.SuperRcvHolder;
import com.hss01248.lib.SuperRcvAdapter;

import java.util.ArrayList;

import butterknife.Bind;

public class MainActivity extends Activity {

    RecyclerView mRecyclerView;
    ArrayList<String> datas;

    SuperRcvAdapter mAdapter;
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

        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false));

        mAdapter = new SuperRcvAdapter(datas, mActivity) {

            public static final int TYPE_0 = 0;
            public static final int TYPE_1 = 1;

            @Override
            protected SuperRcvHolder generateCoustomViewHolder(int viewType) {

                switch (viewType) {
                    case TYPE_0:
                        return new CustomHolder(inflate(R.layout.holder_demo_list));
                    case TYPE_1:
                        return new CustomHolder2(inflate(R.layout.holder_demo_list_2));
                    default:
                        return new SuperRcvHolder<String>(inflate(R.layout.holder_demo_list_2)) {//匿名子类
                            private TextView tv_text;

                            @Override
                            public void assignDatasAndEvents(Activity context, String data) {
                                super.assignDatasAndEvents(context, data);
                                tv_text.setText(data);
                            }
                        };
                }

            }


            @Override
            public int getItemViewType(int position) {
                if (position % 2 == 0) {//偶数位
                    return TYPE_0;
                } else {//奇数位
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


    class CustomHolder extends SuperRcvHolder<String> {

        @Bind(R.id.tv_text)
        TextView mTvText;

        public CustomHolder(View itemView) {
            super(itemView);
        }


        @Override
        public void assignDatasAndEvents(Activity context, String data) {
            mTvText.setText(data.toString());
        }
    }

    public static class CustomHolder2 extends SuperRcvHolder<String> {


        @Bind(R.id.tv_text)
        TextView mTvText;

        public CustomHolder2(View itemView) {
            super(itemView);
        }


        @Override
        public void assignDatasAndEvents(Activity context, String data) {
            mTvText.setText(data.toString());
        }


    }
}
