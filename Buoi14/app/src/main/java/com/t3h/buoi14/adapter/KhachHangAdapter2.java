package com.t3h.buoi14.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.t3h.buoi14.R;
import com.t3h.buoi14.model.KhachHang;

import java.util.List;

public class KhachHangAdapter2 extends BaseAdapter {

    Context myContext;
    int myLayout;
    List<KhachHang> arrKH;

    public KhachHangAdapter2(Context myContext, int myLayout, List<KhachHang> arrKH) {
        this.myContext = myContext;
        this.myLayout = myLayout;
        this.arrKH = arrKH;
    }

    @Override
    public int getCount() {
        return arrKH.size();
    }

    @Override
    public Object getItem(int i) {
        return arrKH.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    class ViewHolder{
        TextView txtMa, txtTen;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowview = view;
        ViewHolder holder = new ViewHolder();
        if (rowview == null){
            rowview = inflater.inflate(myLayout, null);
            holder.txtMa = (TextView) rowview.findViewById(R.id.tv_ma);
            holder.txtTen = (TextView) rowview.findViewById(R.id.tv_ten);
            rowview.setTag(holder);
        }else {
            holder = (ViewHolder) rowview.getTag();
        }
        holder.txtMa.setText(arrKH.get(i).getMa());
        holder.txtTen.setText(arrKH.get(i).getName());

        return null;
    }
}
