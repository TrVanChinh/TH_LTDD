package com.example.profile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class gameAdapter extends BaseAdapter{
    private Context context;
    private int layout;
    private List<game> listgame;

    public gameAdapter(Context context, int layout, List<game> listgame) {
        this.context = context;
        this.layout = layout;
        this.listgame = listgame;
    }

    @Override
    public int getCount() {
        return listgame.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);
        TextView txtTen = (TextView) view.findViewById(R.id.tvTen);
        TextView txtMota = (TextView) view.findViewById(R.id.tvmota);
        TextView txtDanhGia = (TextView) view.findViewById(R.id.tvDanhGia);
        TextView txtDungluong = (TextView) view.findViewById(R.id.tvdungluong);
        ImageView imgStar = (ImageView) view.findViewById(R.id.imgSao);
        ImageView imgAnh = (ImageView) view.findViewById(R.id.logogame);
        TextView stt = (TextView) view.findViewById(R.id.tvStt);

        game game = listgame.get(i);

        txtTen.setText(game.getTen());
        txtMota.setText(game.getMota());
        txtDanhGia.setText(game.getDanhgia());
        txtDungluong.setText(game.getDungluong());
        imgStar.setImageResource(game.getStar());
        imgAnh.setImageResource(game.getHinh());
        stt.setText(game.getStt());

        return view;
    }
}

