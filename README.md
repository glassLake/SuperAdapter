# SuperAdapter
listview和recycleview的adapter的封装,考虑重用性和可读性,不过度抽象

# 使用

# gradle:

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
Step 2. Add the dependency

	dependencies {
	        compile 'com.github.glassLake:SuperAdapter:1.0.0'
	}

# 使用

## 使用技巧: 

> listview,recycleview的数据与界面达到完全的一一对应,如果服务器返回的数据不对应,那么重新组合,如果有一个item无需数据,那么在datas里插入null或无意义的数据,holder多一种类型来处理即可.

## SuperLvAdapter: 

单一类型item时，使用匿名实现类即可，多种类型时，重写getItemViewTypeCount和getItemViewType(position) 即可,无需更改getview内部的逻辑.

## SuperLvHolder:

写子类的时候在子类内部指定layout文件,一般情况下,实现assingDatasAndEvents(Activity context, String bean)就可以,如果要用到int position ,boolean isLast,就实现更多参数的同名方法,此时,上面那个简化的方法空实现即可.

如果该holder在多个地方使用,那么可以作为单独的类,达到复用的目的.

## SuperRcvAdapter和SuperRcvHolder

adapter一般情况下都使用匿名子类.多个item时分别指定类型和对应的hoder即可.
holder一般也使用匿名子类.如果在其他页面需要复用,那么可以写成单独的子类.其layout文件需要在构造函数前传入,已封装好方法.

# 示例代码

## AbstractListview 的 SuperLvAdapter:

### adapter:(这里示例代码是只有一种itemtype的情况)

      ListView listView = new ListView(this);
        ArrayList<String> datas = new ArrayList<>();

        SuperLvAdapter adapter = new SuperLvAdapter(datas, this) {
            @Override
            protected SuperLvHolder generateNewHolder(Activity context,int viewType) {
                return new CustomHolder(context);
            }
        };

        listView.setAdapter(adapter);


        adapter.add("hhhh");
        
        
### viewholder的实现:

      class CustomHolder extends SuperLvHolder<String> {

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
    
    
## RecycleView 的 SuperRcvAdapter:

### SuperRcvAdapter,多种类型下的使用

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


### holder的实现:

    class CustomHolder extends SuperRcvHolder<String> {

        @Bind(R.id.tv_text)
        TextView mTvText;

        public CustomHolder(View itemView) {
            super(itemView);
        }


        @Override
        public void assignDatasAndEvents(Activity context, String data) {
            mTvText.setText(data);
        }
    }
