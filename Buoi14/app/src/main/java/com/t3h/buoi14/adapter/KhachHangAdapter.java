package com.t3h.buoi14.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.t3h.buoi14.model.NhanVien;

import java.util.List;

public class KhachHangAdapter extends RecyclerView.Adapter {

    private LayoutInflater inflater;
    private List<NhanVien> data;
    private imtemNhanVienListener listener;

    public KhachHangAdapter(Context context){
        this.inflater = LayoutInflater.from(context);
    }

    public void setInflater(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    public void setData(List<NhanVien> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void setListener(imtemNhanVienListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public interface imtemNhanVienListener{
        void onitemNVClick(int position);
    }
}
