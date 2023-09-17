package com.study.ctruyntranh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Help extends AppCompatActivity {

    public ImageView quaylai3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trogiup);

        quaylai3  = findViewById(R.id.quaylai300);

        quaylai3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(Help.this, ProfileActivity1.class);
                startActivity(c);
                finish();
            }
        });
    }
}