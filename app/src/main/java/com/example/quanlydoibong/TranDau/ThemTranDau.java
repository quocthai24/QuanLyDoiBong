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
import com.example.quanlydoibong.CauThu.ThemCauThu;
import com.example.quanlydoibong.CauThu.TrangChuCauThu;
import com.example.quanlydoibong.R;
import com.example.quanlydoibong.ThongKe.ThongKe;

import java.util.ArrayList;
import java.util.List;

public class ThemTranDau extends AppCompatActivity {
    EditText edtmaTD, edtNgayThiDau,edtDoiA,edtDoiB,edtTrongTai;
    Button btnThem,btnLamMoi,btnQuayLai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_tran_dau);
        setColntrol();
        setEvent();
    }
    private void setEvent() {

        TrangChuTranDau.lvDanhSachTD.setAdapter(TrangChuTranDau.adapter_td);


        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TranDau tranDau = new TranDau("","","","","");
                tranDau.setMaTD(edtmaTD.getText().toString());
                tranDau.setNgayThiDau(edtNgayThiDau.getText().toString());
                tranDau.setDoiA(edtDoiA.getText().toString());
                tranDau.setDoiB(edtDoiB.getText().toString());
                tranDau.setTrongTai(edtTrongTai.getText().toString());

                ThongKe tk = new ThongKe(edtmaTD.getText().toString(),null,edtNgayThiDau.getText().toString(),edtDoiA.getText().toString(),edtDoiB.getText().toString(),edtTrongTai.getText().toString(),null,null,null,null);

                TrangChuTranDau.db.ThemTranDau(tranDau);
                TrangChuTranDau.db.ThemThongKe(tk);
                Toast.makeText(ThemTranDau.this, "Them Thanh Cong", Toast.LENGTH_SHORT).show();

            }
        });
        btnLamMoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtmaTD.setText("");
                edtNgayThiDau.setText("");
                edtDoiA.setText("");
                edtDoiB.setText("");
                edtTrongTai.setText("");
            }
        });
        btnQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void setColntrol() {
        edtmaTD = findViewById(R.id.edtmaTD_them);
        edtNgayThiDau = findViewById(R.id.edtNgayThiDau_them);
        edtDoiA = findViewById(R.id.edtmaDoiA_them);
        edtDoiB = findViewById(R.id.edtMaDoiB_them);
        edtTrongTai=findViewById(R.id.edtTrongTai_them);

        btnThem = findViewById(R.id.btnThem_TD);
        btnLamMoi = findViewById(R.id.btnLamMoi_TD);
        btnQuayLai = findViewById(R.id.btnQuayLai_TD);
    }
}