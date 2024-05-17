package com.example.quanlydoibong.DoiBong;

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

import com.example.quanlydoibong.HuanLuyenVien.ChiTietHLV;
import com.example.quanlydoibong.R;

import java.util.ArrayList;
import java.util.List;

public class ChiTietDoiBong extends AppCompatActivity {
    EditText edtMaDB,edtTenDB,edtMaHLV,edtSoThanhVien;
    Spinner spGiaiDau;
    Button btnBack, btnXoa, btnSua, btnDoc,btnXem;
    ImageView ivHinh;
    DoiBong doiBong;
    List<String> data_db = new ArrayList<>();
    ArrayAdapter adapter_db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_doi_bong);
        setControl();
        setEvent();
    }
    private void setEvent() {
        edtMaDB.setEnabled(false);
        Khoitao();
        doiBong = (DoiBong) getIntent().getSerializableExtra("item");
        adapter_db = new ArrayAdapter(this, android.R.layout.simple_list_item_1,data_db);

        spGiaiDau.setAdapter(adapter_db);
        edtMaDB.setText(doiBong.getMaDB());
        edtTenDB.setText(doiBong.getTenDB());
        edtMaHLV.setText(doiBong.getMaHLV());
        edtSoThanhVien.setText(doiBong.getSoThanhVien());


        if(doiBong.getGiaiDau().equals("EPL"))
            spGiaiDau.setSelection(0);
        if(doiBong.getGiaiDau().equals("LALIGA"))
            spGiaiDau.setSelection(1);
        if(doiBong.getGiaiDau().equals("LIGUE 1"))
            spGiaiDau.setSelection(1);
        spGiaiDau.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(spGiaiDau.getSelectedItem().toString().equals("EPL"))
                    ivHinh.setImageResource(R.drawable.ic_launcher_background);
                if(spGiaiDau.getSelectedItem().toString().equals("LALIGA"))
                    ivHinh.setImageResource(R.drawable.ic_launcher_background);
                if(spGiaiDau.getSelectedItem().toString().equals("LIGUE 1"))
                    ivHinh.setImageResource(R.drawable.ic_launcher_background);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DoiBong doiBong=new DoiBong();
                doiBong.setMaDB(edtMaDB.getText().toString());

                TrangChuDoiBong.db.XoaDoiBong(doiBong);
                Toast.makeText(ChiTietDoiBong.this, "Xoá thành công", Toast.LENGTH_SHORT).show();
            }
        });

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DoiBong doiBong=new DoiBong();
                doiBong.setMaDB(edtMaDB.getText().toString());
                doiBong.setTenDB(edtTenDB.getText().toString());
                doiBong.setMaHLV(edtMaHLV.getText().toString());
                doiBong.setSoThanhVien(edtSoThanhVien.getText().toString());
                doiBong.setGiaiDau(spGiaiDau.getSelectedItem().toString());

                TrangChuDoiBong.db.SuaDoiBong(doiBong);
                Toast.makeText(ChiTietDoiBong.this, "Sua Thanh Cong", Toast.LENGTH_SHORT).show();
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
                Intent intent = new Intent(ChiTietDoiBong.this,XemHLV.class);
                intent.putExtra("hlv",edtMaHLV.getText().toString());
                startActivity(intent);
            }
        });
        btnXem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChiTietDoiBong.this,DanhSachCauThu.class);
                intent.putExtra("doiBong",edtMaDB.getText().toString());
                startActivity(intent);
            }
        });
    }

    private void Khoitao() {
        data_db.add("EPL");
        data_db.add("LALIGA");
        data_db.add("LIGUE 1");
    }

    private void setControl() {
        edtMaDB= findViewById(R.id.edtmaDB_chitiet);
        edtTenDB = findViewById(R.id.edtTenDB_chitiet);
        edtMaHLV = findViewById(R.id.edtmaHLV_chitiet);
        edtSoThanhVien = findViewById(R.id.edtSoThanhVien_chitiet);

        spGiaiDau=findViewById(R.id.spGiaiDau_chitiet);
        btnXem=findViewById(R.id.btnXemCauThu);
        btnDoc=findViewById(R.id.btnXemHLV_DB);
        btnBack = findViewById(R.id.btnCTBack_DB);
        btnXoa = findViewById(R.id.btnCTXoa_DB);
        btnSua = findViewById(R.id.btnCTSua_DB);
        ivHinh = findViewById(R.id.ivCTHinh);
    }
}