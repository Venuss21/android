package com.study.ctruyntranh;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DanhMucTCAdapter extends BaseAdapter {

    private DanhMuc context;
    private int layout;
    private List<DanhMucTC> danhMucTCList;
    private MainActivity mainActivity;

    public DanhMucTCAdapter(int layout, List<DanhMucTC> danhMucTCList, MainActivity mainActivity) {
        this.layout = layout;
        this.danhMucTCList = danhMucTCList;
        this.mainActivity = mainActivity;
    }

    public DanhMucTCAdapter(DanhMuc context, int layout, List<DanhMucTC> danhMucTCList) {
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
        TextView txtTenDanhMuc = view.findViewById(R.id.tenDanhMuc);
        ImageView imageViewHinhAnhDanhMuc = view.findViewById(R.id.hinhAnhDanhMuc);
       ;

        //gan gia tri
        DanhMucTC danhMucTC = danhMucTCList.get(i);
        txtTenDanhMuc.setText(danhMucTC.getTieuDe().toString());


        String urlimg = danhMucTC.getImgTruyenTranh();

        Picasso.with(context)
                .load(urlimg)
                .into(imageViewHinhAnhDanhMuc);


        return view;
    }



}
