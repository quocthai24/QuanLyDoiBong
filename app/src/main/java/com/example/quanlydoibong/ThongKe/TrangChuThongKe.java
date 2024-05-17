package com.example.quanlydoibong.ThongKe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.quanlydoibong.Adapter.ThongKeAdapter;
import com.example.quanlydoibong.Adapter.TiSoAdapter;
import com.example.quanlydoibong.Database.Database;
import com.example.quanlydoibong.R;
import com.example.quanlydoibong.TiSo.ChiTietTiSo;
import com.example.quanlydoibong.TiSo.ThemTiSo;
import com.example.quanlydoibong.TiSo.TiSo;
import com.example.quanlydoibong.TiSo.TrangChuTiSo;

import java.util.ArrayList;
import java.util.List;

public class TrangChuThongKe extends AppCompatActivity {
    Button btnDoc,btnThoat;
    static ListView lvDanhSachThongKe;
    static List<ThongKe> data_db = new ArrayList<>();
    static ThongKeAdapter adapter_db;
    static Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu_thong_ke);
        setControl();
        setEvent();
    }
    private void setEvent() {
        db = new Database(this);
        adapter_db = new ThongKeAdapter(this,R.layout.item_thong_ke,data_db);
        lvDanhSachThongKe.setAdapter(adapter_db);

        btnDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data_db.clear();
                data_db.addAll(db.DocThongKe());
                adapter_db.notifyDataSetChanged();
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void setControl() {
        btnDoc=findViewById(R.id.btnDocThongKe);
        btnThoat=findViewById(R.id.btnThoat_TK);
        lvDanhSachThongKe = findViewById(R.id.lvDanhSachThongKe);
    }
}