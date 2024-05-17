package com.example.quanlydoibong.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.quanlydoibong.R;
import com.example.quanlydoibong.TiSo.TiSo;
import com.example.quanlydoibong.TranDau.TranDau;

import java.io.Serializable;
import java.util.List;

public class TiSoAdapter extends ArrayAdapter {
    Context context;
    int resuorse;
    List<TiSo> data;

    public TiSoAdapter(@NonNull Context context, int resource, @NonNull List<TiSo> data) {
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

        TextView tvmaTS = convertView.findViewById(R.id.tvmaTS);
        TextView tvTheVang = convertView.findViewById(R.id.tvSoTheVang);
        TextView tvTheDo = convertView.findViewById(R.id.tvSoTheDo);
        TextView tvHieuSo = convertView.findViewById(R.id.tvHieuSo);
        TextView tvKetQua = convertView.findViewById(R.id.tvKetQua);
        TextView tvmaTD = convertView.findViewById(R.id.tvMaTranDau_TS);

        TiSo tiSo = data.get(position);
        tvmaTD.setText(tiSo.getMaTD());
        tvmaTS.setText(tiSo.getMaTS());
        tvTheVang.setText(tiSo.getSoTheVang());
        tvTheDo.setText(tiSo.getSoTheDo());
        tvHieuSo.setText(tiSo.getHieuSo());
        tvKetQua.setText(tiSo.getKetQua());

        return  convertView;
    }
}
