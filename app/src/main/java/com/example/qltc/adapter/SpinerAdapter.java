package com.example.qltc.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class SpinerAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<String> spinerList;

    public SpinerAdapter(Context context, int layout, ArrayList<String> spinerList) {
        this.context = context;
        this.layout = layout;
        this.spinerList = spinerList;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    class ViewHoler{
        TextView txtSpiner;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHoler viewHoler;
        if(convertView == null){
            viewHoler = new ViewHoler();
//            LinearLayout
        }
        return null;
    }
}
