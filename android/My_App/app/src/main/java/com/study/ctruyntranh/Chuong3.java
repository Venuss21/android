package com.study.ctruyntranh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Chuong3 extends AppCompatActivity {

    public Button Chuong3truoc,Chuong3sau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chuong3);

        Chuong3sau = findViewById(R.id.chuong3sau);
        Chuong3truoc = findViewById(R.id.chuong3truoc);

        Chuong3truoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(Chuong3.this, Chuong2.class);
                startActivity(c);
                finish();
            }
        });

//        Chuong3sau.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent a = new Intent(Chuong3.this, Chuong4.class);
//                startActivity(a);
//                finish();
//            }
//        });

    }
}