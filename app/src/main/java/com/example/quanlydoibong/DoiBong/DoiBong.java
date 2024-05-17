package com.example.quanlydoibong.DoiBong;

import java.io.Serializable;

public class DoiBong implements Serializable {
    String maDB, tenDB, giaiDau,maHLV,soThanhVien;

    public DoiBong() {
    }

    public String getMaDB() {
        return maDB;
    }

    public void setMaDB(String maDB) {
        this.maDB = maDB;
    }

    public String getTenDB() {
        return tenDB;
    }

    public void setTenDB(String tenDB) {
        this.tenDB = tenDB;
    }

    public String getGiaiDau() {
        return giaiDau;
    }

    public void setGiaiDau(String giaiDau) {
        this.giaiDau = giaiDau;
    }

    public String getMaHLV() {
        return maHLV;
    }

    public void setMaHLV(String maHLV) {
        this.maHLV = maHLV;
    }

    public String getSoThanhVien() {
        return soThanhVien;
    }

    public void setSoThanhVien(String soThanhVien) {
        this.soThanhVien = soThanhVien;
    }

    public DoiBong(String maDB, String tenDB, String giaiDau, String maHLV, String soThanhVien) {
        this.maDB = maDB;
        this.tenDB = tenDB;
        this.giaiDau = giaiDau;
        this.maHLV = maHLV;
        this.soThanhVien = soThanhVien;
    }
}
