package com.example.iconvertor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TabHost;

public class Kichco extends AppCompatActivity {
TabHost th;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kichco);
        th=(TabHost)findViewById(R.id.th);
        th.setup();

        //tạo các tab123
        TabHost.TabSpec tspec;
        tspec=th.newTabSpec("t1");
        tspec.setContent(R.id.tab1);
        tspec.setIndicator("Nam");
        th.addTab(tspec);
        //
        tspec=th.newTabSpec("t2");
        tspec.setContent(R.id.tab2);
        tspec.setIndicator("Nữ");
        th.addTab(tspec);

        th.setCurrentTab(0);
    }
}