package com.study.ctruyntranh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

public class History extends AppCompatActivity {

    public ImageView backspace2;

    GridView ttHanhDong,ttKinhDi,ttPhieuLuu,ttHai;

    TruyenTranhTCAdapter truyenTranhTCAdapter_hanh_dong;
    ArrayList<TruyenTranhTC> truyenTranhTCArrayList_hanh_dong = new ArrayList<>();

    //hai
    TruyenTranhTCAdapter truyenTranhTCAdapter_hai;
    ArrayList<TruyenTranhTC> truyenTranhTCArrayList_hai= new ArrayList<>();

    //nau nuong
    TruyenTranhTCAdapter truyenTranhTCAdapter_kinh_di;
    ArrayList<TruyenTranhTC> truyenTranhTCArrayList_kinh_di= new ArrayList<>();


    //phieu luu
    TruyenTranhTCAdapter truyenTranhTCAdapter_phieu_luu;
    ArrayList<TruyenTranhTC> truyenTranhTCArrayList_phieu_luu= new ArrayList<>();

    public String urlGetData_Danh_muc = "http://172.16.120.5:3000/danhmuchome";
    public String urlGetData_truyen_hanh_dong = "http://172.16.120.5:3000/hanhdonghome";
    public String urlGetData_truyen_hai = "http://172.16.120.5:3000/haihome";
    public String urlGetData_truyen_phieu_luu = "http://172.16.120.5:3000/phieuluuhome";
    public String urlGetData_truyen_kinh_di = "http://172.16.120.5:3000/kinhdihome";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.historyread);


        //ttHanhDong  = findViewById(R.id.gridviewHanhDongTrangChu);
        backspace2  = findViewById(R.id.quaylai1);



        backspace2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(History.this, ProfileActivity1.class);
                startActivity(c);
                finish();
            }
        });


//        private void getdata_hanh_dong(String url){
//            RequestQueue requestQueue = Volley.newRequestQueue(History.this);
//            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, urlGetData_truyen_hanh_dong, null,
//                    new Response.Listener<JSONArray>() {
//                        @Override
//                        public void onResponse(JSONArray response) {
//                            //Toast.makeText(DanhMuc.this, response.toString(), Toast.LENGTH_SHORT).show();
////                        idid.setText(response.toString());
//                            for(int i = 0; i < response.length(); i++){
//                                try {
//                                    JSONObject object = response.getJSONObject(i);
//                                    truyenTranhTCArrayList_hanh_dong.add(new TruyenTranhTC(
//                                            object.getString("_id"),
//                                            object.getString("name"),
//                                            object.getString("avatar")
//                                    ));
//                                } catch (JSONException e) {
//                                    e.printStackTrace();
//                                }
//                            }
//                            truyenTranhTCAdapter_hanh_dong.notifyDataSetChanged();
//
//                        }
//                    },
//                    new Response.ErrorListener() {
//                        @Override
//                        public void onErrorResponse(VolleyError error) {
////                        Toast.makeText(DanhMuc.this, "chua vao", Toast.LENGTH_SHORT).show();
////                        idid.setText(error.toString());
//
//                        }
//                    }
//            );
//            requestQueue.add(jsonArrayRequest);
//
//
//        }
//        private void anhxa() {
//
//
//
//
////            ttKinhDi                            = findViewById(R.id.gridviewKinhDiTrangChu);
////            ttHai                               = findViewById(R.id.gridviewHaiTrangChu);
////            ttPhieuLuu                          = findViewById(R.id.gridviewPhieuLuuTrangChu);
//
////        danhMucArrayList.add(new DanhMucTC("id1","hanh dong","images/avatar_danh_muc/truyen_tranh_hanh_dong_.png"));
////        danhMucArrayList.add(new DanhMucTC("id1","hanh dong","images/avatar_danh_muc/truyen_tranh_hanh_dong_.png"));
////        danhMucArrayList.add(new DanhMucTC("id1","hanh dong","images/avatar_danh_muc/truyen_tranh_hanh_dong_.png"));
////        danhMucArrayList.add(new DanhMucTC("id1","hanh dong","images/avatar_danh_muc/truyen_tranh_hanh_dong_.png"));
//
//
//
//
////        truyenTranhTCArrayList.add(new TruyenTranhTC("Băng Hỏa Ma Trù",R.drawable.tt_bang_hoa_ma_truf,"phieuluu"));
////        truyenTranhTCArrayList.add(new TruyenTranhTC("Băng Hỏa Ma Trù",R.drawable.tt_bang_hoa_ma_truf,"phieuluu"));
////        truyenTranhTCArrayList.add(new TruyenTranhTC("Băng Hỏa Ma Trù",R.drawable.tt_bang_hoa_ma_truf,"phieuluu"));
//
//        }
    }
}