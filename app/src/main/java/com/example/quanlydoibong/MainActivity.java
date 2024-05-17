package com.example.quanlydoibong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn_chuTich,btn_hlv,btn_thoat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
    }
    private void setEvent(){
        btn_chuTich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FragmentChuTich.class);
                startActivity(intent);
            }
        });
        btn_hlv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FragmentHLV.class);
                startActivity(intent);
            }
        });
        btn_thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void setControl(){
        btn_chuTich = findViewById(R.id.btnChuTich);
        btn_hlv = findViewById(R.id.btnHLV);
        btn_thoat = findViewById(R.id.btnThoat);
    }
}