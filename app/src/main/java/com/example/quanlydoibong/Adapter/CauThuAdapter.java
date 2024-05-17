package com.example.quanlydoibong.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.quanlydoibong.CauThu.CauThu;
import com.example.quanlydoibong.DoiBong.DoiBong;
import com.example.quanlydoibong.R;

import java.util.List;

public class CauThuAdapter extends ArrayAdapter {
    Context context;
    int resuorse;
    List<CauThu> data;

    public CauThuAdapter(@NonNull Context context, int resource, @NonNull List<CauThu> data) {
        super(context, resource, data);
        this.context = context;
        this.resuorse = resource;
        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // return super.getView(position, convertView, parent);
        convertView = LayoutInflater.from(context).inflate(resuorse, null);
        ImageView ivHinh = convertView.findViewById(R.id.ivHinhCT);
        TextView tvmaCT = convertView.findViewById(R.id.tvmaCT);
        TextView tvtenCT = convertView.findViewById(R.id.tvtenCT);
        TextView tvNgaySinh = convertView.findViewById(R.id.tvNgaySinhCT);
        TextView tvMaDB = convertView.findViewById(R.id.tvDoiBong);
        TextView tvViTri = convertView.findViewById(R.id.tvViTri);
        TextView tvLuong = convertView.findViewById(R.id.tvLuong);

        CauThu cauThu = data.get(position);
        tvmaCT.setText(cauThu.getMaCT());
        tvtenCT.setText(cauThu.getTenCT());
        tvNgaySinh.setText(cauThu.getNgaySinh());
        tvMaDB.setText(cauThu.getMaDB());
        tvLuong.setText(cauThu.getLuong());
        tvViTri.setText(cauThu.getViTri());

        if(cauThu.getDoiHinh().equals("Chinh"))
        {
            ivHinh.setImageResource(R.drawable.ic_launcher_background);
        }
        if(cauThu.getDoiHinh().equals("Du Bi"))
        {
            ivHinh.setImageResource(R.drawable.ic_launcher_background);
        }
        return  convertView;
    }
}
