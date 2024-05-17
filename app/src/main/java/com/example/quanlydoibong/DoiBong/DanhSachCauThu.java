package com.example.quanlydoibong.DoiBong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.quanlydoibong.Adapter.CauThuAdapter;
import com.example.quanlydoibong.Adapter.HLVAdapter;
import com.example.quanlydoibong.CauThu.CauThu;
import com.example.quanlydoibong.CauThu.TrangChuCauThu;
import com.example.quanlydoibong.Database.Database;
import com.example.quanlydoibong.HuanLuyenVien.HuanLuyenVien;
import com.example.quanlydoibong.HuanLuyenVien.TrangChuHLV;
import com.example.quanlydoibong.R;

import java.util.ArrayList;
import java.util.List;

public class DanhSachCauThu extends AppCompatActivity {
    Button btnDoc,btnQuayLai,btnThem;
    ListView lvDanhSach;
    EditText edtMaDB;
    List<CauThu> data = new ArrayList<>();
    CauThuAdapter adapter;
    Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_cau_thu);
        setControl();
        setEvent();
    }
    private void setEvent(){
        db = new Database(this);
        edtMaDB.setText(getIntent().getStringExtra("doiBong"));
        adapter = new CauThuAdapter(this,R.layout.item_cau_thu,data);
        lvDanhSach.setAdapter(adapter);
        CauThu cauThu = new CauThu();
        cauThu.setMaDB(edtMaDB.getText().toString());
        btnDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CauThu cauThu = new CauThu();
                cauThu.setMaDB(edtMaDB.getText().toString());
                data.clear();
                data.addAll(TrangChuDoiBong.db.DanhSachCauThu(cauThu));
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
                Intent intent = new Intent(DanhSachCauThu.this, TrangChuCauThu.class);
                startActivity(intent);
            }
        });
    }
    private void setControl(){
        btnThem=findViewById(R.id.btnThemCauThu);
        btnDoc=findViewById(R.id.btnDocDLCauThu);
        btnQuayLai=findViewById(R.id.btnThoat_CT);
        lvDanhSach=findViewById(R.id.lvDanhSachCauThu);
        edtMaDB=findViewById(R.id.edtDoiBong_xemDS);
    }
}