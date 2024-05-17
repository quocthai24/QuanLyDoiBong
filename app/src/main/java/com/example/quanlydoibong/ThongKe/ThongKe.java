package com.example.quanlydoibong.ThongKe;

import java.io.Serializable;

public class ThongKe implements Serializable {
    String maTD,maTS,ngayThiDau,doiA,doiB,trongTai,soTheVang,soTheDo,hieuSo,ketQua;

    public ThongKe() {
    }

    public String getMaTD() {
        return maTD;
    }

    public void setMaTD(String maTD) {
        this.maTD = maTD;
    }

    public String getMaTS() {
        return maTS;
    }

    public void setMaTS(String maTS) {
        this.maTS = maTS;
    }

    public String getNgayThiDau() {
        return ngayThiDau;
    }

    public void setNgayThiDau(String ngayThiDau) {
        this.ngayThiDau = ngayThiDau;
    }

    public String getDoiA() {
        return doiA;
    }

    public void setDoiA(String doiA) {
        this.doiA = doiA;
    }

    public String getDoiB() {
        return doiB;
    }

    public void setDoiB(String doiB) {
        this.doiB = doiB;
    }

    public String getTrongTai() {
        return trongTai;
    }

    public void setTrongTai(String trongTai) {
        this.trongTai = trongTai;
    }

    public String getSoTheVang() {
        return soTheVang;
    }

    public void setSoTheVang(String soTheVang) {
        this.soTheVang = soTheVang;
    }

    public String getSoTheDo() {
        return soTheDo;
    }

    public void setSoTheDo(String soTheDo) {
        this.soTheDo = soTheDo;
    }

    public String getHieuSo() {
        return hieuSo;
    }

    public void setHieuSo(String hieuSo) {
        this.hieuSo = hieuSo;
    }

    public String getKetQua() {
        return ketQua;
    }

    public void setKetQua(String ketQua) {
        this.ketQua = ketQua;
    }

    public ThongKe(String maTD, String maTS, String ngayThiDau, String doiA, String doiB, String trongTai, String soTheVang, String soTheDo, String hieuSo, String ketQua) {
        this.maTD = maTD;
        this.maTS = maTS;
        this.ngayThiDau = ngayThiDau;
        this.doiA = doiA;
        this.doiB = doiB;
        this.trongTai = trongTai;
        this.soTheVang = soTheVang;
        this.soTheDo = soTheDo;
        this.hieuSo = hieuSo;
        this.ketQua = ketQua;
    }
}
