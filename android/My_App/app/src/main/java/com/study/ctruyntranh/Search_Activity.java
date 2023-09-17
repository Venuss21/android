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

public class Search_Activity extends AppCompatActivity {

    ListView listViewSearch;
    TextView txtSearch;

    ArrayList<Search_truyen_tranh_subject> search_truyen_tranh_subjectArrayList = new ArrayList<>();
    Search_adater search_adater;

    String key_search;
    String name_truyen[];
    String url = "http://192.168.2.26:3000/";
    int len; //do dai mang

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        anhxa();
        Nhan_key_search();
        search_adater = new Search_adater(Search_Activity.this,R.layout.dong_search,search_truyen_tranh_subjectArrayList);
        listViewSearch.setAdapter(search_adater);
        getdata_truyen(url);

        openActivityChiTietTruyenTranh();
    }

    private void openActivityChiTietTruyenTranh() {
        listViewSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Search_Activity.this,ChiTietTruyenTranh.class);

                String idTruyen = search_truyen_tranh_subjectArrayList.get(i).getId().toString();
                String tenTruyen = search_truyen_tranh_subjectArrayList.get(i).getName().toString();
                String avatar = search_truyen_tranh_subjectArrayList.get(i).getImg().toString();

                intent.putExtra("idTruyen",idTruyen);
                intent.putExtra("tenTruyen",tenTruyen);
                intent.putExtra("avatar",avatar);

                startActivity(intent);
            }
        });
    }

    private void Nhan_key_search(){
        Intent intent = getIntent();
        key_search = intent.getStringExtra("key_search");
        if(key_search.length() != 0){
            txtSearch.setText(key_search.toString());
        }

    }

    private void getdata_truyen(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(Search_Activity.this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //Toast.makeText(DanhMuc.this, response.toString(), Toast.LENGTH_SHORT).show();
//                        idid.setText(response.toString());
                        for(int i = 0; i < response.length(); i++){
                            try {
                                JSONObject object = response.getJSONObject(i);
                                String name = object.getString("name");
//                                Toast.makeText(Search_Activity.this, ""+i+" : "+name, Toast.LENGTH_SHORT).show();
                                if(key_search.trim().equalsIgnoreCase(object.getString("name").trim())){
//                                    Toast.makeText(Search_Activity.this, ""+object.getString("name"), Toast.LENGTH_SHORT).show();
                                    search_truyen_tranh_subjectArrayList.add(new Search_truyen_tranh_subject(
                                            object.getString("_id"),
                                            object.getString("name"),
                                            object.getString("avatar"),
                                            object.getString("createdAt"),
                                            object.getString("sochuong")

                                    ));
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        search_adater.notifyDataSetChanged();

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
        listViewSearch = findViewById(R.id.tt_search);
        txtSearch = findViewById(R.id.id_key_search);
    }
}