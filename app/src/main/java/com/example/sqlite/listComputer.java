package com.example.sqlite;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class listComputer extends AppCompatActivity {
    private ListView lvComputer;
    private ArrayAdapter<Computer> adapterCPT;
    private ArrayList<Computer> ComputerList = new ArrayList<>();
    SQLiteDatabase db =null;
    EditText editId, editName;
    Button Them, Xoa, sua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_computer);

        db = SQLiteDatabase.openOrCreateDatabase("/data/data/com.example.sqlite/databases/qlcomputer.db", null);
        lvComputer = findViewById(R.id.lvComputer);
        adapterCPT = new ArrayAdapter<Computer>(this, 0 , ComputerList){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                LayoutInflater inflater =(LayoutInflater)  getSystemService(LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.item_computer, null);

                TextView idcpt = convertView.findViewById(R.id.tvidcpt);
                TextView NameCPT = convertView.findViewById(R.id.tvNameCPT);
                TextView idCategory = convertView.findViewById(R.id.tvidCategory);
                editId = convertView.findViewById(R.id.edid);
                editName = convertView.findViewById(R.id.edName);
                Them = convertView.findViewById(R.id.btnThem);
                Xoa = convertView.findViewById(R.id.btnXoa);
                sua = convertView.findViewById(R.id.btnSua);

                Computer cpt = ComputerList.get(position);
                idcpt.setText(cpt.getIdcpt());
                NameCPT.setText(cpt.getNameCPT());
                idCategory.setText(cpt.getIdCategory());

                return convertView;
            }
        };

        lvComputer.setAdapter(adapterCPT);
        lvComputer.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                deleteComputer(position);
                return false;
            }
        });

        lvComputer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                showInfo(position);
            }
        });
        loadData();
    }
    public void loadData() {
        ComputerList.clear();
        Intent intent = this.getIntent();
        String Id = intent.getStringExtra("id");

        String sql = "SELECT * FROM tblComputer WHERE idCategory ='"+Id+ "'";

        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String idcpt = cursor.getString(0);
            String name = cursor.getString(1);
            String id = cursor.getString(2);

            Computer cpt = new Computer();
            cpt.setIdcpt(idcpt);
            cpt.setNameCPT(name);
            cpt.setIdCategory(id);

            ComputerList.add(cpt);

            cursor.moveToNext();
        }
        adapterCPT.notifyDataSetChanged();
    }

    private void deleteComputer(int position){
        Computer computer = (Computer) adapterCPT.getItem(position);
        String sql = "DELETE FROM tblComputer WHERE idcpt = '" + computer.getIdcpt()+"'";
    }

    private void showInfo(int position){
        Computer computer = listComputer.get(position);
        editId.setText(computer.getIdcpt());
        editId.setText(computer.getNameCPT());
    }

    private static Computer get(int position) {

    }
}