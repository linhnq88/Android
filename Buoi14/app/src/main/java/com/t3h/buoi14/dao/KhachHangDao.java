package com.t3h.buoi14.dao;

import androidx.room.*;
import com.t3h.buoi14.model.KhachHang;

import java.util.List;

@Dao
public interface KhachHangDao {
    @Query("SELECT * FROM KhachHang")
    List<KhachHang> getKH();

    @Insert
    void insert(KhachHang khachHang);

    @Update
    void update(KhachHang khachHang);

    @Delete
    void delete(KhachHang khachHang);
}
