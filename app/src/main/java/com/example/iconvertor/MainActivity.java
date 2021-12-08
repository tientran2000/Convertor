package com.example.iconvertor;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    ImageButton timkiem,chieudai,thetich,dientich,thoigian,goc,trongluong,bmi,doam,nhietdo,vantoc,giatoc,luc,tiente,kichco,sohoc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
//        recyclerView=findViewById(R.id.row);
//        adapter=new Adapter(this,getList());
//        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,3);
//        recyclerView.setLayoutManager(gridLayoutManager);
//        adapter.setData(getList());
//        recyclerView.setAdapter(adapter);
        ActionBar a=getSupportActionBar();
        a.hide();
        Init();
    }

    private void Init() {
        chieudai=findViewById(R.id.chieudai);
        dientich=findViewById(R.id.dientich);
        thetich=findViewById(R.id.thetich);
        thoigian=findViewById(R.id.thoigian);
        goc=findViewById(R.id.goc);
        doam=findViewById(R.id.apsuat);
        nhietdo=findViewById(R.id.nhietdo);
        trongluong=findViewById(R.id.trongluong);
        bmi=findViewById(R.id.bmi);
        vantoc=findViewById(R.id.vantoc);
        giatoc=findViewById(R.id.giatoc);
        kichco=findViewById(R.id.kichco);
        tiente=findViewById(R.id.tiente);
        luc=findViewById(R.id.luc);
        sohoc=findViewById(R.id.sohoc);
        timkiem=findViewById(R.id.loupe);

    }


    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.sohoc:
                i = new Intent(this, Sohoc.class);
                startActivity(i);
                break;
            case R.id.dientich:
                i = new Intent(this, Dientich.class);
                startActivity(i);
                break;
            case R.id.thetich:
                i = new Intent(this, TheTich.class);
                startActivity(i);
                break;
            case R.id.chieudai:
                i = new Intent(this, Chieudai.class);
                startActivity(i);
                break;
            case R.id.goc:
                i = new Intent(this, Goc.class);
                startActivity(i);
                break;
            case R.id.luc:
                i = new Intent(this, Luc.class);
                startActivity(i);
                break;
            case R.id.thoigian:
                i = new Intent(this, Thoigian.class);
                startActivity(i);
                break;
            case R.id.tiente:
                i = new Intent(this, Currency.class);
                startActivity(i);
                break;
            case R.id.trongluong:
                i = new Intent(this, Trongluong.class);
                startActivity(i);
                break;
            case R.id.bmi:
                i = new Intent(this, BMI.class);
                startActivity(i);
                break;
            case R.id.apsuat:
                i = new Intent(this, Apsuat.class);
                startActivity(i);
                break;
            case R.id.nhietdo:
                i = new Intent(this, Nhietdo.class);
                startActivity(i);
                break;
            case R.id.kichco:
                i = new Intent(this, Kichco.class);
                startActivity(i);
                break;
            case R.id.vantoc:
                i = new Intent(this, Vantoc.class);
                startActivity(i);
                break;
            case R.id.giatoc:
                i = new Intent(this, Giatoc.class);
                startActivity(i);
                break;
            case R.id.loupe:
                i = new Intent(this, Timkiem.class);
                startActivity(i);
                break;
        }
    }
}