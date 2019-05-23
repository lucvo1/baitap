package com.example.appngenhac;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.appngenhac.Login.LoginActivity;

public class ManHinhChaoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manhinhchao_layout);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(1500);

                }catch (Exception e){

                }finally {
                    Intent iLogin = new Intent(ManHinhChaoActivity.this, LoginActivity.class);
                    startActivity(iLogin);
                }
            }
        });
        thread.start();
    }
}
