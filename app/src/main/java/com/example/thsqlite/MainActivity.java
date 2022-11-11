package com.example.thsqlite;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.thsqlite.Adapter.LopAdapter;
import com.example.thsqlite.dao.LopDao;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvLop;
    private List<Lop> LopList;
    private LopAdapter adapter;
    private LopDao ldao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvLop = findViewById(R.id.lvLop);
        ldao = new LopDao(MainActivity.this);
        LopList = ldao.LoadData();

        adapter = new LopAdapter(getApplicationContext(),LopList);
        lvLop.setAdapter(adapter);

        SuKien_ListView();

    }

    private void SuKien_ListView() {
        lvLop.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Lop lop = (Lop) LopList.get(position);
                Intent intent = new Intent(MainActivity.this, listSinhvien.class);
                intent.putExtra("id", lop.getMalop());
                startActivity(intent);
            }
        });
    }

}