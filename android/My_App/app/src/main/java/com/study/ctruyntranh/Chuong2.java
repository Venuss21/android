package com.study.ctruyntranh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Chuong2 extends AppCompatActivity {

    public Button Chuong2truoc,Chuong2sau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chuong2);

        Chuong2sau = findViewById(R.id.chuong2sau);
        Chuong2truoc = findViewById(R.id.chuong2truoc);

        Chuong2truoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(Chuong2.this, Chuong1.class);
                startActivity(b);
                finish();
            }
        });

        Chuong2sau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(Chuong2.this, Chuong3.class);
                startActivity(a);
                finish();
            }
        });

    }
}