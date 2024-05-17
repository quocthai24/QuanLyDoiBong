package com.example.quanlydoibong.DoiBong;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.quanlydoibong.R;

import java.util.ArrayList;
import java.util.List;

public class ThemDoiBong extends AppCompatActivity {
    EditText edtmaDB, edtTenDB,edtmaHLV,edtsoThanhVien;
    ImageView ivThemHinh;
    Spinner spGiaiDau;
    Button btnThem,btnLamMoi,btnQuayLai;
    List<String> data_db = new ArrayList<>();
    ArrayAdapter adapter_db;
    int[] srcIv = {R.drawable.ic_launcher_background , R.drawable.ic_launcher_background,R.drawable.ic_launcher_background};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_doi_bong);
        setColntrol();
        setEvent();
    }
    private void setEvent() {
        Khoitao();
        adapter_db = new ArrayAdapter<>(ThemDoiBong.this, android.R.layout.simple_list_item_1,data_db);
        spGiaiDau.setAdapter(adapter_db);
        TrangChuDoiBong.lvDanhSachDoiBong.setAdapter(TrangChuDoiBong.adapter_db);

        spGiaiDau.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ivThemHinh.setImageResource(srcIv[position]);

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });



        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DoiBong doiBong = new DoiBong("","","","","");
                doiBong.setMaDB(edtmaDB.getText().toString());
                doiBong.setTenDB(edtTenDB.getText().toString());
                doiBong.setMaHLV(edtmaHLV.getText().toString());
                doiBong.setSoThanhVien(edtsoThanhVien.getText().toString());

                doiBong.setGiaiDau(spGiaiDau.getSelectedItem().toString());
                TrangChuDoiBong.db.ThemDoiBong(doiBong);

                Toast.makeText(ThemDoiBong.this, "Them Thanh Cong", Toast.LENGTH_SHORT).show();

            }
        });
        btnLamMoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtmaDB.setText("");
                edtTenDB.setText("");
                edtmaHLV.setText("");
                edtsoThanhVien.setText("");
                spGiaiDau.setSelection(0);
            }
        });
        btnQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
    private void Khoitao() {
        data_db.add("EPL");
        data_db.add("LALIGA");
        data_db.add("LIGUE 1");
    }

    private void setColntrol() {
        edtmaDB = findViewById(R.id.edtmaDB_them);
        edtTenDB = findViewById(R.id.edttenDoiBong_them);
        edtmaHLV = findViewById(R.id.edtmaHLV_them);
        edtsoThanhVien = findViewById(R.id.edtSoThanhVien_them);
        ivThemHinh=findViewById(R.id.ivThemhinha);
        spGiaiDau = findViewById(R.id.spGiaiDau_them);
        btnThem = findViewById(R.id.btnThem_DB);
        btnLamMoi = findViewById(R.id.btnLamMoi_DB);
        btnQuayLai = findViewById(R.id.btnQuayLai_DB);
    }
}