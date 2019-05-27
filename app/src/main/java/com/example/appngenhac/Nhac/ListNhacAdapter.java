package com.example.appngenhac.Nhac;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appngenhac.R;

import java.util.List;

public class ListNhacAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<ListNhac> nhacList;

    public ListNhacAdapter(Context context, int layout, List<ListNhac> nhacList){
        this.context =context;
        this.layout = layout;
        this.nhacList = nhacList;
    }
    @Override
    public int getCount() {
        return nhacList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    private class ViewHolder{
        TextView txtTen;
        ImageView imgDelete, imgEdit;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        ViewHolder holder;

        if(view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            holder.txtTen = (TextView) view.findViewById(R.id.textviewten);
            holder.imgDelete = (ImageView) view.findViewById(R.id.imageviewdel);
            holder.imgEdit = (ImageView) view.findViewById(R.id.imageviewedit);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }

        ListNhac listNhac = nhacList.get(i);
        holder.txtTen.setText(listNhac.getTenBH());
        return view;
    }
}
