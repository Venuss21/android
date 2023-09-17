package com.study.ctruyntranh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Chuong1 extends AppCompatActivity {

    public Button Chuong1truoc,Chuong1sau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chuong1);

        Chuong1sau = findViewById(R.id.chuong1sau);


        Chuong1sau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent v = new Intent(Chuong1.this, Chuong2.class);
                startActivity(v);
                finish();
            }
        });
    }


}