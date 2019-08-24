package com.t3h.chat;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.t3h.chat.api.ApiBuilder;
import com.t3h.chat.untils.DialogUntils;

import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener, Callback<ResponseBody> {
    private EditText edtUser;
    private EditText edtPass;
    private Button btnRegRegister;
    private EditText edtName;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        initView();
    }

    private void initView() {
        edtUser = findViewById(R.id.edt_user_reg);
        edtPass = findViewById(R.id.edt_password_reg);
        edtName = findViewById(R.id.edt_name_reg);
        btnRegRegister = findViewById(R.id.btn_register_reg);
        btnRegRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String userName = edtUser.getText().toString();
        String password = edtPass.getText().toString();
        String name = edtName.getText().toString();
        if (userName.isEmpty() || password.isEmpty() || name.isEmpty()){
            Toast.makeText(this,"Data invalid",Toast.LENGTH_SHORT).show();
            return;
        }
        DialogUntils.showProgress(this);
        ApiBuilder.getInstance().register(userName,password,name).enqueue(this);
    }

    @Override
    public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
        DialogUntils.dismissProgress();
        if (response.code() == 200){
            finish();
        }else {
            Toast.makeText(this,"Register failed", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(Call<ResponseBody> call, Throwable t) {
        DialogUntils.dismissProgress();
        Toast.makeText(this,"Register failed", Toast.LENGTH_SHORT).show();
    }
}
