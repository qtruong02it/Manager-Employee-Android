package com.example.android1.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;

import com.example.android1.R;
import com.example.android1.SuaNVActivity;
import com.example.android1.model.NhanVien;

import java.util.ArrayList;

public class NhanVienAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<NhanVien> listNV;
    private ActivityResultLauncher<Intent> myLauncher;

    public NhanVienAdapter(Context context, ArrayList<NhanVien> listNV, ActivityResultLauncher<Intent> myLauncher) {
        this.context = context;
        this.listNV = listNV;
        this.myLauncher = myLauncher;
    }

    @Override
    public int getCount() {
        return listNV.size();
    }

    @Override
    public Object getItem(int position) {
        return listNV.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_nhan_vien, parent, false);

        TextView txtMaNV = view.findViewById(R.id.txtMaNV);
        TextView txtTenNV = view.findViewById(R.id.txtTenNV);
        TextView txtTenPB = view.findViewById(R.id.txtTenPB);
        ImageView ivEdit = view.findViewById(R.id.ivEdit);
        ImageView ivDel = view.findViewById(R.id.ivDel);

        txtMaNV.setText(listNV.get(position).getMavn());
        txtTenNV.setText(listNV.get(position).getTennv());
        txtTenPB.setText(listNV.get(position).getTenpb());

        ivEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SuaNVActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("nhanVienSua", listNV.get(position));
                bundle.putInt("viTriSua", position);
                intent.putExtras(bundle);
                myLauncher.launch(intent);
            }
        });

        ivDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listNV.remove(position);
                notifyDataSetChanged();
            }
        });

        return view;
    }
}
