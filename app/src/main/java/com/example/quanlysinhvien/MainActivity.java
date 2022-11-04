package com.example.quanlysinhvien;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.quanlysinhvien.adapter.SinhVienAdapter;
import com.example.quanlysinhvien.dao.SinhVienDAO;
import com.example.quanlysinhvien.database.DBHelper;
import com.example.quanlysinhvien.model.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lvSinhVien112;
    private List<SinhVien> sinhVienList112;
    private SinhVienAdapter adapter112;
    private SinhVienDAO svDAO112;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvSinhVien112 = (ListView) findViewById(R.id.lv_sinhvien);


        sinhVienList112 = new ArrayList<SinhVien>();
        svDAO112 = new SinhVienDAO(MainActivity.this);
        sinhVienList112 = svDAO112.TatCaSinhVien();

        adapter112 = new SinhVienAdapter(getApplicationContext(),sinhVienList112);
        lvSinhVien112.setAdapter(adapter112);
        //sự kiện list view
        SuKien_ListView();


    }
    private void SuKien_ListView(){
        lvSinhVien112.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SinhVien sv = sinhVienList112.get(i);
                Intent intent = new Intent(MainActivity.this,EditActivity.class);
                intent.putExtra("DULIEU",sv);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_option,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.menu_them)
        {
            Intent intent = new Intent(MainActivity.this,AddActivity.class);
            startActivity(intent);
        }

        if(id ==R.id.menu_thoat){
            finish();
        }
        return true;
    }


    protected void onResume() {
        super.onResume();
        sinhVienList112.clear();
        sinhVienList112.addAll(svDAO112.TatCaSinhVien());
        adapter112.notifyDataSetChanged();
    }

}