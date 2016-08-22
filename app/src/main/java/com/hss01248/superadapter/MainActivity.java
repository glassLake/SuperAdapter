package com.hss01248.superadapter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.hss01248.lib.MyViewHolder;
import com.hss01248.lib.SuperAdapter;

import java.util.ArrayList;

import butterknife.Bind;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = new ListView(this);
        ArrayList<String> datas = new ArrayList<>();

        SuperAdapter adapter = new SuperAdapter(datas, this) {
            @Override
            protected MyViewHolder generateNewHolder() {
                return new CustomHolder(MainActivity.this);
            }
        };

        listView.setAdapter(adapter);


        adapter.add("hhhh");
    }


    class CustomHolder extends MyViewHolder<String> {

        @Bind(R.id.tv_text)
        TextView mTvText;

        public CustomHolder(Activity context) {
            super(context);
        }

        @Override
        protected int setLayoutRes() {
            return R.layout.holder_demo_list;
        }

        @Override
        public void assingDatasAndEvents(Activity context, String bean) {
            mTvText.setText(bean);
        }
    }
}
