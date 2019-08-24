package com.t3h.chat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.t3h.chat.adapter.ChatAdapter;
import com.t3h.chat.api.ApiBuilder;
import com.t3h.chat.model.Chat;
import com.t3h.chat.model.User;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Callback<ResponseBody> {

    private User user;
    private ChatAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        user = (User) getIntent().getSerializableExtra(User.class.getName());
        Thread t = new Thread((Runnable) this);
        t.start();
    }

    private void initView() {

    }

    private void loadData(){
        ApiBuilder.getInstance().getChat().enqueue(new Callback<ArrayList<Chat>>() {
            @Override
            public void onResponse(Call<ArrayList<Chat>> call, Response<ArrayList<Chat>> response) {
                adapter.setData(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Chat>> call, Throwable t) {

            }
        });
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

    }

    @Override
    public void onFailure(Call<ResponseBody> call, Throwable t) {

    }
}
