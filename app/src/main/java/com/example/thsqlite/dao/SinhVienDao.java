package com.example.thsqlite.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.thsqlite.Lop;
import com.example.thsqlite.SinhVien;
import com.example.thsqlite.database.DBhelper;

import java.util.ArrayList;
import java.util.List;

public class SinhVienDao {
    private List<SinhVien> sinhVienList;
    private DBhelper csdl;

    public SinhVienDao(Context context) {

        csdl = new DBhelper(context);
    }

    public List<SinhVien> LoadDataSinhVien(String malop) {

        String sql = "SELECT masv, tensv, malop FROM tblsinhvien WHERE malop ='"+malop+ "'";
        List<SinhVien>  sinhVienList = new ArrayList<SinhVien>();
        SQLiteDatabase database = csdl.getReadableDatabase();
        Cursor cursor = database.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String msv = cursor.getString(0);
            String tensv = cursor.getString(1);
            String lophocphan = cursor.getString(2);
            SinhVien sv =new SinhVien(msv,tensv,lophocphan);
            sinhVienList.add(sv);

            cursor.moveToNext();
        }
        return sinhVienList;
    }
    public String LoadLop(String malop) {
        String sql = "SELECT * FROM tbllop Where malop='"+malop+ "'";
        SQLiteDatabase database = csdl.getReadableDatabase();
        Cursor cursor = database.rawQuery(sql, null);
        @SuppressLint("Range") String tenlop = cursor.getString(cursor.getColumnIndex("tenlop"));
        return tenlop;
    }
    public int delete(String id){
        SQLiteDatabase database = csdl.getWritableDatabase();
        return database.delete("tblsinhvien","masv=?", new String[]{id});
    }

    public void ThemSinhVien(SinhVien sv){
        SQLiteDatabase database = csdl.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Ten",sv.getTensv());
        values.put("NamSinh",sv.getNamsinh());
        values.put("DiemToan",sv.getDiemToan());
        values.put("DiemAnh",sv.getDiemAnh());
        values.put("DiemTin",sv.getDiemTin());
        values.put("DiemTin",sv.getDiemTin());
        database.insert("tblsinhvien","",values);
    }
}
