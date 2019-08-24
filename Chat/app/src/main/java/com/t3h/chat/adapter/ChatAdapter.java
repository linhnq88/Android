package com.t3h.chat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.t3h.chat.R;
import com.t3h.chat.api.ApiBuilder;
import com.t3h.chat.model.Chat;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatHolder> {

    private LayoutInflater inflater;
    private ArrayList<Chat> data;
    private ChatAdapter adapter;
    private String userName;

    public ChatAdapter(Context context){
        this.inflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<Chat> data) {
        this.data = data;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ChatHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =inflater.inflate(R.layout.item_view,parent,false);
        return new ChatHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatHolder holder, int position) {
        holder.binData(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class ChatHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private TextView tvDate;
        private TextView tvMess;
        public ChatHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvDate = itemView.findViewById(R.id.tv_date);
            tvMess = itemView.findViewById(R.id.tv_message);
        }

        public void binData(Chat chat){
            tvName.setText(chat.getUserName());
            tvDate.setText(chat.getDate());
            tvMess.setText(chat.getMessage());
        }
    }
}
