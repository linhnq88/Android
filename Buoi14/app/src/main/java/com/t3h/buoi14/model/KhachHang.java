package com.t3h.buoi14.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity
public class KhachHang {
    @ColumnInfo
    private String ma;
    @ColumnInfo
    private String name;
    @ColumnInfo
    private String date;
    @ColumnInfo
    private String email;
    @ColumnInfo
    private String phone;
    @ColumnInfo
    private String coQuan;
    @ColumnInfo
    private String chucVu;
    @ColumnInfo
    private String address;
    @ColumnInfo
    private String loaiKH;

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCoQuan() {
        return coQuan;
    }

    public void setCoQuan(String coQuan) {
        this.coQuan = coQuan;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLoaiKH() {
        return loaiKH;
    }

    public void setLoaiKH(String loaiKH) {
        this.loaiKH = loaiKH;
    }
}
