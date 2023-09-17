package com.study.ctruyntranh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Danh_muc_trang_chu_adapter extends BaseAdapter {


    private MainActivity context;
    private int layout;
    private List<DanhMucTC> danhMucTCList;


    public Danh_muc_trang_chu_adapter(MainActivity context, int layout, List<DanhMucTC> danhMucTCList) {
        this.context = context;
        this.layout = layout;
        this.danhMucTCList = danhMucTCList;
    }

    @Override
    public int getCount() {
        return danhMucTCList.size();
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

        //anh xa
        TextView txtTenDanhMuc = view.findViewById(R.id.tenDanhMuc_trang_chu);
        ImageView imageViewHinhAnhDanhMuc = view.findViewById(R.id.hinhAnhDanhMuc_trang_chu);
        ;

        //gan gia tri
        DanhMucTC danhMucTC = danhMucTCList.get(i);
        txtTenDanhMuc.setText(danhMucTC.getTieuDe().toString());


        //Toast.makeText(context, danhMucTC.getImgTruyenTranh().toString(), Toast.LENGTH_SHORT).show();
        String urlimg = danhMucTC.getImgTruyenTranh();

        Picasso.with(context)
                .load(urlimg)
                .into(imageViewHinhAnhDanhMuc);


        return view;
    }



}
