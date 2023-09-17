package com.study.ctruyntranh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

public class ChiTietTruyenTranh extends AppCompatActivity {

    ListView listViewChuong;
    TextView Chuong1,Chuong2,Chuong3,Chuong4,Chuong5,Chuong6;
    ArrayList<ChuongTT> chuongTTArrayList;
    ChiTietTruyenTranhAdapter chiTietTruyenTranhAdapter;

    String getDataUrl = "http://172.20.10.2:3000/truyen/";
    String idTruyen,avatar,tenTruyen;

    TextView txt_title,txt_tong_so_chong;

    int chaper;
    String []id_Chuong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_truyen_tranh);

        anhxa();
        chiTietTruyenTranhAdapter = new ChiTietTruyenTranhAdapter(ChiTietTruyenTranh.this,R.layout.dong_chuong_tt,chuongTTArrayList);
//        listViewChuong.setAdapter(chiTietTruyenTranhAdapter);

        NhanIdTruyen();
//        Toast.makeText(ChiTietTruyenTranh.this, getDataUrl.toString(), Toast.LENGTH_SHORT).show();
//        getdata(getDataUrl);

        txt_title.setText(tenTruyen.toString());

        Chuong1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(ChiTietTruyenTranh.this, Chuong1.class);
                startActivity(a);
                finish();
            }
        });

        Chuong2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(ChiTietTruyenTranh.this, Chuong2.class);
                startActivity(a);
                finish();
            }
        });

        Chuong3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(ChiTietTruyenTranh.this, Chuong3.class);
                startActivity(a);
                finish();
            }
        });


//        listViewChuong.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String idChuong = chuongTTArrayList.get(i).getId().toString();
//                String TenTruyen = tenTruyen;
//                OpenActivityNoiDungTT(idChuong,TenTruyen);
//            }
//        });

    }

    private void NhanIdTruyen(){
        Intent intent = getIntent();
        idTruyen = intent.getStringExtra("idTruyen");
        tenTruyen = intent.getStringExtra("tenTruyen");
        avatar = intent.getStringExtra("avatar");
        getDataUrl += idTruyen;


        //Toast.makeText(ChiTietTruyenTranh.this, getDataUrl, Toast.LENGTH_SHORT).show();


    }

    private void OpenActivityNoiDungTT(String idChuong,String TenTruyen){
        Intent intent = new Intent(this,NoiDungTruyenTranh.class);
        intent.putExtra("idChuong",idChuong);
        intent.putExtra("TenTruyen",TenTruyen);
        intent.putExtra("id_chuong",id_Chuong);
        intent.putExtra("len",chaper);
        startActivity(intent);
    }


//    private void getdata(String url){
//        RequestQueue requestQueue = Volley.newRequestQueue(ChiTietTruyenTranh.this);
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
//                new Response.Listener<JSONArray>() {
//                    @Override
//                    public void onResponse(JSONArray response) {
//                        //Toast.makeText(DanhMuc.this, response.toString(), Toast.LENGTH_SHORT).show();
////                        idid.setText(response.toString());
//                        for(int i = 0; i < response.length(); i++){
//                            try {
//                                JSONObject object = response.getJSONObject(i);
//                                JSONArray chuongArrays = object.getJSONArray("chuongs");
//                                chaper = object.getInt("len");
//                                id_Chuong = new String[chaper];
//                                txt_tong_so_chong.setText(chaper+"");
////                                Toast.makeText(ChiTietTruyenTranh.this, chaper+"", Toast.LENGTH_SHORT).show();
//
//                                for (int j = 0; j < chaper; j++) {
//                                    JSONObject jsonObject = chuongArrays.getJSONObject(j);
//                                    id_Chuong[j] = jsonObject.getString("_id");
////                                    Toast.makeText(ChiTietTruyenTranh.this, ""+id_Chuong[j].toString(), Toast.LENGTH_SHORT).show();
//
//                                    chuongTTArrayList.add(new ChuongTT(
//                                            jsonObject.getString("_id"),
//                                            jsonObject.getString("name"),
//                                            jsonObject.getString("createdAt"),
//                                            tenTruyen,
//                                            idTruyen
//                                    ));
//
//                                }
//
//
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                        chiTietTruyenTranhAdapter.notifyDataSetChanged();
//
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
////                        Toast.makeText(DanhMuc.this, "chua vao", Toast.LENGTH_SHORT).show();
////                        idid.setText(error.toString());
//
//                    }
//                }
//        );
//        requestQueue.add(jsonArrayRequest);
//
//
//    }


    private void anhxa() {
//        listViewChuong = findViewById(R.id.listview_chuong_TT);
        txt_title = findViewById(R.id.title_chi_tiet_truyen_tranh);
        txt_tong_so_chong = findViewById(R.id.tong_so_chuong_TT);
        chuongTTArrayList = new ArrayList<>();
        Chuong1 = findViewById(R.id.Chuong1);
        Chuong2 = findViewById(R.id.Chuong2);
        Chuong3 = findViewById(R.id.Chuong3);

//        chuongTTArrayList.add(new ChuongTT("Chương 1","10/12/2016"));
//        chuongTTArrayList.add(new ChuongTT("Chương 2","10/12/2016"));
//        chuongTTArrayList.add(new ChuongTT("Chương 3","10/12/2016"));
//        chuongTTArrayList.add(new ChuongTT("Chương 4","10/12/2016"));
//        chuongTTArrayList.add(new ChuongTT("Chương 5","10/12/2016"));
//        chuongTTArrayList.add(new ChuongTT("Chương 6","10/12/2016"));
//        chuongTTArrayList.add(new ChuongTT("Chương 7","10/12/2016"));
//        chuongTTArrayList.add(new ChuongTT("Chương 8","10/12/2016"));
    }
}