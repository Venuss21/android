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

public class TruyenTranhTCAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<TruyenTranhTC> truyenTranhTCList;

    public TruyenTranhTCAdapter(Context context, int layout, List<TruyenTranhTC> truyenTranhTCList) {
        this.context = context;
        this.layout = layout;
        this.truyenTranhTCList = truyenTranhTCList;
    }

    @Override
    public int getCount() {
        return truyenTranhTCList.size();
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

        ImageView imageViewTruyenTranh = view.findViewById(R.id.imageTruyenTranh);
        TextView txtTenTruyenTranh = view.findViewById(R.id.txtTenTruyenTranh);


        //gan gia tri
        TruyenTranhTC truyenTranhTC = truyenTranhTCList.get(i);

        txtTenTruyenTranh.setText(truyenTranhTC.getTenTruyen().toString());

        String urlimg = truyenTranhTC.getImg();

        Picasso.with(context)
                .load(urlimg)
                .into(imageViewTruyenTranh);


        return view;
    }
}
