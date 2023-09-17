package com.study.ctruyntranh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
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

import java.util.ArrayList;

public class NoiDungTruyenTranh extends AppCompatActivity {

    ListView listViewDoiTuongNoiDungTT;
    ArrayList<DoiTuongNoiDungTT> doiTuongNoiDungTTArrayList = new ArrayList<>();
    NoiDungTTAdapter noiDungTTAdapter;

    String idChuong,tenChuong,TenTruyen,getDataUrl = "http://192.168.1.91:3000/noidung/";
    String [] id_chuong; //chua cac id cac chuong
    String id_chuong_next,id_chuong_back;
    int len;

    TextView txt_ten_chuong;

    ImageView backChaper,nextChaper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noi_dung_truyen_tranh);

//        anhxa();
//
//        NhanIdTruyen();
//        noiDungTTAdapter = new NoiDungTTAdapter(NoiDungTruyenTranh.this,R.layout.dong_noi_dung_tt,doiTuongNoiDungTTArrayList);
//        listViewDoiTuongNoiDungTT.setAdapter(noiDungTTAdapter);
//        getdata(getDataUrl);
//
//        chapperAction();





    }

//    private void chapperAction() {
//        nextChaper.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                for (int i = 0; i < len; i++) {
//                    if(id_chuong[i].equalsIgnoreCase(idChuong) && id_chuong.length-1 != i){
//                        id_chuong_next = id_chuong[i+1].toString();
//                    }else if(i+1 == id_chuong.length){
//                        Toast.makeText(NoiDungTruyenTranh.this, "Bạn đã ở chương cuối !!", Toast.LENGTH_SHORT).show();
//                    }
//                }
//                if(id_chuong_next.length() != 0){
//                    Intent intent = new Intent(NoiDungTruyenTranh.this,NoiDungTruyenTranh.class);
//                    intent.putExtra("idChuong",id_chuong_next);
//                    intent.putExtra("TenTruyen",TenTruyen);
//                    intent.putExtra("id_chuong",id_chuong);
//                    intent.putExtra("tenChuong",tenChuong);
//                    intent.putExtra("len",len);
//                    startActivity(intent);
//                }
//            }
//        });
//
//        backChaper.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                for (int i = 0; i < len; i++) {
//                    if(id_chuong[i].equalsIgnoreCase(idChuong) && id_chuong.length-1 != i){
//                        id_chuong_back = id_chuong[i-1].toString();
//                    }else if(i+1 == 1){
//                        Toast.makeText(NoiDungTruyenTranh.this, "Bạn đã ở chương đầu !!", Toast.LENGTH_SHORT).show();
//                    }
//                }
//                if(id_chuong_next.length() != 0){
//                    Intent intent = new Intent(NoiDungTruyenTranh.this,NoiDungTruyenTranh.class);
//                    intent.putExtra("idChuong",id_chuong_back);
//                    intent.putExtra("TenTruyen",TenTruyen);
//                    intent.putExtra("id_chuong",id_chuong);
//                    intent.putExtra("tenChuong",tenChuong);
//                    intent.putExtra("len",len);
//                    startActivity(intent);
//                }
//            }
//        });
//    }


//    private void NhanIdTruyen(){
//        Intent intent = getIntent();
//        idChuong = intent.getStringExtra("idChuong");
//        TenTruyen = intent.getStringExtra("TenTruyen");
//        len = intent.getIntExtra("len",-1);
//
//        if(len > 0){
//            id_chuong = intent.getStringArrayExtra("id_chuong");
////            Toast.makeText(NoiDungTruyenTranh.this, " "+id_chuong.length, Toast.LENGTH_SHORT).show();
//        }
//
//        getDataUrl += idChuong;
//
//
//        //Toast.makeText(ChiTietTruyenTranh.this, getDataUrl, Toast.LENGTH_SHORT).show();
//
//
//    }

//    private void getdata(String url){
//        RequestQueue requestQueue = Volley.newRequestQueue(NoiDungTruyenTranh.this);
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
//                new Response.Listener<JSONArray>() {
//                    @Override
//                    public void onResponse(JSONArray response) {
//                        //Toast.makeText(DanhMuc.this, response.toString(), Toast.LENGTH_SHORT).show();
////                        idid.setText(response.toString());
//                        for(int i = 0; i < response.length(); i++){
//                            try {
//                                JSONObject object = response.getJSONObject(i);
//                                JSONArray imgArray = object.getJSONArray("imgnoidung");
//
//                                tenChuong = object.getString("name"); // lay ten chuong
//                                txt_ten_chuong.setText(tenChuong.toString());
//
//                                int len = imgArray.length();
////
////                                Toast.makeText(NoiDungTruyenTranh.this, ""+len, Toast.LENGTH_SHORT).show();
//
//                                for (int j = 0; j <= len; j++) {
////                                    JSONObject jsonObject = imgArray.getJSONObject(j);
////                                    Toast.makeText(NoiDungTruyenTranh.this, ""+imgArray.get(j), Toast.LENGTH_SHORT).show();
//
////                                    JSONObject jsonObject = imgArray.getJSONObject(j);
////                                    Toast.makeText(NoiDungTruyenTranh.this, ""+imgArray.get(j).toString(), Toast.LENGTH_SHORT).show();
//
//                                    doiTuongNoiDungTTArrayList.add(new DoiTuongNoiDungTT(
//                                        imgArray.getString(j).toString(),imgArray.getString(j).toString()
//                                    ));
//
//                                }
//                                String tam = doiTuongNoiDungTTArrayList.get(2).getImg();
//                                Toast.makeText(NoiDungTruyenTranh.this, ""+tam.toString(), Toast.LENGTH_SHORT).show();
//
//
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                        noiDungTTAdapter.notifyDataSetChanged();
//
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(NoiDungTruyenTranh.this, "chua vao", Toast.LENGTH_SHORT).show();
//
//
//                    }
//                }
//        );
//        requestQueue.add(jsonArrayRequest);
//
//
//    }

//    private void anhxa() {
//
//        backChaper = findViewById(R.id.back_chapter_nd_tt);
//        nextChaper = findViewById(R.id.next_chapter_nd_tt);
//        txt_ten_chuong = findViewById(R.id.ten_chuong_nd_tt);
//        listViewDoiTuongNoiDungTT = findViewById(R.id.listview_noi_dung_tt);
//


//        doiTuongNoiDungTTArrayList.add(new DoiTuongNoiDungTT(R.drawable.noi_dung_tt3));
//        doiTuongNoiDungTTArrayList.add(new DoiTuongNoiDungTT(R.drawable.noi_dung_tt2));
//        doiTuongNoiDungTTArrayList.add(new DoiTuongNoiDungTT(R.drawable.noi_dung_tt2));
//        doiTuongNoiDungTTArrayList.add(new DoiTuongNoiDungTT(R.drawable.noi_dung_tt2));
//
//        doiTuongNoiDungTTArrayList.add(new DoiTuongNoiDungTT(R.drawable.noi_dung_tt));
//        doiTuongNoiDungTTArrayList.add(new DoiTuongNoiDungTT(R.drawable.noi_dung_tt));
//        doiTuongNoiDungTTArrayList.add(new DoiTuongNoiDungTT(R.drawable.noi_dung_tt));
//        doiTuongNoiDungTTArrayList.add(new DoiTuongNoiDungTT(R.drawable.noi_dung_tt));
//        doiTuongNoiDungTTArrayList.add(new DoiTuongNoiDungTT(R.drawable.noi_dung_tt));
    }
