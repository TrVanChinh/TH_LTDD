package com.example.thsqlite.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.thsqlite.Lop;
import com.example.thsqlite.R;
import com.example.thsqlite.SinhVien;

import java.util.List;

public class SinhVienAdapter extends BaseAdapter {
    private List<SinhVien> SinhVienList;
    private Context context;

    public SinhVienAdapter(Context context, List<SinhVien> SinhVienList){
        this.context = context;
        this.SinhVienList = SinhVienList;
    }

    @Override
    public int getCount() {
        return SinhVienList.size();
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
        ViewHolder viewHolder;
        if(view==null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_sinhvien,null);

            viewHolder.tvmsv = view.findViewById(R.id.tvmsv);
            viewHolder.tvTen = view.findViewById(R.id.tvTensv);
            viewHolder.tvmalophoc = view.findViewById(R.id.tvmalophoc);

            view.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) view.getTag();
        }
        SinhVien sv = SinhVienList.get(i);
        viewHolder.tvmsv.setText("Mã sinh viên: "+sv.getMsv());
        viewHolder.tvTen.setText("Tên: "+sv.getTensv());
        viewHolder.tvmalophoc.setText("Mã lớp: "+sv.getMalophoc());

        return view;
    }
    class ViewHolder{

        TextView tvmsv, tvTen, tvmalophoc;
    }
}

