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
import com.t3h.chat.model.User;
import com.t3h.chat.untils.DialogUntils;
import com.t3h.chat.untils.ShareUntils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, Callback<User> {
    private EditText edtUser;
    private EditText edtPass;
    private Button btnLogin;
    private Button btnRegister;
    private ShareUntils shareUntils;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        initView();
        shareUntils = new ShareUntils(this);

    }

    private void initView() {
        edtUser = findViewById(R.id.edt_user_log);
        edtPass = findViewById(R.id.edt_password_log);
        btnLogin = findViewById(R.id.btn_login_log);
        btnRegister = findViewById(R.id.btn_register_log);
        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login_log:
                String userName = edtUser.getText().toString();
                String password = edtPass.getText().toString();
                if (userName.isEmpty() || password.isEmpty()) {
                    Toast.makeText(this, "Data is valid", Toast.LENGTH_SHORT).show();
                    return;
                }
                DialogUntils.showProgress(this);
                ApiBuilder.getInstance().login(userName, password).enqueue(this);
                break;
            case R.id.btn_register_log:
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onResponse(Call<User> call, Response<User> response) {
        DialogUntils.dismissProgress();
        if (response.code() == 200){
            finish();
        }else {
            Toast.makeText(this,"Register fialed",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(Call<User> call, Throwable t) {
        DialogUntils.dismissProgress();
        Toast.makeText(this,"Register fialed",Toast.LENGTH_SHORT).show();
    }
}
