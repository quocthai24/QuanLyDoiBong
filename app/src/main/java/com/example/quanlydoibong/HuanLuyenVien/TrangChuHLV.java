package com.example.quanlydoibong.HuanLuyenVien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.quanlydoibong.Adapter.DoiBongAdapter;
import com.example.quanlydoibong.Adapter.HLVAdapter;
import com.example.quanlydoibong.Database.Database;
import com.example.quanlydoibong.DoiBong.ChiTietDoiBong;
import com.example.quanlydoibong.DoiBong.DoiBong;
import com.example.quanlydoibong.DoiBong.ThemDoiBong;
import com.example.quanlydoibong.DoiBong.TrangChuDoiBong;
import com.example.quanlydoibong.R;

import java.util.ArrayList;
import java.util.List;

public class TrangChuHLV extends AppCompatActivity {
    Button btnDoc,btnThem,btnThoat;
    static ListView lvDanhSachHLV;
    public static List<HuanLuyenVien> data_hlv = new ArrayList<>();
    public static HLVAdapter adapter_hlv;
    public static Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu_hlv);
        setControl();
        setEvent();
    }
    private void setEvent() {
        db = new Database(this);
        adapter_hlv = new HLVAdapter(this,R.layout.item_hlv,data_hlv);
        lvDanhSachHLV.setAdapter(adapter_hlv);

        lvDanhSachHLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                Intent intent =new Intent(TrangChuHLV.this, ChiTietHLV.class);
                intent.putExtra("item", data_hlv.get(i));
                startActivity(intent);
            }
        });
        btnDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data_hlv.clear();
                data_hlv.addAll(db.DocHLV());
                adapter_hlv.notifyDataSetChanged();
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
                Intent intent =new Intent(TrangChuHLV.this, ThemHLV.class);
                startActivity(intent);
            }
        });
    }
    private void setControl() {
        btnDoc=findViewById(R.id.btnDocDLHLV);
        btnThem=findViewById(R.id.btnThemHLV);
        btnThoat=findViewById(R.id.btnThoat);
        lvDanhSachHLV = findViewById(R.id.lvDanhSachHLV);
    }
}