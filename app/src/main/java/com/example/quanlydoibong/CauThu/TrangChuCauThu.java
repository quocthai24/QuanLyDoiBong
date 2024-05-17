package com.example.quanlydoibong.CauThu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.quanlydoibong.Adapter.CauThuAdapter;
import com.example.quanlydoibong.Adapter.HLVAdapter;
import com.example.quanlydoibong.Database.Database;
import com.example.quanlydoibong.HuanLuyenVien.ChiTietHLV;
import com.example.quanlydoibong.HuanLuyenVien.HuanLuyenVien;
import com.example.quanlydoibong.HuanLuyenVien.ThemHLV;
import com.example.quanlydoibong.HuanLuyenVien.TrangChuHLV;
import com.example.quanlydoibong.R;

import java.util.ArrayList;
import java.util.List;

public class TrangChuCauThu extends AppCompatActivity {
    Button btnDoc,btnThem,btnThoat;
    static ListView lvDanhSachCT;
    public static List<CauThu> data_ct = new ArrayList<>();
    public static CauThuAdapter adapter_ct;
    public static Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu_cau_thu);
        setControl();
        setEvent();
    }
    private void setEvent() {
        db = new Database(this);
        adapter_ct = new CauThuAdapter(this,R.layout.item_cau_thu,data_ct);
        lvDanhSachCT.setAdapter(adapter_ct);

        lvDanhSachCT.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                Intent intent =new Intent(TrangChuCauThu.this, ChiTietCauThu.class);
                intent.putExtra("item", data_ct.get(i));
                startActivity(intent);
            }
        });
        btnDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data_ct.clear();
                data_ct.addAll(db.DocCauThu());
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
                Intent intent =new Intent(TrangChuCauThu.this, ThemCauThu.class);
                startActivity(intent);
            }
        });
    }
    private void setControl() {
        btnDoc=findViewById(R.id.btnDocDLCauThu);
        btnThem=findViewById(R.id.btnThemCauThu);
        btnThoat=findViewById(R.id.btnThoat_CT);
        lvDanhSachCT = findViewById(R.id.lvDanhSachCauThu);
    }
}