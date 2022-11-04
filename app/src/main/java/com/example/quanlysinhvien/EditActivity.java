package com.example.quanlysinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.quanlysinhvien.dao.SinhVienDAO;
import com.example.quanlysinhvien.model.SinhVien;

public class EditActivity extends AppCompatActivity {

    private EditText edtHoTen112, edtEmail112, edtDienThoai112;
    private RadioGroup rgGioiTinh112;
    private RadioButton rbNam112, rbNu112;
    private Button btnLuu112, btnThoat112, btnXoa112;
    private SinhVienDAO svDAO112;
    int gioitinh112;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        svDAO112 = new SinhVienDAO(EditActivity.this);
        Intent intent = getIntent();
        SinhVien sinhvien = (SinhVien) intent.getSerializableExtra("DULIEU");

        AnhXa();

        edtHoTen112.setText(sinhvien.getHoTen());
        edtEmail112.setText(sinhvien.getEmail());
        edtDienThoai112.setText(sinhvien.getDienThoai());

        if(sinhvien.getGioiTinh()==1) {
            rbNam112.setChecked(true);
            gioitinh112 = 1;
        }else {
            rbNu112.setChecked(true);
            gioitinh112 = 0;
        }
        btnThoat112.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        rgGioiTinh112.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.rb_nam)
                    gioitinh112 = 1;
                else
                    gioitinh112 = 0;
            }
        });
        btnLuu112.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sinhvien.setHoTen(edtHoTen112.getText().toString());
                sinhvien.setEmail(edtEmail112.getText().toString());
                sinhvien.setDienThoai(edtDienThoai112.getText().toString());
                sinhvien.setGioiTinh(gioitinh112);
                svDAO112.CapNhatSinhVien(sinhvien);
            }
        });

        btnXoa112.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    private void AnhXa(){
        edtHoTen112 = (EditText) findViewById(R.id.edt_hoten);
        edtEmail112 = (EditText) findViewById(R.id.edt_email);
        edtDienThoai112 = (EditText) findViewById(R.id.edt_dienthoai);
        rgGioiTinh112 = (RadioGroup) findViewById(R.id.rg_gioitinh);
        rbNam112 = (RadioButton) findViewById(R.id.rb_nam);
        rbNu112 = (RadioButton) findViewById(R.id.rb_nu);
        btnLuu112 = (Button) findViewById(R.id.btn_luu);
        btnThoat112 = (Button) findViewById(R.id.btn_thoat);
        btnXoa112= (Button) findViewById(R.id.btn_Xoa);
    }
}