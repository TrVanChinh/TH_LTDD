package com.example.btpheptinh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView lvTacGia;
    ArrayList<TacGia> arrayTacGia;
    TacGiaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//
        setContentView(R.layout.activity_main);

        AnhXa();


    }
    private void AnhXa(){
        lvTacGia = (ListView) findViewById(R.id.lvPhepToan);
        arrayTacGia = new ArrayList<>();

        String[] tenTacGia = {"Cù Huy Cận", " Mạc Ngôn", "William Shakespeare","Ernest Miller Hemingway","Tô Hoài"};
        String[] NgaySinh = {"22/1/1917","17/2/1955","23/4/1616","21/7/1899","27/9/1920"};
        String[] MoTa = {"Cù Huy Cận, bút danh hoạt động nghệ thuật là Huy Cận, là một chính khách, từng giữ nhiều chức vụ lãnh đạo cao cấp trong chính phủ Việt Nam","Mạc Ngôn là một nhà văn người Trung Quốc xuất thân từ nông dân. Ông đã từng được thế giới biết đến với tác phẩm Cao lương đỏ","là một nhà văn và nhà viết kịch Anh, được coi là nhà văn vĩ đại nhất của Anh và là nhà viết kịch đi trước thời đại.","là một tiểu thuyết gia người Mỹ, nhà văn viết truyện ngắn và là một nhà báo. Ông là một phần của cộng đồng những người xa xứ ở Paris trong thập niên 20 của thế kỷ XX","Tô Hoài là một nhà văn Việt Nam. Một số tác phẩm đề tài thiếu nhi của ông được dịch ra ngoại ngữ."};
        int[] hinhanh = {R.drawable.huycan,R.drawable.macngon,R.drawable.shakespeare,R.drawable.hemingway,R.drawable.img};
        for (int i = 0; i<tenTacGia.length;i++){
            TacGia tacGia = new TacGia(tenTacGia[i],NgaySinh[i],MoTa[i],hinhanh[i]);
            arrayTacGia.add(tacGia);
        }
        adapter = new TacGiaAdapter(MainActivity.this,arrayTacGia);
        lvTacGia.setAdapter(adapter);
        lvTacGia.setClickable(true);
        lvTacGia.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent id =new Intent(MainActivity.this,TacPhamActivity.class);
                id.putExtra("name",tenTacGia[i]);
                startActivity(id);
            }
        });
    }


}