package com.example.administrator.wjchart.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.administrator.wjchart.R;

/**
 * Created by Administrator on 2016/5/26.
 */
public class UnReadAdapter extends BaseAdapter {
    private Context context;

    public UnReadAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if(convertView==null)
        {
            holder=new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.unread_item, null);
            convertView.setTag(holder);
        }
        else
        {
            holder=(ViewHolder) convertView.getTag();
        }


        return convertView;
    }

    class ViewHolder
    {

    }
}
