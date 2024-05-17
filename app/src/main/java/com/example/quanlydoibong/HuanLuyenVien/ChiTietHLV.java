package com.example.quanlydoibong.HuanLuyenVien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.quanlydoibong.DoiBong.ChiTietDoiBong;
import com.example.quanlydoibong.DoiBong.DoiBong;
import com.example.quanlydoibong.DoiBong.TrangChuDoiBong;
import com.example.quanlydoibong.R;

import java.util.ArrayList;
import java.util.List;

public class ChiTietHLV extends AppCompatActivity {
    EditText edtMaHLV,edtTenHLV,edtNgaySinh,edtQuocGia,edtTuoi;
    Spinner spDoiBong;
    Button btnBack, btnXoa, btnSua, btnDoc;
    HuanLuyenVien hlv;
    List<String> data_db = new ArrayList<>();
    ArrayAdapter adapter_db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_hlv);
        setControl();
        setEvent();
    }
    private void setEvent() {
        edtMaHLV.setEnabled(false);
        Khoitao();
        hlv = (HuanLuyenVien) getIntent().getSerializableExtra("item");
        adapter_db = new ArrayAdapter(this, android.R.layout.simple_list_item_1,data_db);

        spDoiBong.setAdapter(adapter_db);
        edtMaHLV.setText(hlv.getMaHLV());
        edtTenHLV.setText(hlv.getTenHLV());
        edtNgaySinh.setText(hlv.getNgaySinh());
        edtQuocGia.setText(hlv.getQuocGia());
        edtTuoi.setText(hlv.getTuoi());

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HuanLuyenVien huanLuyenVien=new HuanLuyenVien();
                huanLuyenVien.setMaHLV(edtMaHLV.getText().toString());

                TrangChuHLV.db.XoaHLV(huanLuyenVien);
                Toast.makeText(ChiTietHLV.this, "Xoá thành công", Toast.LENGTH_SHORT).show();
            }
        });

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HuanLuyenVien hlv=new HuanLuyenVien();
                hlv.setMaHLV(edtMaHLV.getText().toString());
                hlv.setTenHLV(edtTenHLV.getText().toString());
                hlv.setNgaySinh(edtNgaySinh.getText().toString());
                hlv.setQuocGia(edtQuocGia.getText().toString());
                hlv.setTuoi(edtTuoi.getText().toString());
                hlv.setDoiBong(spDoiBong.getSelectedItem().toString());

                TrangChuHLV.db.SuaHLV(hlv);
                Toast.makeText(ChiTietHLV.this, "Sua Thanh Cong", Toast.LENGTH_SHORT).show();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        btnDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChiTietHLV.this,XemDoiBong.class);
                intent.putExtra("hlv",edtMaHLV.getText().toString());
                startActivity(intent);
            }
        });
    }

    private void Khoitao() {
        data_db = TrangChuHLV.db.LayDoiBong();
    }

    private void setControl() {
        edtMaHLV= findViewById(R.id.edtmaHLV_chitiet);
        edtTenHLV = findViewById(R.id.edtTenHLV_chitiet);
        edtNgaySinh = findViewById(R.id.edtNgaySinh_chitiet);
        edtQuocGia = findViewById(R.id.edtQuocGia_chitiet);
        edtTuoi=findViewById(R.id.edtTuoi_chitiet);

        spDoiBong=findViewById(R.id.spDoiBong_chitiet);
        btnDoc=findViewById(R.id.btnXemDB_HLV);
        btnBack = findViewById(R.id.btnCTBack_HLV);
        btnXoa = findViewById(R.id.btnCTXoa_HLV);
        btnSua = findViewById(R.id.btnCTSua_HLV);
    }
}