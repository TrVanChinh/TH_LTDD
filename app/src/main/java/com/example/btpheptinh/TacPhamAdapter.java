package com.example.btpheptinh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TacPhamAdapter  extends BaseAdapter {
    private Context context;
    private int layout;
    private List<tacpham> tacphamList;

    public TacPhamAdapter(Context context, int layout, List<tacpham> tacphamList) {
        this.context = context;
        this.layout = layout;
        this.tacphamList = tacphamList;
    }

    @Override
    public int getCount() {
        return tacphamList.size();
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
    public View getView(int i, View view, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);

        TextView txtTenTacPham = (TextView) view.findViewById(R.id.tvTentacpham);
        TextView txtNamSangTac = (TextView) view.findViewById(R.id.tvNamSangTac);
        tacpham tp = tacphamList.get(i);
        txtTenTacPham.setText(tp.getTenTacPham());
        txtNamSangTac.setText(tp.getNamSangTac());

        return view;

    }
}
