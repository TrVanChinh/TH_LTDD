package com.example.btpheptinh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class TacPhamActivity extends AppCompatActivity {

    ListView lvTacPham;
    ArrayList<tacpham> tacphamArrayList;
    TacPhamAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tac_pham);

        AnhXa();

        adapter = new TacPhamAdapter(this, R.layout.item_tacpham, tacphamArrayList);
        lvTacPham.setAdapter(adapter);


    }

    private void AnhXa(){
        lvTacPham = (ListView) findViewById(R.id.lvTacPham);
        tacphamArrayList = new ArrayList<>();

        tacphamArrayList.add(new tacpham("Cù Huy Cận","Trời mỗi ngày lại sáng ","tập thơ, 1958"));
        tacphamArrayList.add(new tacpham("Cù Huy Cận","Đất nở hoa","tập thơ, 1960"));
        tacphamArrayList.add(new tacpham("Cù Huy Cận","Bài thơ cuộc đời","tập thơ, 1963"));
        tacphamArrayList.add(new tacpham(" Huy Cận","Bài thơ cuộc đời","tập thơ, 1963"));

    }
}