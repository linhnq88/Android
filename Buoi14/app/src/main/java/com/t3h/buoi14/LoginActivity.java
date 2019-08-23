package com.t3h.buoi14;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtLogUser;
    private EditText edtLogPass;
    private Button btnLogin;
    private LinearLayout layout;
    private Animation rotate;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        edtLogUser = findViewById(R.id.login_user);
        edtLogPass = findViewById(R.id.login_pass);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(this);
        layout = findViewById(R.id.layout);
        rotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
    }

    @Override
    public void onClick(View v) {
        layout.startAnimation(rotate);
        final String userName = edtLogUser.getText().toString();
        final String pass = edtLogPass.getText().toString();
        if (userName.isEmpty() || pass.isEmpty()){
            Toast.makeText(this, "UserName or Pass not valid", Toast.LENGTH_SHORT).show();
            return;
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent main = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(main);
            }
        }).start();


    }
}
