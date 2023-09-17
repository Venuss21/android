package com.study.ctruyntranh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class NoiDungTTAdapter extends BaseAdapter {

    NoiDungTruyenTranh context;
    int layout;
    List<DoiTuongNoiDungTT> doiTuongNoiDungTTList;

    public NoiDungTTAdapter(NoiDungTruyenTranh context, int layout, List<DoiTuongNoiDungTT> doiTuongNoiDungTTList) {
        this.context = context;
        this.layout = layout;
        this.doiTuongNoiDungTTList = doiTuongNoiDungTTList;
    }

    @Override
    public int getCount() {
        return doiTuongNoiDungTTList.size();
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

        ImageView imageView = view.findViewById(R.id.img_noi_dung_tt);
//        TextView txt = view.findViewById(R.id.idid1);

        DoiTuongNoiDungTT doiTuongNoiDungTT = doiTuongNoiDungTTList.get(i);

        String urlimg = doiTuongNoiDungTT.getImg().toString();

//        txt.setText(doiTuongNoiDungTT.getName().toString());

//        Toast.makeText(context, ""+urlimg, Toast.LENGTH_SHORT).show();

        Picasso.with(context)
                .load(urlimg)
                .into(imageView);

        return view;
    }


}
