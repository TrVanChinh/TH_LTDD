package com.example.btpheptinh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TacGiaAdapter extends ArrayAdapter<TacGia> {
    public TacGiaAdapter(Context context, ArrayList<TacGia> gameArrayAdapter) {

        super(context, R.layout.item_tacgia, gameArrayAdapter);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        TacGia tacgia = getItem(position);

        if(view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.item_tacgia,parent,false);

        }

        TextView txtTenTacGiac = (TextView) view.findViewById(R.id.tvTen);
        TextView txtNamSinh = (TextView) view.findViewById(R.id.tvNamSinh);
        TextView txtMota = (TextView) view.findViewById(R.id.tvMoTa);
        ImageView imgTacGiac = (ImageView) view.findViewById(R.id.imgTacGia);


        txtTenTacGiac.setText(tacgia.getTenTacGia());
        txtMota.setText(tacgia.getMota());
        txtNamSinh.setText(tacgia.getNamSinh());
        imgTacGiac.setImageResource(tacgia.getHinhanh());


        return view;

    }
}
