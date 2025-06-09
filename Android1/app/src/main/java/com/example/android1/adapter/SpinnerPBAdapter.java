package com.example.android1.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.android1.R;
import com.example.android1.model.PhongBan;

import java.util.ArrayList;

public class SpinnerPBAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<PhongBan> listPB;

    public SpinnerPBAdapter(Context context, ArrayList<PhongBan> listPB) {
        this.context = context;
        this.listPB = listPB;
    }

    @Override
    public int getCount() {
        return listPB.size();
    }

    @Override
    public Object getItem(int position) {
        return listPB.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_phong_ban, parent, false);
        TextView txtTenPB = view.findViewById(R.id.txtTenPB);
        txtTenPB.setText(listPB.get(position).getTenpb());
        return view;
    }
}
