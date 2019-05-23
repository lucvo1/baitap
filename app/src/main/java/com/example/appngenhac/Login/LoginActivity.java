package com.example.appngenhac.Login;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appngenhac.Database.database;
import com.example.appngenhac.R;
import com.example.appngenhac.TrangChu.TrangChuActivity;

public class LoginActivity extends AppCompatActivity {
    database db;
    EditText edtuser,edtpass;
    Button  btnDangnhap,btnDangky;
    String ten, mk;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        db = new database(this);
        Anhxa();
        btnDangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(LoginActivity.this);
                dialog.setTitle("Form Đăng Ký");
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.customdialog);
                final EditText edttk = (EditText)dialog.findViewById(R.id.edttk);
                final EditText edtmk = (EditText)dialog.findViewById(R.id.edtmk);
                Button bthuy = (Button)dialog.findViewById(R.id.bthuy);
                Button btdongy = (Button)dialog.findViewById(R.id.btdongy);
                btdongy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ten = edttk.getText().toString().trim();
                        mk = edtmk.getText().toString().trim();
                        //edtuser.setText(ten);
                        //edtpass.setText(mk);
                        if(ten.equals("")|| mk.equals("")){
                            Toast.makeText(getApplicationContext(),"không được để trống",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Boolean chkacc = db.chkacc(ten);
                            if(chkacc=true){
                                Boolean insert = db.insert(ten,mk);
                                if(insert=true){
                                    Toast.makeText(getApplicationContext(),"đăng ký thành công",Toast.LENGTH_SHORT).show();
                                }
                            }
                            else{
                                Toast.makeText(getApplicationContext(),"tài khoản tồn tại",Toast.LENGTH_SHORT).show();
                            }
                        }
                        dialog.cancel();
                    }
                });
                bthuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });
        btnDangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String account = edtuser.getText().toString();
                String password = edtpass.getText().toString();
                Boolean check = db.check(account,password);
                if(check==true){
                    Toast.makeText(getApplicationContext(),"đăng nhập thành công",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this,TrangChuActivity.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(LoginActivity.this, "Bạn đã đăng nhập thất bại",Toast.LENGTH_SHORT).show();
               /*if(edtuser.getText().length() !=0 && edtpass.getText().length() !=0){
                   if (edtuser.getText().toString().equals(ten) && edtpass.getText().toString().equals(mk)) {
                       Toast.makeText(LoginActivity.this, "Bạn đã đăng nhập thành công",Toast.LENGTH_SHORT).show();
                       Intent intent = new Intent(LoginActivity.this,TrangChuActivity.class);
                       startActivity(intent);
                   }else { if (edtuser.getText().toString().equals("abc") && edtpass.getText().toString().equals("123")) {
                       Toast.makeText(LoginActivity.this, "Bạn đã đăng nhập thành công",Toast.LENGTH_SHORT).show();
                       Intent intent = new Intent(LoginActivity.this,TrangChuActivity.class);
                       startActivity(intent);
                   }else {
                       Toast.makeText(LoginActivity.this, "Bạn đã đăng nhập thất bại",Toast.LENGTH_SHORT).show();
                   }
                   }
               } else {
                   Toast.makeText(LoginActivity.this, "Mời bạn nhập đủ thông tin",Toast.LENGTH_SHORT).show();
               }*/
            }
        });
}
    private  void Anhxa(){
        edtuser = (EditText)findViewById(R.id.edittextuser);
        edtpass = (EditText)findViewById(R.id.edittextpass);
        btnDangky = (Button)findViewById(R.id.btDangky);
        btnDangnhap = (Button)findViewById(R.id.btDangnhap);
    }
}
