package com.study.ctruyntranh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

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

public class ChiTietDanhMuc extends AppCompatActivity {

    GridView Chi_tiet_danh_muc;
    ArrayList<TruyenTranhTC> truyenTranhTCArrayList_ct_dm; //ct: chi tieet, dm: danh muc
    Chi_tiet_danh_muc_adapter chi_tiet_danh_muc_adapter;
    String idDanhMuc,tenDanhMuc;
    String getDataUrl = "http://172.20.10.2:3000/";

    TextView txt_title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_danh_muc);

        anhxa();
        NhanIdDanhMuc();

        chi_tiet_danh_muc_adapter = new Chi_tiet_danh_muc_adapter(ChiTietDanhMuc.this,R.layout.truyen_tranh_tc,truyenTranhTCArrayList_ct_dm);
        Chi_tiet_danh_muc.setAdapter(chi_tiet_danh_muc_adapter);

        getdata(getDataUrl);


        Chi_tiet_danh_muc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String idTruyen = truyenTranhTCArrayList_ct_dm.get(i).getId().toString();
                String tenTruyen = truyenTranhTCArrayList_ct_dm.get(i).getTenTruyen();
                String avatar = truyenTranhTCArrayList_ct_dm.get(i).getImg().toString();
                OpenActivity(idTruyen,tenTruyen,avatar);
            }
        });



    }

    private void NhanIdDanhMuc(){
        Intent intent1 = getIntent();
        idDanhMuc = intent1.getStringExtra("idDanhMuc");
        tenDanhMuc = intent1.getStringExtra("tenDanhMuc");
        txt_title.setText(tenDanhMuc.toString());

        //gan lai duong link
        getDataUrl += idDanhMuc;


    }


    private void OpenActivity(String idTruyen, String tenTruyen,String avatar) {

        Intent intent = new Intent(ChiTietDanhMuc.this,ChiTietTruyenTranh.class);
        intent.putExtra("idTruyen",idTruyen);
        intent.putExtra("tenTruyen",tenTruyen);
        intent.putExtra("avatar",avatar);
        startActivity(intent);
    }


    private void getdata(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(ChiTietDanhMuc.this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //Toast.makeText(DanhMuc.this, response.toString(), Toast.LENGTH_SHORT).show();
//                        idid.setText(response.toString());
                        for(int i = 0; i < response.length(); i++){
                            try {
                                JSONObject object = response.getJSONObject(i);
                                truyenTranhTCArrayList_ct_dm.add(new TruyenTranhTC(
                                        object.getString("_id"),
                                        object.getString("name"),
                                        object.getString("avatar")
                                ));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        chi_tiet_danh_muc_adapter.notifyDataSetChanged();

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
        Chi_tiet_danh_muc            = findViewById(R.id.chi_tiet_danh_muc);
        txt_title                    = findViewById(R.id.chi_tiet_danh_muc_title);

        truyenTranhTCArrayList_ct_dm = new ArrayList<>();

    }
}