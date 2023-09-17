package com.study.ctruyntranh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ProfileActivity1 extends AppCompatActivity {

    public ImageView backspace;
    public TextView dangxuat;
    public TextView readhis,profile,like,help;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile1);
        backspace   = findViewById(R.id.backsapce);
        dangxuat    = findViewById(R.id.dangxuat);
        readhis     = findViewById(R.id.readhis);
        profile     = findViewById(R.id.trangcanhan);
        like     = findViewById(R.id.like123);
        help     = findViewById(R.id.help123);

        readhis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(ProfileActivity1.this, History.class);
                startActivity(a);
                finish();
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(ProfileActivity1.this, Profile.class);
                startActivity(a);
                finish();
            }
        });
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(ProfileActivity1.this, Help.class);
                startActivity(a);
                finish();
            }
        });

        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(ProfileActivity1.this, Like.class);
                startActivity(a);
                finish();
            }
        });

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(ProfileActivity1.this, MainActivity.class);
                startActivity(b);
                finish();
            }
        });
        dangxuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(ProfileActivity1.this, LoginActivity.class);
                startActivity(a);
                finish();
            }
        });


    }


}