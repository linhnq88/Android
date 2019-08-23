package com.t3h.buoi14;

import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.t3h.buoi14.sql.SQLite;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnRotate;
    private Button btnSet;
    private Button btnLogin;

    private Animation rotate;
    private Animation set;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //SQLite db = new SQLite(this, "Linh.sqlite", null, 1);

        //tao bang
        //db.queryData("CREATE TABLE IF NOT EXISTS KhachHang(Ma VARCHAR, Ten VARCHAR, Date VARCHAR, Email VARCHAR, Sdt VARCHAR, CoQuan VARCHAR, ChucVu VARCHAR, Address VARCHAR, LoaiKH VARCHAR)");
        //
        //db.queryData("INSERT INTO KhachHang VALUES('1','Linh','12/07/1999','nquanglinh99@gmail.com','0123456789','ABC','DEF','Hà Nội','Không tiềm năng')");

        //Cursor cursorCT = db.getData("SELECT * FROM KhachHang");
    }




    @Override
    public void onClick(View v) {

    }
}
