package com.example.act1_constraintlayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    Context mContext;
    LayoutInflater inflater;
    private ArrayList<ClassNama> arrayList;

    public ListViewAdapter(Context context){
        mContext = context;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<ClassNama>();
        this.arrayList.addAll(HomeActivity.classNamaArrayList);
    }
    public class ViewHolder{
        TextView name;

    }

    @Override
    public int getCount() {
        return HomeActivity.classNamaArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return HomeActivity.classNamaArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View v, ViewGroup viewGroup) {
        final ViewHolder holder;
        if(v == null){
            holder = new ViewHolder();
            v = inflater.inflate(R.layout.item_listview,null);
            holder.name = v.findViewById(R.id.tvNama_Item);
            v.setTag(holder);
        }else{
            holder =(ViewHolder) v.getTag();
        }
        holder.name.setText(HomeActivity.classNamaArrayList.get(i).getNama());
        return v;
    }
}


