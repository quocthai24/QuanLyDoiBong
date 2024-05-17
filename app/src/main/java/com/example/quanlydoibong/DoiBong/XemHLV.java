package com.example.quanlydoibong.DoiBong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.quanlydoibong.Adapter.HLVAdapter;
import com.example.quanlydoibong.Database.Database;
import com.example.quanlydoibong.HuanLuyenVien.HuanLuyenVien;
import com.example.quanlydoibong.HuanLuyenVien.ThemHLV;
import com.example.quanlydoibong.HuanLuyenVien.TrangChuHLV;
import com.example.quanlydoibong.R;

import java.util.ArrayList;
import java.util.List;

public class XemHLV extends AppCompatActivity {
    Button btnDoc,btnQuayLai,btnThem;
    ListView lvDanhSach;
    EditText edtMaHLV;
    List<HuanLuyenVien> data = new ArrayList<>();
    HLVAdapter adapter;
    Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem_hlv);
        setControl();
        setEvent();
    }
    private void setEvent(){
        db = new Database(this);
        edtMaHLV.setText(getIntent().getStringExtra("hlv"));
        adapter = new HLVAdapter(this,R.layout.item_hlv,data);
        lvDanhSach.setAdapter(adapter);
        HuanLuyenVien hlv = new HuanLuyenVien();
        hlv.setMaHLV(edtMaHLV.getText().toString());
        btnDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DoiBong doiBong = new DoiBong();
                doiBong.setMaHLV(edtMaHLV.getText().toString());
                data.clear();
                data.addAll(TrangChuDoiBong.db.DocHuanLuyenVien(hlv));
                adapter.notifyDataSetChanged();
            }
        });
        btnQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(XemHLV.this, TrangChuHLV.class);
                startActivity(intent);
            }
        });
    }
    private void setControl(){
        btnThem=findViewById(R.id.btnThemHLV_xem);
        btnDoc=findViewById(R.id.btnDocDLHLV_xem);
        btnQuayLai=findViewById(R.id.btnThoat_xem);
        lvDanhSach=findViewById(R.id.lvDanhSachHLV_xem);
        edtMaHLV=findViewById(R.id.edtmaHLV_xem);
    }
}