package com.example.android1;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        //ánh xạ
        TextInputEditText edtUser = findViewById(R.id.edtUser);
        TextInputLayout txtUser = findViewById(R.id.txtUser);
        TextInputEditText edtPass = findViewById(R.id.edtPass);
        TextInputLayout txtPass = findViewById(R.id.txtPass);
        TextInputEditText edtRePass = findViewById(R.id.edtRePass);
        TextInputLayout txtRePass = findViewById(R.id.txtRePass);
        Button btnRegister = findViewById(R.id.btnRegister);
        Button btnBack = findViewById(R.id.btnBack);

        edtUser.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() ==0){
                    txtUser.setError("Vui Lòng Nhập Username");
                }else{
                    txtUser.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        edtPass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() ==0){
                    txtPass.setError("Vui Lòng Nhập Pass");
                }else{
                    txtPass.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        edtRePass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() ==0){
                    txtRePass.setError("Vui Lòng Nhập Lại Pass");
                }else{
                    txtRePass.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtUser.getText().toString();
                String pass = edtPass.getText().toString();
                String repass = edtRePass.getText().toString();

                //validate
                if (user.equals("")|| pass.equals("")|| repass.equals("")){
                    //            Toast.makeText(RegisterActivity.this, "Nhập Đầy Đủ Thông Tin", Toast.LENGTH_SHORT).show();
                    if (user.equals("")){
                        txtUser.setError("Vui Lòng Nhập Username");
                    }else {
                        txtUser.setError(null);
                    }
                    if (pass.equals("")){
                        txtPass.setError("Vui Lòng Nhập Pass");
                    }else{
                        txtPass.setError(null);
                    }
                    if (repass.equals("")){
                        txtRePass.setError("Vui Lòng Nhập Lại Pass");
                    }else{
                        txtRePass.setError(null);
                    }
                }else if (!pass.equals(repass)){
                    Toast.makeText(RegisterActivity.this, "Mật Khẩu Không Trùng Khớp", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent();
                    intent.putExtra("user", user);
                    intent.putExtra("pass", pass);
                    setResult(1, intent);
                    finish();
                }
            }
        });

    }
}