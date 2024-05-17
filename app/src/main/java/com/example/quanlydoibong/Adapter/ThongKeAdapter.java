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
import com.example.quanlydoibong.ThongKe.ThongKe;
import com.example.quanlydoibong.TranDau.TranDau;

import java.util.List;

public class ThongKeAdapter extends ArrayAdapter {
    Context context;
    int resuorse;
    List<ThongKe> data;

    public ThongKeAdapter(@NonNull Context context, int resource, @NonNull List<ThongKe> data) {
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

        TextView tvmaTD = convertView.findViewById(R.id.tvTranDauThongKe);

        TextView tvngayThiDau = convertView.findViewById(R.id.tvNgayThiDauThongKe);
        TextView tvDoiA = convertView.findViewById(R.id.tvDoiAThongKe);
        TextView tvDoiB = convertView.findViewById(R.id.tvDoiBThongKe);
        TextView tvTrongTai = convertView.findViewById(R.id.tvTrongTaiThongKe);
        TextView tvTheVang = convertView.findViewById(R.id.tvSoTheVangThongKe);
        TextView tvTheDo = convertView.findViewById(R.id.tvSoTheDoThongKe);
        TextView tvHieuSo = convertView.findViewById(R.id.tvHieuSoThongKe);
        TextView tvKetQua = convertView.findViewById(R.id.tvKetQuaThongKe);

        ThongKe thongKe = data.get(position);
        tvmaTD.setText(thongKe.getMaTD());

        tvngayThiDau.setText(thongKe.getNgayThiDau());
        tvDoiA.setText(thongKe.getDoiA());
        tvDoiB.setText(thongKe.getDoiB());
        tvTrongTai.setText(thongKe.getTrongTai());
        tvTheVang.setText(thongKe.getSoTheVang());
        tvTheDo.setText(thongKe.getSoTheDo());
        tvHieuSo.setText(thongKe.getHieuSo());
        tvKetQua.setText(thongKe.getKetQua());

        return  convertView;
    }
}
