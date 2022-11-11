package com.example.thsqlite.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.thsqlite.Lop;
import com.example.thsqlite.database.DBhelper;

import java.util.ArrayList;
import java.util.List;

public class LopDao {
    private List<Lop> LopList;
    private DBhelper csdl;

    public LopDao(Context context) {

        csdl = new DBhelper(context);
    }

    public List<Lop> LoadData() {

        String sql = "SELECT * FROM tbllop";
        List<Lop>  LopList = new ArrayList<Lop>();
        SQLiteDatabase database = csdl.getReadableDatabase();
        Cursor cursor = database.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String malop = cursor.getString(0);
            String tenlop = cursor.getString(1);
            int siso = cursor.getInt(2);
            Lop l =new Lop(malop,tenlop,siso);
            LopList.add(l);

            cursor.moveToNext();
        }
        return LopList;
    }
}
