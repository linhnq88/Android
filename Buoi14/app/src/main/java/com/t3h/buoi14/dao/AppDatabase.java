package com.t3h.buoi14.dao;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;

public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase database;

    public static AppDatabase getInstance(Context context){
        if (database == null){
            database = Room.databaseBuilder(
                    context,
                    AppDatabase.class,
                    "linhnq"
            )
                    .allowMainThreadQueries()
                    .build();
        }
        return database;
    }
    public abstract KhachHangDao getKHDao();
    public abstract NhanVienDao getNVDao();


}
