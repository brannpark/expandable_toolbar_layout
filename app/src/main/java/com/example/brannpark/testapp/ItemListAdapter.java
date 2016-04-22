package com.example.brannpark.testapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by brannpark on 2015. 12. 29..
 */

public class ItemListAdapter extends BaseAdapter {
    private List<String> items;
    Context mContext;

    public ItemListAdapter(Context context) {
        mContext = context;
    }


    public void setItems(List<String> items) {
        this.items = items;
    }



    @Override
    public int getCount() {
        return items == null ? 0 : items.size();
    }

    @Override
    public Object getItem(int position) {
        return items == null ? null : items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView tv;
        if (convertView == null) {
            tv = new TextView(mContext);
            convertView = tv;
        } else {
            tv = (TextView)convertView;
        }

        tv.setText(items.get(position));

        return convertView;
    }
}
