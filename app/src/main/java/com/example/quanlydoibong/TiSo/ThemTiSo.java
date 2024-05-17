package com.example.quanlydoibong.TiSo;

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

import com.example.quanlydoibong.DoiBong.DoiBong;
import com.example.quanlydoibong.DoiBong.ThemDoiBong;
import com.example.quanlydoibong.DoiBong.TrangChuDoiBong;
import com.example.quanlydoibong.R;
import com.example.quanlydoibong.ThongKe.ThongKe;
import com.example.quanlydoibong.TranDau.TrangChuTranDau;

import java.util.ArrayList;
import java.util.List;

public class ThemTiSo extends AppCompatActivity {
    EditText edtmaTS, edtSoTheVang,edtSoTheDo,edtHieuSo,edtKetQua,edtMaTD;
    Button btnThem,btnLamMoi,btnQuayLai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_ti_so);
        setColntrol();
        setEvent();
    }
    private void setEvent() {

        TrangChuTiSo.lvDanhSachTiSo.setAdapter(TrangChuTiSo.adapter_db);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TiSo tiSo = new TiSo("","","","","","");
                tiSo.setMaTS(edtmaTS.getText().toString());
                tiSo.setSoTheVang(edtSoTheVang.getText().toString());
                tiSo.setSoTheDo(edtSoTheDo.getText().toString());
                tiSo.setHieuSo(edtHieuSo.getText().toString());
                tiSo.setMaTD(edtMaTD.getText().toString());
                tiSo.setKetQua(edtKetQua.getText().toString());

                ThongKe tk = new ThongKe();
                tk.setMaTS(edtmaTS.getText().toString());
                tk.setSoTheVang(edtSoTheVang.getText().toString());
                tk.setSoTheDo(edtSoTheDo.getText().toString());
                tk.setHieuSo(edtHieuSo.getText().toString());
                tk.setMaTD(edtMaTD.getText().toString());
                tk.setKetQua(edtKetQua.getText().toString());
                TrangChuTiSo.db.ThemTiSo(tiSo);
                TrangChuTiSo.db.SuaThongKe(tk);

                Toast.makeText(ThemTiSo.this, "Them Thanh Cong", Toast.LENGTH_SHORT).show();

            }
        });
        btnLamMoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtmaTS.setText("");
                edtMaTD.setText("");
                edtSoTheDo.setText("");
                edtSoTheVang.setText("");
                edtKetQua.setText("");
                edtHieuSo.setText("");
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
        edtmaTS = findViewById(R.id.edtmaTS_them);
        edtSoTheVang = findViewById(R.id.edtSoTheVang_them);
        edtSoTheDo = findViewById(R.id.edtSoTheDo_them);
        edtHieuSo = findViewById(R.id.edtHieuSo_them);
        edtMaTD = findViewById(R.id.edtMaTD_them_TS);
        edtKetQua = findViewById(R.id.edtKetQua_them);

        btnThem = findViewById(R.id.btnThem_TS);
        btnLamMoi = findViewById(R.id.btnLamMoi_TS);
        btnQuayLai = findViewById(R.id.btnQuayLai_TS);
    }
}