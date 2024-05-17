package com.example.quanlydoibong.HuanLuyenVien;

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

import com.example.quanlydoibong.Adapter.DoiBongAdapter;
import com.example.quanlydoibong.DoiBong.DoiBong;
import com.example.quanlydoibong.DoiBong.ThemDoiBong;
import com.example.quanlydoibong.DoiBong.TrangChuDoiBong;
import com.example.quanlydoibong.R;

import java.util.ArrayList;
import java.util.List;

public class ThemHLV extends AppCompatActivity {
    EditText edtmaHLV, edtTenHLV,edtNgaySinh,edtQuocGia,edtTuoi;
    Spinner spDoiBong;
    Button btnThem,btnLamMoi,btnQuayLai;
    List<String> data_db = new ArrayList<>();
    ArrayAdapter adapter_db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_hlv);
        setColntrol();
        setEvent();
    }
    private void setEvent() {
        Khoitao();
        adapter_db = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,data_db);
        spDoiBong.setAdapter(adapter_db);
        TrangChuHLV.lvDanhSachHLV.setAdapter(TrangChuHLV.adapter_hlv);


        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HuanLuyenVien hlv = new HuanLuyenVien("","","","","","");
                hlv.setMaHLV(edtmaHLV.getText().toString());
                hlv.setTenHLV(edtTenHLV.getText().toString());
                hlv.setNgaySinh(edtNgaySinh.getText().toString());
                hlv.setQuocGia(edtQuocGia.getText().toString());
                hlv.setTuoi(edtTuoi.getText().toString());

                hlv.setDoiBong(spDoiBong.getSelectedItem().toString());
                TrangChuHLV.db.ThemHLV(hlv);

                Toast.makeText(ThemHLV.this, "Them Thanh Cong", Toast.LENGTH_SHORT).show();

            }
        });
        btnLamMoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtmaHLV.setText("");
                edtTenHLV.setText("");
                edtNgaySinh.setText("");
                edtQuocGia.setText("");
                edtTuoi.setText("");
                spDoiBong.setSelection(0);
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
        data_db = TrangChuHLV.db.LayDoiBong();
    }

    private void setColntrol() {
        edtmaHLV = findViewById(R.id.edtmaHLV_them);
        edtTenHLV = findViewById(R.id.edttenHLV_them);
        edtNgaySinh = findViewById(R.id.edtNgaySinh_them);
        edtQuocGia = findViewById(R.id.edtQuocGia_them);
        edtTuoi=findViewById(R.id.edtTuoi_them);

        spDoiBong = findViewById(R.id.spDoiBong_them);
        btnThem = findViewById(R.id.btnThem_HLV);
        btnLamMoi = findViewById(R.id.btnLamMoi_HLV);
        btnQuayLai = findViewById(R.id.btnQuayLai_HLV);
    }
}