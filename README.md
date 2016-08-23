# SuperAdapter
listview和recycleview的adapter的封装,考虑重用性和可读性,不过度抽象

# 使用

## SuperAdapter: 

单一类型item时，使用匿名实现类即可，多种类型时，重写getItemViewTypeCount和getItemViewType(position) 即可,无需更改getview内部的逻辑.

## MyViewHolder:

一般情况下,实现assingDatasAndEvents(Activity context, String bean)就可以,如果要用到int position ,boolean isLast,就实现assingDatasAndEvents(Activity context, T bean, int position ,boolean isLast),此时,上面那个简化的方法空实现即可.

如果该item在多个地方使用,那么可以作为单独的类.

## 示例代码

### adapter:

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
        
        
### viewholder的实现:

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

