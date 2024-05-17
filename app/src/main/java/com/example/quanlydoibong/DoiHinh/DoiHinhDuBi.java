package com.example.quanlydoibong.DoiHinh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.quanlydoibong.Adapter.CauThuAdapter;
import com.example.quanlydoibong.CauThu.CauThu;
import com.example.quanlydoibong.CauThu.ChiTietCauThu;
import com.example.quanlydoibong.CauThu.TrangChuCauThu;
import com.example.quanlydoibong.Database.Database;
import com.example.quanlydoibong.R;

import java.util.ArrayList;
import java.util.List;

public class DoiHinhDuBi extends AppCompatActivity {
    Button btnDoc,btnThem,btnThoat;
    static ListView lvDanhSachCT;
    public static List<CauThu> data_ct = new ArrayList<>();
    public static CauThuAdapter adapter_ct;
    public static Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doi_hinh_du_bi);
        setControl();
        setEvent();
    }
    private void setEvent() {
        db = new Database(this);
        adapter_ct = new CauThuAdapter(this,R.layout.item_cau_thu,data_ct);
        lvDanhSachCT.setAdapter(adapter_ct);

        btnDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data_ct.clear();
                data_ct.addAll(db.DocCauThuDuBi());
                adapter_ct.notifyDataSetChanged();
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
                Intent intent =new Intent(DoiHinhDuBi.this, TrangChuCauThu.class);
                startActivity(intent);
            }
        });
    }
    private void setControl() {
        btnDoc=findViewById(R.id.btnDocDLCauThuDuBi);
        btnThem=findViewById(R.id.btnThemCauThuDuBi);
        btnThoat=findViewById(R.id.btnThoat_CTDB);
        lvDanhSachCT = findViewById(R.id.lvDanhSachCauThuDuBi);
    }
}