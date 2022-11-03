package com.example.sqlite;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase database;
    private ListView LvCategory;
    private ArrayAdapter<Category> adapter;

    private ArrayList<Category> listCategory = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        doCreateDB();
        doCreateCategoryTable();
        doCreateComputer();
        doInsertCategory();
        doInsertCPT();


        LvCategory = findViewById(R.id.lvCategory);
        adapter = new ArrayAdapter<Category>(this, 0 ,   listCategory){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                LayoutInflater inflater =(LayoutInflater)  getSystemService(LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.item_listcategory, null);

                TextView id = convertView.findViewById(R.id.tvid);
                TextView name = convertView.findViewById(R.id.tvNameCategory);
                TextView numbercpt = convertView.findViewById(R.id.tvnumbercpt);


                Category c = listCategory.get(position);
                id.setText(c.getId());
                name.setText(c.getNameCategory());
                numbercpt.setText(Integer.toString(c.getNumberCPT()));

                return convertView;
            }
        };

        LvCategory.setAdapter(adapter);
        loadData();
    }

    public void doCreateDB() {
        database = openOrCreateDatabase("qlcomputer.db", MODE_PRIVATE, null);
    }

    public void doCreateCategoryTable() {
        String sql = "CREATE TABLE IF NOT EXISTS tblcategory (";
        sql += "id TEXT PRIMARY KEY,";
        sql += "nameCategory TEXT,";
        sql += "numberCPT INTEGER)";
        database.execSQL(sql);
    }

    public void doCreateComputer() {
        String sql = "CREATE TABLE IF NOT EXISTS tblComputer (" +
                "idcpt TEXT PRIMARY KEY ," +
                "NameCPT TEXT, " +
                "idCategory TEXT NOT NULL CONSTRAINT idCategory " +
                " REFERENCES tblcategory(idCategory) ON DELETE CASCADE)";
        database.execSQL(sql);
    }

    public void doInsertCategory() {

        ContentValues values = new ContentValues();
        String msg = "";
        String sql = "INSERT INTO tblcategory (id, nameCategory, numberCPT) VALUES ('ctgr1','Phong thuc hanh 1',10),('ctgr2','Phong thuc hanh 2',12),('ctgr3','Phong thuc hanh 3',20) ";
        database.execSQL(sql);
        if (database.insert("tblcategory", null, values) == -1) {
            msg = "Failed to insert record";
        } else {
            msg = "insert record is successful";

        }
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();

    }

    public void doInsertCPT(){
        ContentValues values = new ContentValues();
        String sql = "INSERT INTO tblComputer (idcpt, NameCPT, idCategory) VALUES ('cpt01','Computer 1','ctgr1'),('cpt02','Computer 2','ctgr1'),('cpt03','Computer 1','ctgr2') ";
        database.execSQL(sql);

        String msg = "";
        if (database.insert("tblComputer", null, values) == -1) {
            msg = "Failed to insert record";
        } else {
            msg = "insert record is successful";
        }
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    public void loadData() {
        listCategory.clear();
        String sql = "SELECT * FROM tblcategory";
        Cursor cursor = database.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String id = cursor.getString(0);
            String nameCategory = cursor.getString(1);
            int numberCPT = cursor.getInt(2);

            Category c = new Category();
            c.setId(id);
            c.setNameCategory(nameCategory);
            c.setNumberCPT(numberCPT);

            listCategory.add(c);
            cursor.moveToNext();
        }
        adapter.notifyDataSetChanged();
        LvCategory.setAdapter(adapter);
        LvCategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Category category = (Category) adapter.getItem(position);
                Intent intent = new Intent();

                intent.putExtra("id", category.getId());
                intent.setClass(MainActivity.this, listComputer.class);
                startActivity(intent);
            }
        });
    }
}