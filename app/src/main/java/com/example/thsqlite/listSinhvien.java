package com.example.thsqlite;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_sinhvien);

        lvSinhVien = findViewById(R.id.lvSinhVien);

        Intent intent = this.getIntent();
        String Malop = intent.getStringExtra("id");

        SinhVienList = new ArrayList<SinhVien>();
        SVdao = new SinhVienDao(listSinhvien.this);
        SinhVienList = SVdao.LoadDataSinhVien(Malop);

        SVadapter = new SinhVienAdapter(getApplicationContext(),SinhVienList);
        lvSinhVien.setAdapter(SVadapter);
        SuKien_ListView();

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
}