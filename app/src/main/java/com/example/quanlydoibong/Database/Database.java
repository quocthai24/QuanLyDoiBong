package com.example.quanlydoibong.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.quanlydoibong.CauThu.CauThu;
import com.example.quanlydoibong.DoiBong.DoiBong;
import com.example.quanlydoibong.HuanLuyenVien.HuanLuyenVien;
import com.example.quanlydoibong.ThongKe.ThongKe;
import com.example.quanlydoibong.TiSo.TiSo;
import com.example.quanlydoibong.TranDau.TranDau;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context){
        super(context, "dbDoiBong2",null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCauThu = "create table tblCauThu(maCT text,tenCT text,ngaySinh text,maDB text,viTri text,luong text,maDoiHinh text)";
        String sqlHLV = "create table tblHLV(maHLV text, tenHLV text, ngaySinh text, quocGia text,tuoi text,doiBong text)";
        String sqlDoiBong = "create table tblDoiBong(maDoiBong text, tenDoiBong text, giaiDau text,maHLV text,soThanhVien text)";
        String sqlTranDau = "create table tblTranDau(maTD text,ngayThiDau text,doiA text,doiB text,trongTai text)";
        String sqlTiSo = "create table tblTiSo(maTiSo text,soTheVang text,soTheDo text,hieuSo text,ketQua text,maTD text)";
        String sqlThongKe = "create table tblThongKe(maTD text,ngayThiDau text,doiA text,doiB text,trongTai text,maTiSo text,soTheVang text,soTheDo text,hieuSo text,ketQua text)";
        db.execSQL(sqlHLV);
        db.execSQL(sqlDoiBong);
        db.execSQL(sqlTranDau);
        db.execSQL(sqlTiSo);
        db.execSQL(sqlThongKe);
        db.execSQL(sqlCauThu);
    }
    public void XoaThongKe(ThongKe thongKe){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="Delete from tblThongKe where maTD=?";
        sqLiteDatabase.execSQL(sql,new String[]{thongKe.getMaTD()});
    }
    public void UpdateMaTiSo(ThongKe thongKe){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="Update tblThongKe set maTiSo=? where maTD=?";
        sqLiteDatabase.execSQL(sql,new String[]{thongKe.getMaTS(),thongKe.getMaTD()});
    }
    public void SuaThongKe(ThongKe thongKe){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="Update tblThongKe set soTheVang=?,soTheDo=?,hieuSo=?,ketQua=? where maTD=?";
        sqLiteDatabase.execSQL(sql,new String[]{thongKe.getSoTheVang(),thongKe.getSoTheDo(),thongKe.getHieuSo(),thongKe.getKetQua(),thongKe.getMaTD()});
    }
    public void ThemThongKe(ThongKe thongKe){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="insert into tblThongKe values(?,?,?,?,?,?,?,?,?,?)";
        sqLiteDatabase.execSQL(sql,new String[]{thongKe.getMaTD(), thongKe.getMaTS(),thongKe.getNgayThiDau(), thongKe.getDoiA(), thongKe.getDoiB(),thongKe.getTrongTai(),thongKe.getSoTheVang(),thongKe.getSoTheDo(),thongKe.getHieuSo(),thongKe.getKetQua()});
    }
    public List<ThongKe> DocThongKe(){
        List<ThongKe>data=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        String sql="select * from tblThongKe";
        Cursor cursor=sqLiteDatabase.rawQuery(sql,null);
        if (cursor.moveToFirst())
        {
            do {
                ThongKe thongKe=new ThongKe();
                thongKe.setMaTD(cursor.getString(0));
                thongKe.setMaTS(cursor.getString(1));
                thongKe.setNgayThiDau(cursor.getString(2));
                thongKe.setDoiA(cursor.getString(3));
                thongKe.setDoiB(cursor.getString(4));
                thongKe.setTrongTai(cursor.getString(5));
                thongKe.setSoTheVang(cursor.getString(6));
                thongKe.setSoTheDo(cursor.getString(7));
                thongKe.setHieuSo(cursor.getString(8));
                thongKe.setKetQua(cursor.getString(9));
                data.add(thongKe);
            }
            while (cursor.moveToNext());
        }
        return data;
    }
    public List<CauThu> DanhSachCauThu(CauThu cauThu){
        List<CauThu>data=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        String sql="select * from tblCauThu where maDB=?";
        Cursor cursor=sqLiteDatabase.rawQuery(sql,new String[]{cauThu.getMaDB()});
        if (cursor.moveToFirst())
        {
            do {
                cauThu=new CauThu();
                cauThu.setMaCT(cursor.getString(0));
                cauThu.setTenCT(cursor.getString(1));
                cauThu.setNgaySinh(cursor.getString(2));
                cauThu.setMaDB(cursor.getString(3));
                cauThu.setViTri(cursor.getString(4));
                cauThu.setLuong(cursor.getString(5));
                cauThu.setDoiHinh(cursor.getString(6));

                data.add(cauThu);
            }
            while (cursor.moveToNext());
        }
        return data;
    }
    public void SuaTiSo(TiSo tiSo){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="Update tblTiSo set soTheVang=?,soTheDo=?,hieuSo=?,ketQua=?,maTD=? where maTiSo=?";
        sqLiteDatabase.execSQL(sql,new String[]{tiSo.getSoTheVang(),tiSo.getSoTheDo(),tiSo.getHieuSo(),tiSo.getKetQua(),tiSo.getMaTD(),tiSo.getMaTS()});
    }
    public void ThemTiSo(TiSo tiSo){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="insert into tblTiSo values(?,?,?,?,?,?)";
        sqLiteDatabase.execSQL(sql,new String[]{tiSo.getMaTS(), tiSo.getSoTheVang(), tiSo.getSoTheDo(), tiSo.getHieuSo(),tiSo.getKetQua(),tiSo.getMaTD()});
    }
    public void XoaTiSo(TiSo tiSo){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="Delete from tblTiSo where maTiSo=?";
        sqLiteDatabase.execSQL(sql,new String[]{tiSo.getMaTS()});
    }
    public void XoaTiSoTranDau(TiSo tiSo){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="Delete from tblTiSo where maTD=?";
        sqLiteDatabase.execSQL(sql,new String[]{tiSo.getMaTD()});
    }
    public List<TiSo> DocTiSo(){
        List<TiSo>data=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        String sql="select * from tblTiSo";
        Cursor cursor=sqLiteDatabase.rawQuery(sql,null);
        if (cursor.moveToFirst())
        {
            do {
                TiSo tiSo=new TiSo();
                tiSo.setMaTS(cursor.getString(0));
                tiSo.setSoTheVang(cursor.getString(1));
                tiSo.setSoTheDo(cursor.getString(2));
                tiSo.setHieuSo(cursor.getString(3));
                tiSo.setKetQua(cursor.getString(4));
                tiSo.setMaTD(cursor.getString(5));

                data.add(tiSo);
            }
            while (cursor.moveToNext());
        }
        return data;
    }
    public void SuaTranDau(TranDau tranDau){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="Update tblTranDau set ngayThiDau=?,doiA=?,doiB=?,trongTai=? where maTD=?";
        sqLiteDatabase.execSQL(sql,new String[]{tranDau.getNgayThiDau(),tranDau.getDoiA(),tranDau.getDoiB(),tranDau.getTrongTai(),tranDau.getMaTD()});
    }
    public void ThemTranDau(TranDau tranDau){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="insert into tblTranDau values(?,?,?,?,?)";
        sqLiteDatabase.execSQL(sql,new String[]{tranDau.getMaTD(), tranDau.getNgayThiDau(), tranDau.getDoiA(), tranDau.getDoiB(),tranDau.getTrongTai()});
    }
    public List<TranDau> DocTranDau(){
        List<TranDau>data=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        String sql="select * from tblTranDau";
        Cursor cursor=sqLiteDatabase.rawQuery(sql,null);
        if (cursor.moveToFirst())
        {
            do {
                TranDau tranDau=new TranDau();
                tranDau.setMaTD(cursor.getString(0));
                tranDau.setNgayThiDau(cursor.getString(1));
                tranDau.setDoiA(cursor.getString(2));
                tranDau.setDoiB(cursor.getString(3));
                tranDau.setTrongTai(cursor.getString(4));

                data.add(tranDau);
            }
            while (cursor.moveToNext());
        }
        return data;
    }
    public void XoaTranDau(TranDau tranDau){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="Delete from tblTranDau where maTD=?";
        sqLiteDatabase.execSQL(sql,new String[]{tranDau.getMaTD()});
    }
    public void SuaCauThu(CauThu cauThu){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="Update tblCauThu set tenCT=?,ngaySinh=?,maDB=?,viTri=?,luong=?,maDoiHinh=? where maCT=?";
        sqLiteDatabase.execSQL(sql,new String[]{cauThu.getTenCT(),cauThu.getNgaySinh(),cauThu.getMaDB(),cauThu.getViTri(),cauThu.getLuong(),cauThu.getDoiHinh(),cauThu.getMaCT()});
    }
    public void XoaCauThu(CauThu cauThu){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="Delete from tblCauThu where maCT=?";
        sqLiteDatabase.execSQL(sql,new String[]{cauThu.getMaCT()});
    }
    public void ThemCauThu(CauThu cauThu){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="insert into tblCauThu values(?,?,?,?,?,?,?)";
        sqLiteDatabase.execSQL(sql,new String[]{cauThu.getMaCT(), cauThu.getTenCT(), cauThu.getNgaySinh(), cauThu.getMaDB(),cauThu.getViTri(),cauThu.getLuong(),cauThu.getDoiHinh()});
    }
    public List<CauThu> DocCauThuDuBi(){
        List<CauThu>data=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        String sql="select * from tblCauThu where maDoiHinh = 'Du Bi'";
        Cursor cursor=sqLiteDatabase.rawQuery(sql,null);
        if (cursor.moveToFirst())
        {
            do {
                CauThu cauThu=new CauThu();
                cauThu.setMaCT(cursor.getString(0));
                cauThu.setTenCT(cursor.getString(1));
                cauThu.setNgaySinh(cursor.getString(2));
                cauThu.setMaDB(cursor.getString(3));
                cauThu.setViTri(cursor.getString(4));
                cauThu.setLuong(cursor.getString(5));
                cauThu.setDoiHinh(cursor.getString(6));

                data.add(cauThu);
            }
            while (cursor.moveToNext());
        }
        return data;
    }
    public List<CauThu> DocCauThuRaSan(){
        List<CauThu>data=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        String sql="select * from tblCauThu where maDoiHinh = 'Chinh'";
        Cursor cursor=sqLiteDatabase.rawQuery(sql,null);
        if (cursor.moveToFirst())
        {
            do {
                CauThu cauThu=new CauThu();
                cauThu.setMaCT(cursor.getString(0));
                cauThu.setTenCT(cursor.getString(1));
                cauThu.setNgaySinh(cursor.getString(2));
                cauThu.setMaDB(cursor.getString(3));
                cauThu.setViTri(cursor.getString(4));
                cauThu.setLuong(cursor.getString(5));
                cauThu.setDoiHinh(cursor.getString(6));

                data.add(cauThu);
            }
            while (cursor.moveToNext());
        }
        return data;
    }
    public List<CauThu> DocCauThu(){
        List<CauThu>data=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        String sql="select * from tblCauThu";
        Cursor cursor=sqLiteDatabase.rawQuery(sql,null);
        if (cursor.moveToFirst())
        {
            do {
                CauThu cauThu=new CauThu();
                cauThu.setMaCT(cursor.getString(0));
                cauThu.setTenCT(cursor.getString(1));
                cauThu.setNgaySinh(cursor.getString(2));
                cauThu.setMaDB(cursor.getString(3));
                cauThu.setViTri(cursor.getString(4));
                cauThu.setLuong(cursor.getString(5));
                cauThu.setDoiHinh(cursor.getString(6));

                data.add(cauThu);
            }
            while (cursor.moveToNext());
        }
        return data;
    }
    public List<DoiBong> XemDoiBong(HuanLuyenVien hlv){
        List<DoiBong>data=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        String sql="select * from tblDoiBong where maHLV=?";
        Cursor cursor=sqLiteDatabase.rawQuery(sql,new String[]{hlv.getMaHLV()});
        if (cursor.moveToFirst())
        {
            do {
                DoiBong doiBong=new DoiBong();
                doiBong.setMaDB(cursor.getString(0));
                doiBong.setTenDB(cursor.getString(1));
                doiBong.setGiaiDau(cursor.getString(2));
                doiBong.setMaHLV(cursor.getString(3));
                doiBong.setSoThanhVien(cursor.getString(4));

                data.add(doiBong);
            }
            while (cursor.moveToNext());
        }
        return data;
    }
    public List<HuanLuyenVien> DocHuanLuyenVien(HuanLuyenVien hlv){
        List<HuanLuyenVien>data=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        String sql="select * from tblHLV where maHLV=?";
        Cursor cursor=sqLiteDatabase.rawQuery(sql,new String[]{hlv.getMaHLV()});
        if (cursor.moveToFirst())
        {
            do {
                hlv=new HuanLuyenVien();
                hlv.setMaHLV(cursor.getString(0));
                hlv.setTenHLV(cursor.getString(1));
                hlv.setNgaySinh(cursor.getString(2));
                hlv.setQuocGia(cursor.getString(3));
                hlv.setTuoi(cursor.getString(4));
                hlv.setDoiBong(cursor.getString(5));

                data.add(hlv);
            }
            while (cursor.moveToNext());
        }
        return data;
    }
    public List<String> LayDoiBong(){
        List<String>data=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        String sql="select maDoiBong from tblDoiBong";
        Cursor cursor=sqLiteDatabase.rawQuery(sql,null);
        if (cursor.moveToFirst())
        {
            do {
                String doiBong = cursor.getString(0);
                data.add(doiBong);
            }
            while (cursor.moveToNext());
        }
        return data;
    }
    public void XoaHLV(HuanLuyenVien hlv){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="Delete from tblHLV where maHLV=?";
        sqLiteDatabase.execSQL(sql,new String[]{hlv.getMaHLV()});
    }
    public List<HuanLuyenVien> DocHLV(){
        List<HuanLuyenVien>data=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        String sql="select * from tblHLV";
        Cursor cursor=sqLiteDatabase.rawQuery(sql,null);
        if (cursor.moveToFirst())
        {
            do {
                HuanLuyenVien hlv=new HuanLuyenVien();
                hlv.setMaHLV(cursor.getString(0));
                hlv.setTenHLV(cursor.getString(1));
                hlv.setNgaySinh(cursor.getString(2));
                hlv.setQuocGia(cursor.getString(3));
                hlv.setTuoi(cursor.getString(4));
                hlv.setDoiBong(cursor.getString(5));

                data.add(hlv);
            }
            while (cursor.moveToNext());
        }
        return data;
    }
    public void SuaHLV(HuanLuyenVien hlv){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="Update tblHLV set tenHLV=?,ngaySinh=?,quocGia=?,tuoi=?,doiBong=? where maHLV=?";
        sqLiteDatabase.execSQL(sql,new String[]{hlv.getTenHLV(),hlv.getNgaySinh(),hlv.getQuocGia(),hlv.getTuoi(),hlv.getDoiBong(),hlv.getMaHLV()});
    }
    public void ThemHLV(HuanLuyenVien huanLuyenVien){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="insert into tblHLV values(?,?,?,?,?,?)";
        sqLiteDatabase.execSQL(sql,new String[]{huanLuyenVien.getMaHLV(), huanLuyenVien.getTenHLV(), huanLuyenVien.getNgaySinh(), huanLuyenVien.getQuocGia(),huanLuyenVien.getTuoi(),huanLuyenVien.getDoiBong()});
    }
    public void ThemDoiBong(DoiBong doiBong){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="insert into tblDoiBong values(?,?,?,?,?)";
        sqLiteDatabase.execSQL(sql,new String[]{doiBong.getMaDB(), doiBong.getTenDB(), doiBong.getGiaiDau(), doiBong.getMaHLV(),doiBong.getSoThanhVien()});
    }
    public void SuaDoiBong(DoiBong doiBong){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="Update tblDoiBong set tenDoiBong=?,giaiDau=?,maHLV=?,soThanhVien=? where maDoiBong=?";
        sqLiteDatabase.execSQL(sql,new String[]{doiBong.getTenDB(),doiBong.getGiaiDau(),doiBong.getMaHLV(),doiBong.getSoThanhVien(),doiBong.getMaDB()});
    }
    public List<DoiBong> DocDoiBong(){
        List<DoiBong>data=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        String sql="select * from tblDoiBong";
        Cursor cursor=sqLiteDatabase.rawQuery(sql,null);
        if (cursor.moveToFirst())
        {
            do {
                DoiBong doiBong=new DoiBong();
                doiBong.setMaDB(cursor.getString(0));
                doiBong.setTenDB(cursor.getString(1));
                doiBong.setGiaiDau(cursor.getString(2));
                doiBong.setMaHLV(cursor.getString(3));
                doiBong.setSoThanhVien(cursor.getString(4));

                data.add(doiBong);
            }
            while (cursor.moveToNext());
        }
        return data;
    }
    public void XoaDoiBong(DoiBong doiBong){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="Delete from tblDoiBong where maDoiBong=?";
        sqLiteDatabase.execSQL(sql,new String[]{doiBong.getMaDB()});
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
