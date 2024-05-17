package com.example.quanlydoibong.HuanLuyenVien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.quanlydoibong.Adapter.DoiBongAdapter;
import com.example.quanlydoibong.Adapter.HLVAdapter;
import com.example.quanlydoibong.Database.Database;
import com.example.quanlydoibong.DoiBong.DoiBong;
import com.example.quanlydoibong.DoiBong.TrangChuDoiBong;
import com.example.quanlydoibong.DoiBong.XemHLV;
import com.example.quanlydoibong.R;

import java.util.ArrayList;
import java.util.List;

public class XemDoiBong extends AppCompatActivity {
    Button btnDoc,btnQuayLai,btnThem;
    ListView lvDanhSach;
    EditText edtMaHLV;
    List<DoiBong> data = new ArrayList<>();
    DoiBongAdapter adapter;
    Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem_doi_bong);
        setControl();
        setEvent();
    }
    private void setEvent(){
        db = new Database(this);
        edtMaHLV.setText(getIntent().getStringExtra("hlv"));

        adapter = new DoiBongAdapter(this,R.layout.item_doi_bong,data);
        lvDanhSach.setAdapter(adapter);

        HuanLuyenVien hlv = new HuanLuyenVien();
        hlv.setMaHLV(edtMaHLV.getText().toString());
        btnDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DoiBong doiBong = new DoiBong();
                doiBong.setMaHLV(edtMaHLV.getText().toString());
                data.clear();
                data.addAll(db.XemDoiBong(hlv));
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
                Intent intent = new Intent(XemDoiBong.this, TrangChuDoiBong.class);
                startActivity(intent);
            }
        });
    }
    private void setControl(){
        btnThem=findViewById(R.id.btnThemHLVDB_xem);
        btnDoc=findViewById(R.id.btnDocDLDoiBong_xem);
        btnQuayLai=findViewById(R.id.btnThoatDB_xem);
        lvDanhSach=findViewById(R.id.lvDanhSachHLV_xemDB);
        edtMaHLV=findViewById(R.id.edtmaHLV_xem);
    }
}