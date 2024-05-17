package com.example.quanlydoibong.TiSo;

import java.io.Serializable;

public class TiSo implements Serializable {
    String maTS;
    String soTheVang;
    String soTheDo;
    String hieuSo;
    String ketQua;

    public String getMaTS() {
        return maTS;
    }

    public void setMaTS(String maTS) {
        this.maTS = maTS;
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

    public String getMaTD() {
        return maTD;
    }

    public void setMaTD(String maTD) {
        this.maTD = maTD;
    }

    String maTD;

    public TiSo() {
    }

    public TiSo(String maTS, String soTheVang, String soTheDo, String hieuSo, String ketQua, String maTD) {
        this.maTS = maTS;
        this.soTheVang = soTheVang;
        this.soTheDo = soTheDo;
        this.hieuSo = hieuSo;
        this.ketQua = ketQua;
        this.maTD = maTD;
    }
}
