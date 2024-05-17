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
import com.example.quanlydoibong.R;

import java.util.List;

public class DoiBongAdapter extends ArrayAdapter {
    Context context;
    int resuorse;
    List<DoiBong> data;

    public DoiBongAdapter(@NonNull Context context, int resource, @NonNull List<DoiBong> data) {
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
        ImageView ivHinh = convertView.findViewById(R.id.ivHinh);
        TextView tvmaDB = convertView.findViewById(R.id.tvmaDB);
        TextView tvtenDB = convertView.findViewById(R.id.tvtenDB);
        TextView tvmaHLV = convertView.findViewById(R.id.tvmaHLV);
        TextView tvtenSoThanhVien = convertView.findViewById(R.id.tvsoThanhVien);

        DoiBong doiBong = data.get(position);
        tvmaDB.setText(doiBong.getMaDB());
        tvtenDB.setText(doiBong.getTenDB());
        tvmaHLV.setText(doiBong.getMaHLV());
        tvtenSoThanhVien.setText(doiBong.getSoThanhVien());

        if(doiBong.getGiaiDau().equals("EPL"))
        {
            ivHinh.setImageResource(R.drawable.ic_launcher_background);
        }
        if(doiBong.getGiaiDau().equals("LALIGA"))
        {
            ivHinh.setImageResource(R.drawable.ic_launcher_background);
        }
        if(doiBong.getGiaiDau().equals("LIGUE 1"))
        {
            ivHinh.setImageResource(R.drawable.ic_launcher_background);
        }
        return  convertView;
    }
}
