package com.example.thsqlite.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBhelper extends SQLiteOpenHelper {
    public DBhelper(@Nullable Context context) {
        super(context, "QLSinhVien.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlCreateLop = "CREATE TABLE IF NOT EXISTS  tbllop (";
        sqlCreateLop += "malop TEXT PRIMARY KEY ,";
        sqlCreateLop += "tenlop TEXT,";
        sqlCreateLop += "siso INTEGER)";
        sqLiteDatabase.execSQL(sqlCreateLop);

        String sqlCreateSinhVien = "CREATE TABLE IF NOT EXISTS tblsinhvien (" +
                "masv TEXT PRIMARY KEY ," +
                "tensv TEXT, " +
                "namsinh INTEGER, " +
                "DiemToan INTEGER, " +
                "DiemTin INTEGER, " +
                "DiemAnh INTEGER, " +
                "malop TEXT) ";
        sqLiteDatabase.execSQL(sqlCreateSinhVien);

        String sqlInsertLop ="INSERT INTO tbllop (malop, tenlop, siso) VALUES ('DHTH7C','Dai hoc 7C',30),('DHTH8C','Dai hoc 8C',40),('DHTH9C','Dai hoc 9C',50) ";
        String sqlInsertSinhVien ="INSERT INTO tblsinhvien (masv, tensv, namsinh,DiemToan, DiemTin, DiemAnh, malop) VALUES ('0112','Tran Van Chinh',2002, 9,9,9,'DHTH7C'),('0113','Le Quang Tu',2002, 8,8,8,'DHTH7C'),('0115','Le The Sinh',2002, 7,7,7,'DHTH7C') ";
        sqLiteDatabase.execSQL(sqlInsertLop);
        sqLiteDatabase.execSQL(sqlInsertSinhVien);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}