package com.example.quanlydoibong.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.quanlydoibong.HuanLuyenVien.HuanLuyenVien;
import com.example.quanlydoibong.R;
import com.example.quanlydoibong.TranDau.TranDau;

import java.util.List;

public class TranDauAdapter extends ArrayAdapter {
    Context context;
    int resuorse;
    List<TranDau> data;

    public TranDauAdapter(@NonNull Context context, int resource, @NonNull List<TranDau> data) {
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

        TextView tvmaTD = convertView.findViewById(R.id.tvmaTD);
        TextView tvNgayThiDau = convertView.findViewById(R.id.tvNgayThiDau);
        TextView tvDoiA = convertView.findViewById(R.id.tvDoiA);
        TextView tvDoiB = convertView.findViewById(R.id.tvDoiB);
        TextView tvTrongTai = convertView.findViewById(R.id.tvTrongTai);

        TranDau tranDau = data.get(position);
        tvmaTD.setText(tranDau.getMaTD());
        tvNgayThiDau.setText(tranDau.getNgayThiDau());
        tvDoiA.setText(tranDau.getDoiA());
        tvDoiB.setText(tranDau.getDoiB());
        tvTrongTai.setText(tranDau.getTrongTai());

        return  convertView;
    }
}
