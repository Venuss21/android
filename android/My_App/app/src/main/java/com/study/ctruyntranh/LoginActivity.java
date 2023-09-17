package com.study.ctruyntranh;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;


public class LoginActivity extends MainActivity {

    private EditText mEditTextUsername;
    private EditText mEditTextPassword;
    private Button mButtonLogin;
    public TextView dangKi,quenpass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        mEditTextUsername = findViewById(R.id.editTextUsername);
        mEditTextPassword = findViewById(R.id.editTextPassword);
        mButtonLogin = findViewById(R.id.buttonLogin);
        dangKi = findViewById(R.id.dangKi);
        quenpass = findViewById(R.id.quenpass);

        quenpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(LoginActivity.this, quenpass.class);
                startActivity(b);
                finish();
            }
        });

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = mEditTextUsername.getText().toString();
                String password = mEditTextPassword.getText().toString();
//
//                // Kiểm tra xem thông tin đăng nhập có hợp lệ không
                if (username.equals("admin") && password.equals("123456")) {
//                     //Thông tin đăng nhập hợp lệ, chuyển đến activity chính
//                    Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
//                     //Tạo Intent để chuyển đổi sang màn hình chính
//                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                    startActivity(intent);
//
//                     //Kết thúc hoạt động đăng nhập
//                    finish();

                } else {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);

                    //Kết thúc hoạt động đăng nhập
                    finish();
                    // Thông tin đăng nhập không hợp lệ
                    Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                }}

        });
        dangKi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(LoginActivity.this, Sign_inActivity.class);
                startActivity(b);
                finish();
            }
        });


    }
}

