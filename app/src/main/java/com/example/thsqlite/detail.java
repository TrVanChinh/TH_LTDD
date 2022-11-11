package com.example.thsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.thsqlite.dao.SinhVienDao;

public class detail extends AppCompatActivity {

    private EditText editTen, editNamSinh, editLop, editDiemToan, editDiemTin, editDiemAnh, editDiemTB;
    private Button Sua, Xoa, Thoat;
    private SinhVienDao svDAO;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        svDAO = new SinhVienDao(detail.this);
        Intent intent = getIntent();
        SinhVien sinhvien = (SinhVien) intent.getSerializableExtra("DULIEU");

        AnhXa();

        editTen.setText(sinhvien.getTensv());
        editNamSinh.setText(Integer.toString(sinhvien.getNamsinh()));
        editDiemToan.setText(Float.toString(sinhvien.getDiemToan()));
        editDiemTin.setText(Float.toString(sinhvien.getDiemTin()));
        editDiemAnh.setText(Float.toString(sinhvien.getDiemAnh()));
        editLop.setText(sinhvien.getTenLop());
        float dtb = (sinhvien.getDiemAnh() + sinhvien.getDiemToan() + sinhvien.getDiemTin())/3;
        editDiemTB.setText(Float.toString(dtb));



        Sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sinhvien.setTensv(editTen.getText().toString());
                sinhvien.setTenLop(editLop.getText().toString());
                sinhvien.setNamsinh(Integer.parseInt(editNamSinh.getText().toString()));
                sinhvien.setDiemToan(Float.parseFloat(editDiemToan.getText().toString()));
                sinhvien.setDiemTin(Float.parseFloat(editDiemTin.getText().toString()));
                sinhvien.setDiemAnh(Float.parseFloat(editDiemAnh.getText().toString()));
                svDAO.CapNhatSinhVien(sinhvien);
            }
        });

        Thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msv = new String(String.valueOf(sinhvien.getMsv()));
                svDAO.delete(msv);
                finish();
            }
        });
    }


    private void AnhXa(){
        editTen = (EditText) findViewById(R.id.edTen);
        editNamSinh = (EditText) findViewById(R.id.edNamSinh);
        editLop = (EditText) findViewById(R.id.edLop);
        editDiemToan = (EditText) findViewById(R.id.edDiemToan);
        editDiemTin = (EditText) findViewById(R.id.edDiemTin);
        editDiemAnh = (EditText) findViewById(R.id.edDiemAnh);
        editDiemTB = (EditText) findViewById(R.id.edMsv);

        Sua = (Button) findViewById(R.id.btnThem);
        Xoa = (Button) findViewById(R.id.btnXoa);
        Thoat = (Button) findViewById(R.id.btnThoat);
    }

}