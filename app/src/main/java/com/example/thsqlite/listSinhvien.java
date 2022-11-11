package com.example.thsqlite;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import com.example.thsqlite.Adapter.SinhVienAdapter;
import com.example.thsqlite.dao.SinhVienDao;

import java.util.ArrayList;
import java.util.List;

public class listSinhvien extends AppCompatActivity {
    private ListView lvSinhVien;
    private List<SinhVien> SinhVienList;
    private SinhVienAdapter SVadapter;
    private SinhVienDao SVdao;
    private Button btnThem;


    private String Tenlop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_sinhvien);

        lvSinhVien = findViewById(R.id.lvSinhVien);
        btnThem = findViewById(R.id.buttonThem);
        Intent intent = this.getIntent();
        Tenlop = intent.getStringExtra("id");


        SinhVienList = new ArrayList<SinhVien>();
        SVdao = new SinhVienDao(listSinhvien.this);
        SinhVienList = SVdao.LoadDataSinhVien(Tenlop);

        SVadapter = new SinhVienAdapter(getApplicationContext(),SinhVienList);
        lvSinhVien.setAdapter(SVadapter);
        SuKien_ListView();

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(listSinhvien.this, AddSV.class);
                startActivity(intent);
            }
        });

    }
    private void SuKien_ListView(){
        lvSinhVien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                SinhVien sv = SinhVienList.get(i);
                Intent intent = new Intent(listSinhvien.this, detail.class);
                intent.putExtra("DULIEU",sv);
                startActivity(intent);
            }
        });

    }

    protected void onResume() {
        super.onResume();
        SinhVienList.clear();
        SinhVienList.addAll(SVdao.LoadDataSinhVien(Tenlop));
        SVadapter.notifyDataSetChanged();
    }
}