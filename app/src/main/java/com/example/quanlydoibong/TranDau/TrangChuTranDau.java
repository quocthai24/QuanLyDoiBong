package com.example.quanlydoibong.TranDau;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.quanlydoibong.Adapter.CauThuAdapter;
import com.example.quanlydoibong.Adapter.TranDauAdapter;
import com.example.quanlydoibong.CauThu.CauThu;
import com.example.quanlydoibong.CauThu.ChiTietCauThu;
import com.example.quanlydoibong.CauThu.ThemCauThu;
import com.example.quanlydoibong.CauThu.TrangChuCauThu;
import com.example.quanlydoibong.Database.Database;
import com.example.quanlydoibong.R;

import java.util.ArrayList;
import java.util.List;

public class TrangChuTranDau extends AppCompatActivity {
    Button btnDoc,btnThem,btnThoat;
    static ListView lvDanhSachTD;
    public static List<TranDau> data_td = new ArrayList<>();
    public static TranDauAdapter adapter_td;
    public static Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu_tran_dau);
        setControl();
        setEvent();
    }
    private void setEvent() {
        db = new Database(this);
        adapter_td = new TranDauAdapter(this,R.layout.item_tran_dau,data_td);
        lvDanhSachTD.setAdapter(adapter_td);

        lvDanhSachTD.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                Intent intent =new Intent(TrangChuTranDau.this, ChiTietTranDau.class);
                intent.putExtra("item", data_td.get(i));
                startActivity(intent);
            }
        });
        btnDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data_td.clear();
                data_td.addAll(db.DocTranDau());
                adapter_td.notifyDataSetChanged();
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
                Intent intent =new Intent(TrangChuTranDau.this, ThemTranDau.class);
                startActivity(intent);
            }
        });
    }
    private void setControl() {
        btnDoc=findViewById(R.id.btnDocDLTranDau);
        btnThem=findViewById(R.id.btnThemTranDau);
        btnThoat=findViewById(R.id.btnThoat_TD);
        lvDanhSachTD = findViewById(R.id.lvDanhSachTranDau);
    }
}