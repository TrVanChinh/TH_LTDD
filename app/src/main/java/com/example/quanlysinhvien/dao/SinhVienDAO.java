package com.example.quanlysinhvien.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.quanlysinhvien.database.DBHelper;
import com.example.quanlysinhvien.model.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SinhVienDAO {
    private List<SinhVien> sinhVienList112;
    private DBHelper csdl112;
    public SinhVienDAO(Context context){
        csdl112 = new DBHelper(context);
    }

    public List<SinhVien> TatCaSinhVien(){
        String sql = "SELECT * FROM SinhVien";
        List<SinhVien>  sinhVienList = new ArrayList<SinhVien>();
        SQLiteDatabase database = csdl112.getReadableDatabase();
        Cursor cursor = database.rawQuery(sql,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int masv =  cursor.getInt(0);
            String hoten = cursor.getString(1);
            int gioitinh = cursor.getInt(2);
            String dienthoai = cursor.getString(3);
            String email = cursor.getString(4);
            SinhVien sv = new SinhVien(masv,hoten,gioitinh,dienthoai,email);
            sinhVienList.add(sv);
            cursor.moveToNext();
        }
        return sinhVienList;
    }
    //thêm sinh viên
    public void ThemSinhVien(SinhVien sv){
        SQLiteDatabase database = csdl112.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("HoTen",sv.getHoTen());
        values.put("GioiTinh",sv.getGioiTinh());
        values.put("DienThoai",sv.getDienThoai());
        values.put("Email",sv.getEmail());
        database.insert("SinhVien","",values);
    }
    //Cập nhật sinh viên
    public void CapNhatSinhVien(SinhVien sv){
        SQLiteDatabase database = csdl112.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("HoTen",sv.getHoTen());
        values.put("GioiTinh",sv.getGioiTinh());
        values.put("DienThoai",sv.getDienThoai());
        values.put("Email",sv.getEmail());
        String masv = String.valueOf(sv.getMaSV());
        String thamso[] = {masv};
        database.update("SinhVien",values,"MaSV=?", thamso);

    }
    public int delete(String id){
        SQLiteDatabase database = csdl112.getWritableDatabase();
        return database.delete("nhanvien","MaSV=?", new String[]{id});
    }

}
