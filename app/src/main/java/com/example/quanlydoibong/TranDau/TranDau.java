package com.example.quanlydoibong.TranDau;

import java.io.Serializable;

public class TranDau implements Serializable {
    String maTD,ngayThiDau,doiA,doiB,trongTai;

    public String getMaTD() {
        return maTD;
    }

    public void setMaTD(String maTD) {
        this.maTD = maTD;
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

    public TranDau() {
    }

    public TranDau(String maTD, String ngayThiDau, String doiA, String doiB, String trongTai) {
        this.maTD = maTD;
        this.ngayThiDau = ngayThiDau;
        this.doiA = doiA;
        this.doiB = doiB;
        this.trongTai = trongTai;
    }
}
