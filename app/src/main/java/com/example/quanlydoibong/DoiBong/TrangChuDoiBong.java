package com.example.quanlydoibong.DoiBong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.quanlydoibong.Adapter.DoiBongAdapter;
import com.example.quanlydoibong.Database.Database;
import com.example.quanlydoibong.R;

import java.util.ArrayList;
import java.util.List;

public class TrangChuDoiBong extends AppCompatActivity {
    Button btnDoc,btnThem,btnThoat;
    static ListView lvDanhSachDoiBong;
    static List<DoiBong> data_db = new ArrayList<>();
    static DoiBongAdapter adapter_db;
    static Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu_doi_bong);
        setControl();
        setEvent();
    }
    private void setEvent() {
        db = new Database(this);
        adapter_db = new DoiBongAdapter(this,R.layout.item_doi_bong,data_db);
        lvDanhSachDoiBong.setAdapter(adapter_db);

        lvDanhSachDoiBong.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                Intent intent =new Intent(TrangChuDoiBong.this, ChiTietDoiBong.class);
                intent.putExtra("item", data_db.get(i));
                startActivity(intent);
            }
        });
        btnDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data_db.clear();
                data_db.addAll(db.DocDoiBong());
                adapter_db.notifyDataSetChanged();
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(TrangChuDoiBong.this, ThemDoiBong.class);
                startActivity(intent);
            }
        });
    }
    private void setControl() {
        btnDoc=findViewById(R.id.btnDocDLDoiBong);
        btnThem=findViewById(R.id.btnThemDoiBong);
        btnThoat=findViewById(R.id.btnThoat);
        lvDanhSachDoiBong = findViewById(R.id.lvDanhSachDoiBong);
    }
}