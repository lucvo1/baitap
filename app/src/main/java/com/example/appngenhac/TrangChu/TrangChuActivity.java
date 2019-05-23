package com.example.appngenhac.TrangChu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.appngenhac.Nhac.Nhac;
import com.example.appngenhac.Nhac.NhacAdapter;
import com.example.appngenhac.ProfileActivity;
import com.example.appngenhac.R;

import java.util.ArrayList;

public class TrangChuActivity extends AppCompatActivity {
    Button btnProfile;
    ListView lvnhac;
    ArrayList<Nhac> mangNhac;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trangchu_layout);
        btnProfile = (Button)findViewById(R.id.button);
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TrangChuActivity.this, "Bạn đã mở Profile",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(TrangChuActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        lvnhac = (ListView) findViewById(R.id.listnhac);
        mangNhac = new ArrayList<Nhac>();

        mangNhac.add(new Nhac("Em của ngày hôm qua", "Sơn Tùng MTP", R.drawable.icon));
        mangNhac.add(new Nhac("Hông Nhan", "Jack", R.drawable.icon));
        mangNhac.add(new Nhac("Chạy ngay đi", "Sơn Tùng MTP", R.drawable.icon));
        mangNhac.add(new Nhac("Nơi này có anh", "Sơn Tùng MTP", R.drawable.icon));
        mangNhac.add(new Nhac("Về bên anh", "Jack", R.drawable.icon));
        NhacAdapter adapter = new NhacAdapter(
                TrangChuActivity.this,
                R.layout.dong_nhac, mangNhac
        );
        lvnhac.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_layout, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menust:
                Toast.makeText(TrangChuActivity.this,"Bạn Chọn Setting",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menushare:
                Toast.makeText(TrangChuActivity.this,"Bạn Chọn Share",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menusearch:
                Toast.makeText(TrangChuActivity.this,"Bạn Chọn Search",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
