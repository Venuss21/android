package com.study.ctruyntranh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class DanhMuc extends AppCompatActivity {


    //ip : 192.168.0.103
    public String urlGetData = "http://172.20.10.2:3000/danhmuc";

    GridView gridViewDanhMuc;
    ArrayList<DanhMucTC> danhMucTCArrayList = new ArrayList<>();
    DanhMucTCAdapter danhMucTCAdapter;
    TextView titledanhmuc,idid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_muc);



        anhxa();
        getdata(urlGetData);

        danhMucTCAdapter = new DanhMucTCAdapter(DanhMuc.this,R.layout.danh_muc,danhMucTCArrayList);
        gridViewDanhMuc.setAdapter(danhMucTCAdapter);

        gridViewDanhMuc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String id = danhMucTCArrayList.get(i).getId().toString();
                String tenDanhMuc = danhMucTCArrayList.get(i).getTieuDe();
                OpenActivityChiTietDanhMuc(id,tenDanhMuc);
            }
        });


    }

    private void OpenActivityChiTietDanhMuc(String idDanhMuc, String tenDanhMuc) {
        Intent intent = new Intent(DanhMuc.this,ChiTietDanhMuc.class);
        intent.putExtra("idDanhMuc",idDanhMuc);
        intent.putExtra("tenDanhMuc",tenDanhMuc);
        startActivity(intent);
    }


    private void getdata(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(DanhMuc.this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //Toast.makeText(DanhMuc.this, response.toString(), Toast.LENGTH_SHORT).show();
//                        idid.setText(response.toString());
                        for(int i = 0; i < response.length(); i++){
                            //Toast.makeText(DanhMuc.this, ""+response.toString(), Toast.LENGTH_SHORT).show();
                            try {
                                JSONObject object = response.getJSONObject(i);
                                danhMucTCArrayList.add(new DanhMucTC(
                                        object.getString("_id"),
                                        object.getString("name"),
                                        object.getString("avatar")
                                ));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        danhMucTCAdapter.notifyDataSetChanged();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(DanhMuc.this, "chua vao", Toast.LENGTH_SHORT).show();
//                        idid.setText(error.toString());

                    }
                }
        );
        requestQueue.add(jsonArrayRequest);


    }

    private void anhxa() {

        gridViewDanhMuc = findViewById(R.id.gridviewDanhMuc);

        titledanhmuc = findViewById(R.id.title_danhmuc);

        danhMucTCArrayList = new ArrayList<>();

//        danhMucTCArrayList.add(new DanhMucTC("Hành động",R.drawable.truyen_tranh_hanh_dong_));
//        danhMucTCArrayList.add(new DanhMucTC("Nấu nướng",R.drawable.truyen_tranh_nau_nuong));
//        danhMucTCArrayList.add(new DanhMucTC("Hài",R.drawable.truyen_tranh_hai));
//        danhMucTCArrayList.add(new DanhMucTC("Phiêu lưu",R.drawable.truyen_tranh_phieu_luu));
//        danhMucTCArrayList.add(new DanhMucTC("Hành động",R.drawable.truyen_tranh_hanh_dong_));
//        danhMucTCArrayList.add(new DanhMucTC("Nấu nướng",R.drawable.truyen_tranh_nau_nuong));
//        danhMucTCArrayList.add(new DanhMucTC("Hài",R.drawable.truyen_tranh_hai));
//        danhMucTCArrayList.add(new DanhMucTC("Phiêu lưu",R.drawable.truyen_tranh_phieu_luu));
//        danhMucTCArrayList.add(new DanhMucTC("Hành động",R.drawable.truyen_tranh_hanh_dong_));
//        danhMucTCArrayList.add(new DanhMucTC("Nấu nướng",R.drawable.truyen_tranh_nau_nuong));
//        danhMucTCArrayList.add(new DanhMucTC("Hài",R.drawable.truyen_tranh_hai));
//        danhMucTCArrayList.add(new DanhMucTC("Phiêu lưu",R.drawable.truyen_tranh_phieu_luu));
//        danhMucTCArrayList.add(new DanhMucTC("Hành động",R.drawable.truyen_tranh_hanh_dong_));
//        danhMucTCArrayList.add(new DanhMucTC("Nấu nướng",R.drawable.truyen_tranh_nau_nuong));
//        danhMucTCArrayList.add(new DanhMucTC("Hài",R.drawable.truyen_tranh_hai));
//        danhMucTCArrayList.add(new DanhMucTC("Phiêu lưu",R.drawable.truyen_tranh_phieu_luu));

    }
}