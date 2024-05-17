package com.example.quanlydoibong.CauThu;

import java.io.Serializable;

public class CauThu implements Serializable {
    String maCT;
    String tenCT;
    String ngaySinh;
    String viTri;
    String luong;
    String doiHinh;

    public String getMaCT() {
        return maCT;
    }

    public void setMaCT(String maCT) {
        this.maCT = maCT;
    }

    public String getTenCT() {
        return tenCT;
    }

    public void setTenCT(String tenCT) {
        this.tenCT = tenCT;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public String getLuong() {
        return luong;
    }

    public void setLuong(String luong) {
        this.luong = luong;
    }

    public String getDoiHinh() {
        return doiHinh;
    }

    public void setDoiHinh(String doiHinh) {
        this.doiHinh = doiHinh;
    }

    public String getMaDB() {
        return maDB;
    }

    public void setMaDB(String maDB) {
        this.maDB = maDB;
    }

    String maDB;

    public CauThu() {
    }

    public CauThu(String maCT, String tenCT, String ngaySinh, String viTri, String luong, String doiHinh, String maDB) {
        this.maCT = maCT;
        this.tenCT = tenCT;
        this.ngaySinh = ngaySinh;
        this.viTri = viTri;
        this.luong = luong;
        this.doiHinh = doiHinh;
        this.maDB = maDB;
    }
}
