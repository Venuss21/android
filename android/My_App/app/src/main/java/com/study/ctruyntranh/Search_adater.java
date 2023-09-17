package com.study.ctruyntranh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Search_adater extends BaseAdapter {

    Context context;
    int layout;
    List<Search_truyen_tranh_subject> search_truyen_tranh_subjectList;

    public Search_adater(Context context, int layout, List<Search_truyen_tranh_subject> search_truyen_tranh_subjectList) {
        this.context = context;
        this.layout = layout;
        this.search_truyen_tranh_subjectList = search_truyen_tranh_subjectList;
    }

    @Override
    public int getCount() {
        return search_truyen_tranh_subjectList.size();
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

        // anh xa

        ImageView imageViewTruyenTranh = view.findViewById(R.id.imageTruyenTranh_search);
        TextView txtTenTruyenTranh = view.findViewById(R.id.txtTenTruyenTranh_search);
        TextView txtThoiGian = view.findViewById(R.id.txtNgayDangTruyenTranh_search);
        TextView txtTongChuong = view.findViewById(R.id.txtTongSoChuong_search);


        //gan gia tri
        Search_truyen_tranh_subject search_truyen_tranh_subject = search_truyen_tranh_subjectList.get(i);

        txtTenTruyenTranh.setText(search_truyen_tranh_subject.getName().toString());
        txtThoiGian.setText(search_truyen_tranh_subject.getThoiGian().toString());
        txtTongChuong.setText("Tổng số chương : "+ search_truyen_tranh_subject.getTongChuong().toString());

        String urlimg = search_truyen_tranh_subject.getImg();

        Picasso.with(context)
                .load(urlimg)
                .into(imageViewTruyenTranh);
        return view;
    }
}
