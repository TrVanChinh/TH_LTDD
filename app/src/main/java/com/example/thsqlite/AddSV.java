package com.example.thsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.thsqlite.dao.SinhVienDao;

public class AddSV extends AppCompatActivity {
    private EditText editTen, editNamSinh, editLop, editDiemToan, editDiemTin, editDiemAnh, editMSV;
    private Button Them, Thoat;
    private SinhVienDao svDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sv);
        svDAO = new SinhVienDao(AddSV.this);

        AnhXa();
        Them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SinhVien sv = new SinhVien();
                sv.setMsv(editMSV.getText().toString());
                sv.setTensv(editTen.getText().toString());
                sv.setTenLop(editLop.getText().toString());
                sv.setNamsinh(Integer.parseInt(editNamSinh.getText().toString()));
                sv.setDiemToan(Float.parseFloat(editDiemToan.getText().toString()));
                sv.setDiemTin(Float.parseFloat(editDiemTin.getText().toString()));
                sv.setDiemAnh(Float.parseFloat(editDiemAnh.getText().toString()));
                svDAO.ThemSinhVien(sv);
            }
        });

        Thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void AnhXa(){
        editMSV = (EditText) findViewById(R.id.edMsv);
        editTen = (EditText) findViewById(R.id.edTen);
        editNamSinh = (EditText) findViewById(R.id.edNamSinh);
        editLop = (EditText) findViewById(R.id.edLop);
        editDiemToan = (EditText) findViewById(R.id.edDiemToan);
        editDiemTin = (EditText) findViewById(R.id.edDiemTin);
        editDiemAnh = (EditText) findViewById(R.id.edDiemAnh);


        Them = (Button) findViewById(R.id.btnThem);
        Thoat = (Button) findViewById(R.id.btnThoat);
    }
}