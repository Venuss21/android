package com.study.ctruyntranh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Profile extends AppCompatActivity {

    public ImageView backspace2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trangcanhan);

        backspace2  = findViewById(R.id.quaylai2);

        backspace2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(Profile.this, ProfileActivity1.class);
                startActivity(c);
                finish();
            }
        });
    }
}