package com.example.tinhbmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText etCanNang, etChieuCao;
    private TextView tvKetqua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCanNang = findViewById(R.id.etCanNang);
        etChieuCao = findViewById(R.id.edtChieuCao);
        tvKetqua = findViewById(R.id.tvKetQua);
        findViewById(R.id.btnTinh).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        float chieucao =Float.parseFloat(etChieuCao.getText().toString());
        float cannang = Float.parseFloat(etCanNang.getText().toString());
        float ketqua = 0;
        if(view.getId() == R.id.btnTinh)
        {
            ketqua = cannang / (chieucao * chieucao);
            if(ketqua < 16 )
                tvKetqua.setText("BMI = "+ketqua+": Gầy độ III");
            else if (ketqua<17)
                tvKetqua.setText("BMI = "+ketqua+": Gầy độ II");
            else if (ketqua <18.5 )
                tvKetqua.setText("BMI = "+ketqua+": Gầy độ I");
            else if (ketqua <25 )
                tvKetqua.setText("BMI = "+ketqua+": Bình thường");
            else if (ketqua <30 )
                tvKetqua.setText("BMI = "+ketqua+": Thừa cân");
            else if (ketqua <35 )
                tvKetqua.setText("BMI = "+ketqua+": Béo phì độ I");
            else if (ketqua <40 )
                tvKetqua.setText("BMI = "+ketqua+": Béo phì II");
            else
                tvKetqua.setText("BMI = "+ketqua+": Béo phì III");
        }
    }
}