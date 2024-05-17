package com.example.quanlydoibong.CauThu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.quanlydoibong.HuanLuyenVien.HuanLuyenVien;
import com.example.quanlydoibong.HuanLuyenVien.ThemHLV;
import com.example.quanlydoibong.HuanLuyenVien.TrangChuHLV;
import com.example.quanlydoibong.R;

import java.util.ArrayList;
import java.util.List;

public class ThemCauThu extends AppCompatActivity {
    EditText edtmaCT, edtTenCT,edtNgaySinh,edtDB,edtViTri,edtLuong;
    Spinner spDoiHinh;
    Button btnThem,btnLamMoi,btnQuayLai;
    List<String> data_db = new ArrayList<>();
    ArrayAdapter adapter_db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_cau_thu);
        setColntrol();
        setEvent();
    }
    private void setEvent() {
        Khoitao();
        adapter_db = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,data_db);
        spDoiHinh.setAdapter(adapter_db);
        TrangChuCauThu.lvDanhSachCT.setAdapter(TrangChuCauThu.adapter_ct);


        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CauThu cauThu = new CauThu("","","","","","","");
                cauThu.setMaCT(edtmaCT.getText().toString());
                cauThu.setTenCT(edtTenCT.getText().toString());
                cauThu.setNgaySinh(edtNgaySinh.getText().toString());
                cauThu.setMaDB(edtDB.getText().toString());
                cauThu.setViTri(edtViTri.getText().toString());
                cauThu.setLuong(edtLuong.getText().toString());

                cauThu.setDoiHinh(spDoiHinh.getSelectedItem().toString());
                TrangChuCauThu.db.ThemCauThu(cauThu);

                Toast.makeText(ThemCauThu.this, "Them Thanh Cong", Toast.LENGTH_SHORT).show();

            }
        });
        btnLamMoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtmaCT.setText("");
                edtTenCT.setText("");
                edtNgaySinh.setText("");
                edtDB.setText("");
                edtViTri.setText("");
                edtLuong.setText("");
                spDoiHinh.setSelection(0);
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
        data_db.add("Chinh");
        data_db.add("Du Bi");
    }

    private void setColntrol() {
        edtmaCT = findViewById(R.id.edtmaCT_them);
        edtTenCT = findViewById(R.id.edttenCT_them);
        edtNgaySinh = findViewById(R.id.edtNgaySinh_themCT);
        edtDB = findViewById(R.id.edtDoiBong_themCT);
        edtViTri=findViewById(R.id.edtViTri_them);
        edtLuong=findViewById(R.id.edtLuong_them);

        spDoiHinh = findViewById(R.id.spDoiHinh_them);
        btnThem = findViewById(R.id.btnThem_CT);
        btnLamMoi = findViewById(R.id.btnLamMoi_CT);
        btnQuayLai = findViewById(R.id.btnQuayLai_CT);
    }
}