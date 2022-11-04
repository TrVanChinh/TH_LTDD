package com.example.quanlysinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.quanlysinhvien.dao.SinhVienDAO;
import com.example.quanlysinhvien.model.SinhVien;

public class AddActivity extends AppCompatActivity {
    EditText edtHoTen112, editEmail112, edtDienThoai112;
    RadioGroup rgGioiTinh112;
    Button btnThem112, btnThoat112;
    private int gioitinh112 = 1;
    SinhVienDAO svDao112;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        AnhXa();
        svDao112 = new SinhVienDAO(AddActivity.this);
        rgGioiTinh112.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.rb_nam)
                    gioitinh112 = 1;
                else
                    gioitinh112 = 0;
            }
        });

        btnThem112.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hoten = edtHoTen112.getText().toString();
                String email = editEmail112.getText().toString();
                String dienthoai = edtDienThoai112.getText().toString();
                SinhVien sv = new SinhVien(hoten,gioitinh112,dienthoai,email);
                svDao112.ThemSinhVien(sv);
            }
        });

        btnThoat112.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void AnhXa(){
        edtHoTen112 = (EditText) findViewById(R.id.edt_hoten);
        editEmail112 = (EditText) findViewById(R.id.edt_email);
        edtDienThoai112 = (EditText) findViewById(R.id.edt_dienthoai);
        rgGioiTinh112 = (RadioGroup) findViewById(R.id.rg_gioitinh);
        btnThem112 = (Button) findViewById(R.id.btn_them);
        btnThoat112 = (Button) findViewById(R.id.btn_thoat);

    }
}