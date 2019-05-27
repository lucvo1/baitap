package com.example.appngenhac.Nhac;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.example.appngenhac.Database.dbmusic;
import com.example.appngenhac.R;

import java.util.ArrayList;

public class NhacActivity extends AppCompatActivity {
    dbmusic dbmusic;
    ListView lvnhac;
    ArrayList<ListNhac> arraynhac;
    ListNhacAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listnhac_activity);

        lvnhac = (ListView) findViewById(R.id.listviewnhac);
        arraynhac = new ArrayList<>();
        adapter = new ListNhacAdapter(NhacActivity.this,R.layout.listnhac_layout,arraynhac);
        lvnhac.setAdapter(adapter);

        Cursor dataNhac = dbmusic.Getdata("SELECT * FROM Nhac");
        while(dataNhac.moveToNext()){
            String baihat = dataNhac.getString(1);
            int id = dataNhac.getInt(0);
            arraynhac.add(new ListNhac(id,baihat));
        }
        adapter.notifyDataSetChanged();
    }
}
