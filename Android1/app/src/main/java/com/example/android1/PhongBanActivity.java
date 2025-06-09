package com.example.android1;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.android1.adapter.PhongBanAdapter;
import com.example.android1.model.PhongBan;

import java.util.ArrayList;

public class PhongBanActivity extends AppCompatActivity {
    private ListView lvPhongBan;
    private ArrayList<PhongBan> listPB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_phong_ban);

        //giao diện
        lvPhongBan = findViewById(R.id.lvPhongBan);
        SearchView svPhongBan = findViewById(R.id.svPhongBan);


        //adapter
        loadData(getDSPB());

        //xử lý searchview
        svPhongBan.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                ArrayList<PhongBan> listFilter = new ArrayList<>();

                for (PhongBan phongBan : getDSPB()){
                    if (phongBan.getTenpb().toLowerCase().contains(newText.toLowerCase())
                            || phongBan.getMapb().toLowerCase().contains(newText.toLowerCase())){
                        listFilter.add(phongBan);
                    }
                }
                loadData(listFilter);
                return false;
            }
        });
    }
    private void loadData(ArrayList<PhongBan> list){
        PhongBanAdapter adapter = new PhongBanAdapter(PhongBanActivity.this, list);
        lvPhongBan.setAdapter(adapter);
    }
    public ArrayList<PhongBan> getDSPB(){
        listPB = new ArrayList<>();
        listPB.add(new PhongBan("PB01", "Nhân Sự"));
        listPB.add(new PhongBan("PB02", "Đào Tạo"));
        listPB.add(new PhongBan("PB03", "Hành Chính"));
        listPB.add(new PhongBan("PB04", "Tổng Hợp"));

        return listPB;
    }
}