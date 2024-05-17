package com.example.quanlydoibong;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.quanlydoibong.DoiBong.TrangChuDoiBong;
import com.example.quanlydoibong.HuanLuyenVien.TrangChuHLV;
import com.google.android.material.navigation.NavigationView;

public class FragmentChuTich extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_chu_tich);
        setControl();
        setEvent();
    }
    private void setEvent() {
        drawerToggle=new ActionBarDrawerToggle(FragmentChuTich.this,drawerLayout,R.string.app_name,R.string.app_name);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId()==R.id.mnHlv){
                    Intent intent = new Intent(FragmentChuTich.this, TrangChuHLV.class);
                    startActivity(intent);
                } else if (item.getItemId() == R.id.mnThoatCT) {
                    finish();
                }
                else if(item.getItemId()==R.id.mnDoiBong){
                    Intent intent = new Intent(FragmentChuTich.this, TrangChuDoiBong.class);
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
        drawerLayout=findViewById(R.id.drawerLayout);
        navigationView=findViewById(R.id.navView);
    }
}