package com.study.ctruyntranh;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.content.Intent;

public class Sign_inActivity extends LoginActivity  {

    private EditText et_password, et_confirm_password,et_username,et_email,et_phone;
    private Button dangki;
    private ImageView backspace2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
        backspace2 = findViewById(R.id.quaylai);

        backspace2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(Sign_inActivity.this, LoginActivity.class);
                startActivity(c);
                finish();
            }
        });

    }
}
