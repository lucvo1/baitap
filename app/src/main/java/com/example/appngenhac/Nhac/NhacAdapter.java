package com.example.appngenhac.Nhac;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appngenhac.R;

import java.util.List;

public class NhacAdapter extends BaseAdapter {
    Context myContext;
    int myLayout;
    List<Nhac> arrayNhac;
    public NhacAdapter(Context context, int layout, List<Nhac> nhacList){
       myContext = context;
       myLayout = layout;
       arrayNhac = nhacList;
    }

    @Override
    public int getCount() {
        return arrayNhac.size();
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
        LayoutInflater inflater = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(myLayout,null);
        TextView txtTenBH = (TextView) convertView.findViewById(R.id.texttenbh);
        txtTenBH.setText(arrayNhac.get(position).TenBH);
        TextView txtTenCS = (TextView) convertView.findViewById(R.id.texttencasi);
        txtTenCS.setText(arrayNhac.get(position).TenCaSi);
        ImageView img = (ImageView) convertView.findViewById(R.id.image);
        img.setImageResource(arrayNhac.get(position).Hinh);
        return convertView;
    }
}
