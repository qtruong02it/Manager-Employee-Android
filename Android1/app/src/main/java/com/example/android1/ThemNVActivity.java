package com.example.android1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.android1.adapter.SpinnerPBAdapter;
import com.example.android1.model.NhanVien;
import com.example.android1.model.PhongBan;

import java.util.ArrayList;

public class ThemNVActivity extends AppCompatActivity {
    private String tenpb = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_them_nvactivity);
        //ánh xạ
        EditText edtMaNV = findViewById(R.id.edtMaNV);
        EditText edtTenNV = findViewById(R.id.edtTenNV);
        Spinner spnTenPB = findViewById(R.id.spnTenPB);
        Button btnThemNV = findViewById(R.id.btnThemNV);
        Button btnTroVe = findViewById(R.id.btnTroVe);

        //set adapter cho spinner
        ArrayList<PhongBan> listPB = new PhongBanActivity().getDSPB();
        SpinnerPBAdapter adapter = new SpinnerPBAdapter(ThemNVActivity.this, listPB);
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


        //thêm nhân viên
        btnThemNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mavn = edtMaNV.getText().toString();
                String tennv = edtTenNV.getText().toString();

                NhanVien nhanVienMoi = new NhanVien(mavn, tennv, tenpb);

                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("nhanVienMoi", nhanVienMoi);
                intent.putExtras(bundle);
                setResult(1, intent);
                finish();
            }
        });
    }
}