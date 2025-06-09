package com.example.android1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.android1.adapter.NhanVienAdapter;
import com.example.android1.model.NhanVien;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class NhanVienActivity extends AppCompatActivity {

    private ListView lvNhanVien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nhan_vien);
        //ánh xạ
        lvNhanVien = findViewById(R.id.lvNhanVien);
        //  Button btnThemNV = findViewById(R.id.btnThemNV);
        Toolbar toolBar = findViewById(R.id.toolBar);
        FloatingActionButton floatAdd = findViewById(R.id.floatAdd);

        //set up toolbar
        setSupportActionBar(toolBar);
        getSupportActionBar().setTitle("Quản Lý Nhân Viên");

        //data

        //adapter
        loadData();

        //      btnThemNV.setOnClickListener(new View.OnClickListener() {
        //         @Override
        //        public void onClick(View v) {
        //            Intent intent = new Intent(NhanVienActivity.this, ThemNVActivity.class);
        //              myLauncher.launch(intent);
        //         }
        //     });
        floatAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NhanVienActivity.this, ThemNVActivity.class);
                myLauncher.launch(intent);
            }
        });

    }

    private void loadData(){
        NhanVienAdapter adapter = new NhanVienAdapter(NhanVienActivity.this, WelcomeActivity.listNV, myLauncher);
        lvNhanVien.setAdapter(adapter);
    }
    private ActivityResultLauncher<Intent> myLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
                        @Override
                        public void onActivityResult(ActivityResult result) {
                            //xử lý dữ liệu trả về
                            //thêm trả về
                            if (result.getResultCode() ==1){
                                Intent intent = result.getData();
                                Bundle bundle = intent.getExtras();
                                NhanVien nhanVienMoi = (NhanVien) bundle.getSerializable("nhanVienMoi");
                                WelcomeActivity.listNV.add(nhanVienMoi);
                                loadData();
                            }
                            //sửa trả về
                            if (result.getResultCode() ==2){
                                Intent intent = result.getData();
                                Bundle bundle = intent.getExtras();
                                NhanVien nhanVienSua = (NhanVien) bundle.getSerializable("nhanVienSua");
                                int viTriSua = bundle.getInt("viTriSua");
                                WelcomeActivity.listNV.set(viTriSua, nhanVienSua);
                                loadData();
                            }
                        }
                    });

    //    @Override
    //   public boolean onCreateOptionsMenu(Menu menu) {
    //      MenuInflater inflater = getMenuInflater();
    //      inflater.inflate(R.menu.menu, menu);
    //      return super.onCreateOptionsMenu(menu);
    // }
    //  @Override
    //   public boolean onOptionsItemSelected(@NonNull MenuItem item) {
    //      if (item.getItemId() == R.id.mThem){
    //           Intent intent = new Intent(NhanVienActivity.this, ThemNVActivity.class);
    //          myLauncher.launch(intent);
    //      }
    //      return super.onOptionsItemSelected(item);
    //  }
}