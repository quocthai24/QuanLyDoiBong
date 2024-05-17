package com.example.quanlydoibong.HuanLuyenVien;

import java.io.Serializable;

public class HuanLuyenVien implements Serializable {
    public HuanLuyenVien() {
    }

    String maHLV,tenHLV,ngaySinh,quocGia,tuoi,doiBong;

    public String getMaHLV() {
        return maHLV;
    }

    public void setMaHLV(String maHLV) {
        this.maHLV = maHLV;
    }

    public String getTenHLV() {
        return tenHLV;
    }

    public void setTenHLV(String tenHLV) {
        this.tenHLV = tenHLV;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }

    public String getTuoi() {
        return tuoi;
    }

    public void setTuoi(String tuoi) {
        this.tuoi = tuoi;
    }

    public String getDoiBong() {
        return doiBong;
    }

    public void setDoiBong(String doiBong) {
        this.doiBong = doiBong;
    }

    public HuanLuyenVien(String maHLV, String tenHLV, String ngaySinh, String quocGia, String tuoi, String doiBong) {
        this.maHLV = maHLV;
        this.tenHLV = tenHLV;
        this.ngaySinh = ngaySinh;
        this.quocGia = quocGia;
        this.tuoi = tuoi;
        this.doiBong = doiBong;
    }
}
