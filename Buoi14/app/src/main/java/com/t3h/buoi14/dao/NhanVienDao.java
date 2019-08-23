package com.t3h.buoi14.dao;

import androidx.room.*;
import com.t3h.buoi14.model.NhanVien;
import retrofit2.http.DELETE;

import java.util.List;

@Dao
public interface NhanVienDao {
    @Query("SELECT * FROM NhanVien")
    List<NhanVien> getNV();

    @Insert
    void insert(NhanVien nhanVien);
    @Update
    void update(NhanVien nhanVien);
    @Delete
    void  delete(NhanVien nhanVien);
}
