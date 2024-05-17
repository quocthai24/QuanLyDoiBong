package com.example.quanlydoibong.CauThu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.quanlydoibong.HuanLuyenVien.ChiTietHLV;
import com.example.quanlydoibong.HuanLuyenVien.HuanLuyenVien;
import com.example.quanlydoibong.HuanLuyenVien.TrangChuHLV;
import com.example.quanlydoibong.HuanLuyenVien.XemDoiBong;
import com.example.quanlydoibong.R;

import java.util.ArrayList;
import java.util.List;

public class ChiTietCauThu extends AppCompatActivity {
    EditText edtMaCT,edtTenCT,edtNgaySinh,edtmaDB,edtViTri,edtLuong;
    Spinner spDoiHinh;
    Button btnBack, btnXoa, btnSua, btnDoc;
    CauThu cauThu;
    List<String> data_ct = new ArrayList<>();
    ArrayAdapter adapter_ct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_cau_thu);
        setControl();
        setEvent();
    }
    private void setEvent() {
        edtMaCT.setEnabled(false);
        Khoitao();
        cauThu = (CauThu) getIntent().getSerializableExtra("item");
        adapter_ct = new ArrayAdapter(this, android.R.layout.simple_list_item_1,data_ct);

        spDoiHinh.setAdapter(adapter_ct);
        edtMaCT.setText(cauThu.getMaCT());
        edtTenCT.setText(cauThu.getTenCT());
        edtNgaySinh.setText(cauThu.getNgaySinh());
        edtmaDB.setText(cauThu.getMaDB());
        edtViTri.setText(cauThu.getViTri());
        edtLuong.setText(cauThu.getLuong());

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CauThu cauThu=new CauThu();
                cauThu.setMaCT(edtMaCT.getText().toString());

                TrangChuCauThu.db.XoaCauThu(cauThu);
                Toast.makeText(ChiTietCauThu.this, "Xoá thành công", Toast.LENGTH_SHORT).show();
            }
        });

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CauThu cauThu=new CauThu();
                cauThu.setMaCT(edtMaCT.getText().toString());
                cauThu.setTenCT(edtTenCT.getText().toString());
                cauThu.setNgaySinh(edtNgaySinh.getText().toString());
                cauThu.setMaDB(edtmaDB.getText().toString());
                cauThu.setViTri(edtViTri.getText().toString());
                cauThu.setLuong(edtLuong.getText().toString());

                cauThu.setDoiHinh(spDoiHinh.getSelectedItem().toString());

                TrangChuCauThu.db.SuaCauThu(cauThu);
                Toast.makeText(ChiTietCauThu.this, "Sua Thanh Cong", Toast.LENGTH_SHORT).show();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    private void Khoitao() {
        data_ct.add("Chinh");
        data_ct.add("Du Bi");
    }

    private void setControl() {
        edtMaCT= findViewById(R.id.edtmaCT_chitiet);
        edtTenCT = findViewById(R.id.edtTenCT_chitiet);
        edtNgaySinh = findViewById(R.id.edtNgaySinh_chitietCT);
        edtmaDB = findViewById(R.id.edtDoiBong_chitietCT);
        edtViTri=findViewById(R.id.edtViTri_chitiet);
        edtLuong=findViewById(R.id.edtLuong_chitiet);

        spDoiHinh=findViewById(R.id.spDoiHinh_chitiet);

        btnBack = findViewById(R.id.btnCTBack_CT);
        btnXoa = findViewById(R.id.btnCTXoa_CT);
        btnSua = findViewById(R.id.btnCTSua_CT);
    }
}