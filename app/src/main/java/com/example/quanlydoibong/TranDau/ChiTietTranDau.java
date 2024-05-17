package com.example.quanlydoibong.TranDau;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.quanlydoibong.CauThu.CauThu;
import com.example.quanlydoibong.CauThu.ChiTietCauThu;
import com.example.quanlydoibong.CauThu.TrangChuCauThu;
import com.example.quanlydoibong.R;
import com.example.quanlydoibong.ThongKe.ThongKe;
import com.example.quanlydoibong.TiSo.TiSo;

import java.util.ArrayList;
import java.util.List;

public class ChiTietTranDau extends AppCompatActivity {
    EditText edtMaTD,edtNgayThiDau,edtDoiA,edtDoiB,edtTrongTai;
    Button btnBack, btnXoa, btnSua, btnDoc;
    TranDau tranDau;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_tran_dau);
        setControl();
        setEvent();
    }
    private void setEvent() {
        edtMaTD.setEnabled(false);

        tranDau = (TranDau) getIntent().getSerializableExtra("item");

        edtMaTD.setText(tranDau.getMaTD());
        edtNgayThiDau.setText(tranDau.getNgayThiDau());
        edtDoiA.setText(tranDau.getDoiA());
        edtDoiB.setText(tranDau.getDoiB());
        edtTrongTai.setText(tranDau.getTrongTai());

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TranDau tranDau=new TranDau();
                tranDau.setMaTD(edtMaTD.getText().toString());
                ThongKe tk = new ThongKe();
                tk.setMaTD(edtMaTD.getText().toString());
                TiSo tiSo = new TiSo();
                tiSo.setMaTD(edtMaTD.getText().toString());
                TrangChuTranDau.db.XoaTranDau(tranDau);
                TrangChuTranDau.db.XoaThongKe(tk);
                TrangChuTranDau.db.XoaTiSoTranDau(tiSo);
                Toast.makeText(ChiTietTranDau.this, "Xoá thành công", Toast.LENGTH_SHORT).show();
            }
        });

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TranDau tranDau=new TranDau();
                tranDau.setMaTD(edtMaTD.getText().toString());
                tranDau.setNgayThiDau(edtNgayThiDau.getText().toString());
                tranDau.setDoiA(edtDoiA.getText().toString());
                tranDau.setDoiB(edtDoiB.getText().toString());
                tranDau.setTrongTai(edtTrongTai.getText().toString());

                TrangChuTranDau.db.SuaTranDau(tranDau);
                Toast.makeText(ChiTietTranDau.this, "Sua Thanh Cong", Toast.LENGTH_SHORT).show();
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
        edtMaTD= findViewById(R.id.edtmaTD_chitiet);
        edtNgayThiDau = findViewById(R.id.edtNgayThiDau_chitiet);
        edtDoiA = findViewById(R.id.edtDoiA_chitiet);
        edtDoiB = findViewById(R.id.edtDoiB_chitiet);
        edtTrongTai=findViewById(R.id.edtTrongTai_chitiet);

        btnBack = findViewById(R.id.btnCTBack_TD);
        btnXoa = findViewById(R.id.btnCTXoa_TD);
        btnSua = findViewById(R.id.btnCTSua_TD);
    }
}