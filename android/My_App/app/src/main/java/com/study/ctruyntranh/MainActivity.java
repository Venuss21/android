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

public class MainActivity extends AppCompatActivity {

    String key_search;
    ImageView icon_search,icon_profile;
    EditText edt_search;



    GridView ttHanhDong,ttKinhDi,ttPhieuLuu,ttHai;

    //hanh dong
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




    LinearLayout view_more_danh_muc;



    LinearLayout view_more_danh_muc_hai,
            view_more_danh_muc_hanh_dong,
            view_more_danh_muc_kinh_di,
            view_more_danh_muc_phieu_luu;

    GridView gridView_anhmuctc;
    ArrayList<DanhMucTC> danhMucArrayList;
    Danh_muc_trang_chu_adapter danh_muc_trang_chu_adapter;


    public String urlGetData_Danh_muc = "http://172.20.10.2:3000/danhmuchome";
    public String urlGetData_truyen_hanh_dong = "http://172.20.10.2:3000/hanhdonghome";
    public String urlGetData_truyen_hai = "http://172.20.10.2:3000/haihome";
    public String urlGetData_truyen_phieu_luu = "http://172.20.10.2:3000/phieuluuhome";
    public String urlGetData_truyen_kinh_di = "http://172.20.10.2:3000/kinhdihome";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhxa();
        icon_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, ""+edt_search.getText().toString(), Toast.LENGTH_SHORT).show();
                openSearch();
            }
        });

        icon_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(MainActivity.this, ProfileActivity1.class);
                startActivity(a);
                finish();
 //               Toast.makeText(MainActivity.this, "Test event", Toast.LENGTH_SHORT).show();
            }
        });

        danh_muc_trang_chu_adapter = new Danh_muc_trang_chu_adapter(MainActivity.this,R.layout.danhmuc_trangchu,danhMucArrayList);
//        try {
//            Toast.makeText(this, danhMucArrayList.get(0).getTieuDe().toString(), Toast.LENGTH_SHORT).show();
//        }catch (Exception err){
//            Toast.makeText(this, "Lỗi", Toast.LENGTH_SHORT).show();
//        }
        gridView_anhmuctc.setAdapter(danh_muc_trang_chu_adapter);

        //get data danh muc
        getdata_danh_muc(urlGetData_Danh_muc);



        //get data truyen tranh hanh dong
        truyenTranhTCAdapter_hanh_dong = new TruyenTranhTCAdapter(MainActivity.this,R.layout.truyen_tranh_tc,truyenTranhTCArrayList_hanh_dong);
        ttHanhDong.setAdapter(truyenTranhTCAdapter_hanh_dong);
        getdata_hanh_dong(urlGetData_truyen_hanh_dong);


        //get truyen kinh di
        truyenTranhTCAdapter_kinh_di = new TruyenTranhTCAdapter(MainActivity.this,R.layout.truyen_tranh_tc,truyenTranhTCArrayList_kinh_di);
        ttKinhDi.setAdapter(truyenTranhTCAdapter_kinh_di);
        getdata_kinh_di(urlGetData_truyen_kinh_di);


        //get truyen hai
        truyenTranhTCAdapter_hai = new TruyenTranhTCAdapter(MainActivity.this,R.layout.truyen_tranh_tc,truyenTranhTCArrayList_hai);
        ttHai.setAdapter(truyenTranhTCAdapter_hai);
        getdata_hai(urlGetData_truyen_hai);


        //get truyen phieu luu
        truyenTranhTCAdapter_phieu_luu = new TruyenTranhTCAdapter(MainActivity.this,R.layout.truyen_tranh_tc,truyenTranhTCArrayList_phieu_luu);
        ttPhieuLuu.setAdapter(truyenTranhTCAdapter_phieu_luu);
        getdata_phieu_luu(urlGetData_truyen_phieu_luu);

        openActivityDanhMuc();
        openActivityChiTietDanhMuc();
        viewMore();

        openActivityChiTietTruyenTranh();


    }

    private void openSearch(){
        key_search = edt_search.getText().toString();
        if(!key_search.isEmpty()){
            Intent intent = new Intent(MainActivity.this,Search_Activity.class);
            intent.putExtra("key_search",key_search);
            startActivity(intent);
        }else {
            Toast.makeText(MainActivity.this, "Bạn chưa nhập cụm từ tìm kiếm !!", Toast.LENGTH_SHORT).show();
            edt_search.requestFocus();
        }
    }


    //get da ta hanh dong
    private void getdata_hanh_dong(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, urlGetData_truyen_hanh_dong, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //Toast.makeText(DanhMuc.this, response.toString(), Toast.LENGTH_SHORT).show();
//                        idid.setText(response.toString());
                        for(int i = 0; i < response.length(); i++){
                            try {
                                JSONObject object = response.getJSONObject(i);
                                truyenTranhTCArrayList_hanh_dong.add(new TruyenTranhTC(
                                        object.getString("_id"),
                                        object.getString("name"),
                                        object.getString("avatar")
                                ));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        truyenTranhTCAdapter_hanh_dong.notifyDataSetChanged();

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




    //get data hai
    private void getdata_hai(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, urlGetData_truyen_hai, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //Toast.makeText(DanhMuc.this, response.toString(), Toast.LENGTH_SHORT).show();
//                        idid.setText(response.toString());
                        for(int i = 0; i < response.length(); i++){
                            try {
                                JSONObject object = response.getJSONObject(i);
                                truyenTranhTCArrayList_hai.add(new TruyenTranhTC(
                                        object.getString("_id"),
                                        object.getString("name"),
                                        object.getString("avatar")
                                ));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        truyenTranhTCAdapter_hai.notifyDataSetChanged();

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


    //get da ta kinh di
    private void getdata_kinh_di(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, urlGetData_truyen_kinh_di, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //Toast.makeText(DanhMuc.this, response.toString(), Toast.LENGTH_SHORT).show();
//                        idid.setText(response.toString());
                        for(int i = 0; i < response.length(); i++){
                            try {
                                JSONObject object = response.getJSONObject(i);
                                truyenTranhTCArrayList_kinh_di.add(new TruyenTranhTC(
                                        object.getString("_id"),
                                        object.getString("name"),
                                        object.getString("avatar")
                                ));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        truyenTranhTCAdapter_kinh_di.notifyDataSetChanged();

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

    //get da ta hanh dong
    private void getdata_phieu_luu(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, urlGetData_truyen_phieu_luu, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //Toast.makeText(DanhMuc.this, response.toString(), Toast.LENGTH_SHORT).show();
//                        idid.setText(response.toString());
                        for(int i = 0; i < response.length(); i++){
                            try {
                                JSONObject object = response.getJSONObject(i);
                                truyenTranhTCArrayList_phieu_luu.add(new TruyenTranhTC(
                                        object.getString("_id"),
                                        object.getString("name"),
                                        object.getString("avatar")
                                ));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        truyenTranhTCAdapter_phieu_luu.notifyDataSetChanged();

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



    private void getdata_danh_muc(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, urlGetData_Danh_muc, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //Toast.makeText(DanhMuc.this, response.toString(), Toast.LENGTH_SHORT).show();
//                        idid.setText(response.toString());
                        for(int i = 0; i < response.length(); i++){
                            try {
                                JSONObject object = response.getJSONObject(i);
                                danhMucArrayList.add(new DanhMucTC(
                                        object.getString("_id"),
                                        object.getString("name"),
                                        object.getString("avatar")
                                ));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        danh_muc_trang_chu_adapter.notifyDataSetChanged();

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



    private void viewMore() {
        Intent intent = new Intent(MainActivity.this,ChiTietDanhMuc.class);




        view_more_danh_muc_phieu_luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ChiTietDanhMuc.class);

                String idDanhMuc = "6465eb5f1b95ce49dcb06a59";
                String tenDanhMuc = "Phiêu lưu";

                intent.putExtra("idDanhMuc",idDanhMuc);
                intent.putExtra("tenDanhMuc",tenDanhMuc);

                startActivity(intent);
            }
        });

        //hai

        view_more_danh_muc_hai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ChiTietDanhMuc.class);

                String idDanhMuc = "6465ebdd1b95ce49dcb06a61";
                String tenDanhMuc = "Hài";

                intent.putExtra("idDanhMuc",idDanhMuc);
                intent.putExtra("tenDanhMuc",tenDanhMuc);

                startActivity(intent);
            }
        });

        //hanh dong


        view_more_danh_muc_hanh_dong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ChiTietDanhMuc.class);

                String idDanhMuc = "6465e72ec893580b300130c3";
                String tenDanhMuc = "Hành động";

                intent.putExtra("idDanhMuc",idDanhMuc);
                intent.putExtra("tenDanhMuc",tenDanhMuc);

                startActivity(intent);
                Toast.makeText(MainActivity.this, "vao roi", Toast.LENGTH_SHORT).show();
            }
        });



        //nau nuong

        view_more_danh_muc_kinh_di.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ChiTietDanhMuc.class);

                String idDanhMuc = "6465eb1f1b95ce49dcb06a47";
                String tenDanhMuc = "Kinh dị";

                intent.putExtra("idDanhMuc",idDanhMuc);
                intent.putExtra("tenDanhMuc",tenDanhMuc);

                startActivity(intent);
            }
        });

    }

    private void openActivityDanhMuc(){
        view_more_danh_muc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten = new Intent(MainActivity.this,DanhMuc.class);
                startActivity(inten);
            }
        });


    }

    private void openActivityChiTietDanhMuc(){
        gridView_anhmuctc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,ChiTietDanhMuc.class);
                String idDanhMuc = danhMucArrayList.get(i).getId().toString();
                String tenDanhMuc = danhMucArrayList.get(i).getTieuDe().toString();
                intent.putExtra("idDanhMuc",idDanhMuc);
                intent.putExtra("tenDanhMuc",tenDanhMuc);
                startActivity(intent);
            }
        });
    }


    private void openActivityChiTietTruyenTranh(){

        //hanh dong
        ttHanhDong.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,ChiTietTruyenTranh.class);

                String idTruyen = truyenTranhTCArrayList_hanh_dong.get(i).getId().toString();
                String tenTruyen = truyenTranhTCArrayList_hanh_dong.get(i).getTenTruyen().toString();
                String avatar = truyenTranhTCArrayList_hanh_dong.get(i).getImg().toString();
                intent.putExtra("idTruyen",idTruyen);
                intent.putExtra("tenTruyen",tenTruyen);
                intent.putExtra("avatar",avatar);
                startActivity(intent);

            }
        });


        //kinh di

        ttKinhDi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,ChiTietTruyenTranh.class);

                String idTruyen = truyenTranhTCArrayList_kinh_di.get(i).getId().toString();
                String tenTruyen = truyenTranhTCArrayList_kinh_di.get(i).getTenTruyen().toString();
                String avatar = truyenTranhTCArrayList_kinh_di.get(i).getImg().toString();

                intent.putExtra("idTruyen",idTruyen);
                intent.putExtra("tenTruyen",tenTruyen);
                intent.putExtra("avatar",avatar);

                startActivity(intent);

            }
        });

        //truyen hai
        ttHai.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,ChiTietTruyenTranh.class);

                String idTruyen = truyenTranhTCArrayList_hai.get(i).getId().toString();
                String tenTruyen = truyenTranhTCArrayList_hai.get(i).getTenTruyen().toString();
                String avatar = truyenTranhTCArrayList_hai.get(i).getImg().toString();

                intent.putExtra("idTruyen",idTruyen);
                intent.putExtra("tenTruyen",tenTruyen);
                intent.putExtra("avatar",avatar);

                startActivity(intent);

            }
        });

        //phieu luu
        ttPhieuLuu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,ChiTietTruyenTranh.class);

                String idTruyen = truyenTranhTCArrayList_phieu_luu.get(i).getId().toString();
                String tenTruyen = truyenTranhTCArrayList_phieu_luu.get(i).getTenTruyen().toString();
                String avatar = truyenTranhTCArrayList_phieu_luu.get(i).getImg().toString();

                intent.putExtra("idTruyen",idTruyen);
                intent.putExtra("tenTruyen",tenTruyen);
                intent.putExtra("avatar",avatar);

                startActivity(intent);

            }
        });
    }

    private void anhxa() {

        edt_search                          = findViewById(R.id.edt_search);
        icon_search                         = findViewById(R.id.icon_search);
        icon_profile                        = findViewById(R.id.icon_profile);

        ttHanhDong                          = findViewById(R.id.gridviewHanhDongTrangChu);
        ttKinhDi                            = findViewById(R.id.gridviewKinhDiTrangChu);
        ttHai                               = findViewById(R.id.gridviewHaiTrangChu);
        ttPhieuLuu                          = findViewById(R.id.gridviewPhieuLuuTrangChu);
        view_more_danh_muc                  = findViewById(R.id.id_view_more_danh_muc);



        view_more_danh_muc_hai              = findViewById(R.id.viewmoreDanhMucTHaiC);

        view_more_danh_muc_hanh_dong        = findViewById(R.id.viewmoreDanhMucHanhDongTC);

        view_more_danh_muc_kinh_di          = findViewById(R.id.viewmoreDanhMucKinhDiTC);

        view_more_danh_muc_phieu_luu        = findViewById(R.id.viewmoreDanhMucPhieuLuuTC);

        gridView_anhmuctc = findViewById(R.id.gridviewDanhMuc_trang_chu);

        danhMucArrayList = new ArrayList<>();
//        danhMucArrayList.add(new DanhMucTC("id1","hanh dong","images/avatar_danh_muc/truyen_tranh_hanh_dong_.png"));
//        danhMucArrayList.add(new DanhMucTC("id1","hanh dong","images/avatar_danh_muc/truyen_tranh_hanh_dong_.png"));
//        danhMucArrayList.add(new DanhMucTC("id1","hanh dong","images/avatar_danh_muc/truyen_tranh_hanh_dong_.png"));
//        danhMucArrayList.add(new DanhMucTC("id1","hanh dong","images/avatar_danh_muc/truyen_tranh_hanh_dong_.png"));




//        truyenTranhTCArrayList.add(new TruyenTranhTC("Băng Hỏa Ma Trù",R.drawable.tt_bang_hoa_ma_truf,"phieuluu"));
//        truyenTranhTCArrayList.add(new TruyenTranhTC("Băng Hỏa Ma Trù",R.drawable.tt_bang_hoa_ma_truf,"phieuluu"));
//        truyenTranhTCArrayList.add(new TruyenTranhTC("Băng Hỏa Ma Trù",R.drawable.tt_bang_hoa_ma_truf,"phieuluu"));

    }
}