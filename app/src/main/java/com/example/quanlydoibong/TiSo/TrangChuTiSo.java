package com.example.quanlydoibong.TiSo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.quanlydoibong.Adapter.DoiBongAdapter;
import com.example.quanlydoibong.Adapter.TiSoAdapter;
import com.example.quanlydoibong.Database.Database;
import com.example.quanlydoibong.DoiBong.ChiTietDoiBong;
import com.example.quanlydoibong.DoiBong.DoiBong;
import com.example.quanlydoibong.DoiBong.ThemDoiBong;
import com.example.quanlydoibong.DoiBong.TrangChuDoiBong;
import com.example.quanlydoibong.R;

import java.util.ArrayList;
import java.util.List;

public class TrangChuTiSo extends AppCompatActivity {
    Button btnDoc,btnThem,btnThoat;
    static ListView lvDanhSachTiSo;
    static List<TiSo> data_db = new ArrayList<>();
    static TiSoAdapter adapter_db;
    static Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu_ti_so);
        setControl();
        setEvent();
    }
    private void setEvent() {
        db = new Database(this);
        adapter_db = new TiSoAdapter(this,R.layout.item_ti_so,data_db);
        lvDanhSachTiSo.setAdapter(adapter_db);

        lvDanhSachTiSo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                Intent intent =new Intent(TrangChuTiSo.this, ChiTietTiSo.class);
                intent.putExtra("item", data_db.get(i));
                startActivity(intent);
            }
        });
        btnDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data_db.clear();
                data_db.addAll(db.DocTiSo());
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
                Intent intent =new Intent(TrangChuTiSo.this, ThemTiSo.class);
                startActivity(intent);
            }
        });
    }
    private void setControl() {
        btnDoc=findViewById(R.id.btnDocDLTiSo_TS);
        btnThem=findViewById(R.id.btnThemTiSo_TS);
        btnThoat=findViewById(R.id.btnThoat_TS);
        lvDanhSachTiSo = findViewById(R.id.lvDanhSachTiSo_TS);
    }
}