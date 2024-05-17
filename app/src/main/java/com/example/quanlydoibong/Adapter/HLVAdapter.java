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

import com.example.quanlydoibong.DoiBong.DoiBong;
import com.example.quanlydoibong.HuanLuyenVien.HuanLuyenVien;
import com.example.quanlydoibong.R;

import java.util.List;

public class HLVAdapter extends ArrayAdapter {
    Context context;
    int resuorse;
    List<HuanLuyenVien> data;

    public HLVAdapter(@NonNull Context context, int resource, @NonNull List<HuanLuyenVien> data) {
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

        TextView tvmaHLV = convertView.findViewById(R.id.tvmaHLV);
        TextView tvtenHLV = convertView.findViewById(R.id.tvtenHLV);
        TextView tvNgaySinh = convertView.findViewById(R.id.tvngaySinh);
        TextView tvQuocGia = convertView.findViewById(R.id.tvQuocGia);
        TextView tvTuoi = convertView.findViewById(R.id.tvTuoi);
        TextView tvDoiBong = convertView.findViewById(R.id.tvDoiBong);

        HuanLuyenVien hlv = data.get(position);
        tvmaHLV.setText(hlv.getMaHLV());
        tvtenHLV.setText(hlv.getTenHLV());
        tvNgaySinh.setText(hlv.getNgaySinh());
        tvQuocGia.setText(hlv.getQuocGia());
        tvTuoi.setText(hlv.getTuoi());
        tvDoiBong.setText(hlv.getDoiBong());

        return  convertView;
    }
}
