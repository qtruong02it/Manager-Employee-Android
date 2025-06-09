package com.example.android1;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.android1.model.NhanVien;

import java.util.ArrayList;

public class WelcomeActivity extends AppCompatActivity {

    public static ArrayList<NhanVien> listNV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_welcome);

        //data
        listNV = new ArrayList<>();
        listNV.add(new NhanVien("NV01", "Nguyễn Văn A", "Nhân Sự"));
        listNV.add(new NhanVien("NV02", "Nguyễn Văn B", "Hành Chính"));
        listNV.add(new NhanVien("NV03", "Nguyễn Văn C", "Đào Tạo"));
        listNV.add(new NhanVien("NV04", "Nguyễn Văn D", "Tổng Hợp"));

        new CountDownTimer(3000, 1000){

            @Override
            public void onTick(long millisUntilFinished) {
                //trong vong bao nhieu giay thuc hien 1 cong viec nao do
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(WelcomeActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        }.start();
    }
}