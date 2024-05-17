package com.example.quanlydoibong;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.quanlydoibong.CauThu.TrangChuCauThu;
import com.example.quanlydoibong.DoiHinh.DoiHinhDuBi;
import com.example.quanlydoibong.DoiHinh.DoiHinhRaSan;
import com.example.quanlydoibong.ThongKe.TrangChuThongKe;
import com.example.quanlydoibong.TiSo.TrangChuTiSo;
import com.example.quanlydoibong.TranDau.TrangChuTranDau;
import com.google.android.material.navigation.NavigationView;

public class FragmentHLV extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_hlv);
        setControl();
        setEvent();
    }
    private void setEvent() {
        drawerToggle=new ActionBarDrawerToggle(FragmentHLV.this,drawerLayout,R.string.app_name,R.string.app_name);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId()==R.id.mnCauThu){
                    Intent intent = new Intent(FragmentHLV.this, TrangChuCauThu.class);
                    startActivity(intent);
                } else if (item.getItemId() == R.id.mnThoat) {
                    finish();
                }
                else if(item.getItemId()==R.id.mnTranDau){
                    Intent intent = new Intent(FragmentHLV.this, TrangChuTranDau.class);
                    startActivity(intent);
                }
                else if(item.getItemId()==R.id.mnThongKe){
                    Intent intent = new Intent(FragmentHLV.this, TrangChuThongKe.class);
                    startActivity(intent);
                }
                else if(item.getItemId()==R.id.mnDoiHinhRaSan){
                    Intent intent = new Intent(FragmentHLV.this, DoiHinhRaSan.class);
                    startActivity(intent);
                }
                else if(item.getItemId()==R.id.mnPhat){
                    Intent intent = new Intent(FragmentHLV.this, TrangChuTiSo.class);
                    startActivity(intent);
                }
                else if(item.getItemId()==R.id.mnDoiHinhDuBi){
                    Intent intent = new Intent(FragmentHLV.this, DoiHinhDuBi.class);
                    startActivity(intent);
                }
                drawerLayout.closeDrawers();
                return false;
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if(drawerToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }
    private void setControl() {
        drawerLayout=findViewById(R.id.drawerLayoutHLV);
        navigationView=findViewById(R.id.navViewHLV);
    }
}