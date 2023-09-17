package com.study.ctruyntranh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class ChiTietTruyenTranhAdapter extends BaseAdapter {

    Context context;
    int layout;
    List<ChuongTT> chuongTTList;

    public ChiTietTruyenTranhAdapter(Context context, int layout, List<ChuongTT> chuongTTList) {
        this.context = context;
        this.layout = layout;
        this.chuongTTList = chuongTTList;
    }

    @Override
    public int getCount() {
        return chuongTTList.size();
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
        view = inflater.inflate(layout,null);

        TextView txtTenChuong = view.findViewById(R.id.ten_chuong);
        TextView txtThoiGian = view.findViewById(R.id.thoi_gian);

        ChuongTT chuongTT = chuongTTList.get(i);

        txtTenChuong.setText(chuongTT.getTenChuong().toString());
        txtThoiGian.setText(chuongTT.getThoiGian().toString());
        return view;
    }
}
