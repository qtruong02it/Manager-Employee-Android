package com.example.android1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.android1.adapter.SpinnerPBAdapter;
import com.example.android1.model.NhanVien;
import com.example.android1.model.PhongBan;

import java.util.ArrayList;

public class SuaNVActivity extends AppCompatActivity {
    private String tenpb="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sua_nvactivity);

        //ánh xạ
        EditText edtMaNV = findViewById(R.id.edtMaNV);
        EditText edtTenNV = findViewById(R.id.edtTenNV);
        Spinner spnTenPB = findViewById(R.id.spnTenPB);
        Button btnSuaNV = findViewById(R.id.btnSuaNV);
        Button btnTroVe = findViewById(R.id.btnTroVe);

        //set adapter cho spinner
        ArrayList<PhongBan> listPB = new PhongBanActivity().getDSPB();
        SpinnerPBAdapter adapter = new SpinnerPBAdapter(SuaNVActivity.this, listPB);
        spnTenPB.setAdapter(adapter);

        //lấy dữ liệu spinner
        spnTenPB.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(ThemNVActivity.this, listPB.get(position).getTenpb(), Toast.LENGTH_SHORT).show();
                tenpb = listPB.get(position).getTenpb();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //nhận dữ liệu
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        NhanVien nhanVien = (NhanVien) bundle.getSerializable("nhanVienSua");
        int viTriSua = bundle.getInt("viTriSua");
        edtMaNV.setText(nhanVien.getMavn());
        edtTenNV.setText(nhanVien.getTennv());

        int viTri = -1;
        for (int i = 0; i < listPB.size(); i++){
            if (listPB.get(i).getTenpb().equals(nhanVien.getTenpb())){
                viTri = i;
                break;
            }
        }
        spnTenPB.setSelection(viTri);

        //chỉnh sửa thông tin
        btnSuaNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String manv = edtMaNV.getText().toString();
                String tennv = edtTenNV.getText().toString();

                NhanVien nhanVienSua = new NhanVien(manv, tennv, tenpb);

                Intent intentSua = new Intent();
                Bundle bundleSua = new Bundle();
                bundleSua.putSerializable("nhanVienSua", nhanVienSua);
                bundleSua.putInt("viTriSua", viTriSua);
                intentSua.putExtras(bundleSua);
                setResult(2, intentSua);
                finish();
            }
        });
    }
}