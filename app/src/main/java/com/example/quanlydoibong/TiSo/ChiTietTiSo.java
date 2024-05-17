package com.example.quanlydoibong.TiSo;

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
import com.example.quanlydoibong.DoiBong.XemHLV;
import com.example.quanlydoibong.R;

import java.util.ArrayList;
import java.util.List;

public class ChiTietTiSo extends AppCompatActivity {
    EditText edtMaTS,edtSoTheVang,edtSoTheDo,edtHieuSo,edtKetQua,edtMaTD;
    Button btnBack, btnXoa, btnSua, btnDoc;
    TiSo tiSo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_ti_so);
        setControl();
        setEvent();
    }
    private void setEvent() {
        edtMaTS.setEnabled(false);

        tiSo = (TiSo) getIntent().getSerializableExtra("item");

        edtMaTS.setText(tiSo.getMaTS());
        edtSoTheVang.setText(tiSo.getSoTheVang());
        edtSoTheDo.setText(tiSo.getSoTheDo());
        edtHieuSo.setText(tiSo.getHieuSo());
        edtKetQua.setText(tiSo.getKetQua());
        edtMaTD.setText(tiSo.getMaTD());

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TiSo tiSo=new TiSo();
                tiSo.setMaTS(edtMaTS.getText().toString());

                TrangChuTiSo.db.XoaTiSo(tiSo);
                Toast.makeText(ChiTietTiSo.this, "Xoá thành công", Toast.LENGTH_SHORT).show();
            }
        });

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TiSo tiSo = new TiSo();
                tiSo.setMaTS(edtMaTS.getText().toString());
                tiSo.setSoTheVang(edtSoTheVang.getText().toString());
                tiSo.setSoTheDo(edtSoTheDo.getText().toString());
                tiSo.setHieuSo(edtHieuSo.getText().toString());
                tiSo.setKetQua(edtKetQua.getText().toString());
                tiSo.setMaTD(edtMaTD.getText().toString());

                TrangChuTiSo.db.SuaTiSo(tiSo);
                Toast.makeText(ChiTietTiSo.this, "Sua Thanh Cong", Toast.LENGTH_SHORT).show();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    private void setControl() {
        edtMaTS= findViewById(R.id.edtmaTS_chitiet);
        edtSoTheVang = findViewById(R.id.edtTheVang_chitiet);
        edtSoTheDo = findViewById(R.id.edtTheDo_chitiet);
        edtHieuSo = findViewById(R.id.edtHieuSo_chitiet);
        edtKetQua = findViewById(R.id.edtKetQua_chitiet);
        edtMaTD = findViewById(R.id.edtMaTD_chitiet_TS);

        btnBack = findViewById(R.id.btnCTBack_TD);
        btnXoa = findViewById(R.id.btnCTXoa_TD);
        btnSua = findViewById(R.id.btnCTSua_TD);
    }
}