package com.t3h.chat;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtUser;
    private EditText edtPass;
    private Button btnRegRegister;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.register_activity);
        initView();
    }

    private void initView() {
        edtPass = findViewById(R.id.edt_user);
        edtPass = findViewById(R.id.edt_password);
        btnRegRegister = findViewById(R.id.btn_register_reg);
        btnRegRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent log = new Intent(this, LoginActivity.class);
    }
}
