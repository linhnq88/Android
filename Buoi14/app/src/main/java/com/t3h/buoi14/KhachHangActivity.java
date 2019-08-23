package com.t3h.buoi14;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.t3h.buoi14.dao.AppDatabase;
import com.t3h.buoi14.model.KhachHang;

public class KhachHangActivity extends AppCompatActivity {
    private EditText edtMa, edtName, edtDate, edtSdt, edtAddress, edtMail, edtCoQuan, edtChucVu, edtLoaiKH;

    private static final String EXTRA_KH = "extra_kh";
    private KhachHang khachHang;

    public static Intent newIntstance(Context context, KhachHang khachHang) {
        Intent intent = new Intent(context, KhachHangActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);
        initView();
    }

    private void initView() {
        edtMa = findViewById(R.id.edt_ma);
        edtName = findViewById(R.id.edt_ten);
        edtDate = findViewById(R.id.edt_date);
        edtSdt = findViewById(R.id.edt_sdt);
        edtAddress = findViewById(R.id.edt_address);
        edtMail = findViewById(R.id.edt_mail);
        edtCoQuan = findViewById(R.id.edt_coQuan);
        edtChucVu = findViewById(R.id.edt_chucVu);
        edtLoaiKH = findViewById(R.id.edt_loaiKH);

        khachHang = (KhachHang) getIntent().getSerializableExtra(EXTRA_KH);

        if (khachHang != null) {
            edtMa.setText(khachHang.getMa());
            edtName.setText(khachHang.getName());
            edtDate.setText(khachHang.getDate());
            edtAddress.setText(khachHang.getAddress());
            edtChucVu.setText(khachHang.getChucVu());
            edtCoQuan.setText(khachHang.getCoQuan());
            edtSdt.setText(khachHang.getPhone());
            edtMail.setText(khachHang.getEmail());
            edtLoaiKH.setText(khachHang.getLoaiKH());
        }

    }

    private void saveKH() {
        String ma = edtMa.getText().toString();
        String ten = edtName.getText().toString();
        String sdt = edtSdt.getText().toString();
        String date = edtDate.getText().toString();
        String address = edtAddress.getText().toString();
        String chucVu = edtChucVu.getText().toString();
        String coQuan = edtCoQuan.getText().toString();
        String email = edtMail.getText().toString();
        String loaiKH = edtLoaiKH.getText().toString();

        if (ma.isEmpty() || ten.isEmpty() || sdt.isEmpty() || date.isEmpty() || address.isEmpty() || chucVu.isEmpty() || coQuan.isEmpty() || email.isEmpty() || loaiKH.isEmpty()) {
            Toast.makeText(this, "Data in valid", Toast.LENGTH_SHORT).show();
            return;
        }
        boolean isInsert = khachHang == null;
        if (khachHang == null){
            khachHang = new KhachHang();
        }
        khachHang.setMa(ma);
        khachHang.setName(ten);
        khachHang.setPhone(sdt);
        khachHang.setDate(date);
        khachHang.setAddress(address);
        khachHang.setChucVu(chucVu);
        khachHang.setEmail(email);
        khachHang.setCoQuan(coQuan);
        khachHang.setLoaiKH(loaiKH);

        if (isInsert){
            AppDatabase.getInstance(this).getKHDao().insert(khachHang);
        }else{
            AppDatabase.getInstance(this).getKHDao().update(khachHang);
        }
        setResult(RESULT_OK);
        finish();

    }
}
