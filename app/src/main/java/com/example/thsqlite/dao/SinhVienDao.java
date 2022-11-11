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

    public List<SinhVien> LoadDataSinhVien(String tenlop) {

        String sql = "SELECT masv, tensv, tenLop FROM tblsinhvien WHERE tenLop ='"+tenlop+ "'";
        List<SinhVien>  sinhVienList = new ArrayList<SinhVien>();
        SQLiteDatabase database = csdl.getReadableDatabase();
        Cursor cursor = database.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String msv = cursor.getString(0);
            String tensv = cursor.getString(1);
            String tenLop = cursor.getString(2);
            SinhVien sv =new SinhVien(msv,tensv,tenLop);
            sinhVienList.add(sv);

            cursor.moveToNext();
        }
        return sinhVienList;
    }

    public void CapNhatSinhVien(SinhVien sv){
        SQLiteDatabase database = csdl.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("tensv",sv.getTensv());
        values.put("namsinh",String.valueOf(sv.getNamsinh()));
        values.put("DiemToan",String.valueOf(sv.getDiemToan()));
        values.put("DiemAnh",String.valueOf(sv.getDiemAnh()));
        values.put("DiemTin",String.valueOf(sv.getDiemTin()));
        values.put("tenLop",sv.getTenLop());
        String masv = String.valueOf(sv.getMsv());
        String thamso[] = {masv};
        database.update("tblsinhvien",values,"masv=?",thamso);
    }

    public int delete(String id){
        SQLiteDatabase database = csdl.getWritableDatabase();
        return database.delete("tblsinhvien","masv=?", new String[]{id});
    }

    public long ThemSinhVien(SinhVien sv){
        SQLiteDatabase database = csdl.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("masv",sv.getMsv());
        values.put("tensv",sv.getTensv());
        values.put("namsinh",String.valueOf(sv.getNamsinh()));
        values.put("DiemToan",String.valueOf(sv.getDiemToan()));
        values.put("DiemAnh",String.valueOf(sv.getDiemAnh()));
        values.put("DiemTin",String.valueOf(sv.getDiemTin()));
        values.put("tenLop",sv.getTenLop());
        return database.insert("tblsinhvien",null,values);
    }
}
