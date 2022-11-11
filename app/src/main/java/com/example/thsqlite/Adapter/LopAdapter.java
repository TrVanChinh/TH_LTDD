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

public class LopAdapter extends BaseAdapter {
    private List<Lop> LopList;
    private Context context;

    public LopAdapter(Context context, List<Lop> listlop){
        this.context = context;
        this.LopList = listlop;
    }
    @Override
    public int getCount() {
        return LopList.size();
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
            view = inflater.inflate(R.layout.item_listview,null);

            viewHolder.tvMalop = view.findViewById(R.id.tvmalop);
            viewHolder.tvTenlop = view.findViewById(R.id.tvtenlop);
            viewHolder.tvSiSO = view.findViewById(R.id.tvsiso);

            view.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) view.getTag();
        }
        Lop lop = LopList.get(i);
        viewHolder.tvMalop.setText("Mã lớp: "+lop.getMalop());
        viewHolder.tvTenlop.setText("Tên lớp: "+lop.getTenlop());
        viewHolder.tvSiSO.setText("Sỉ số lớp: "+lop.getSiso());

        return view;
    }
    class ViewHolder{

        TextView tvMalop, tvTenlop, tvSiSO;
    }
}
