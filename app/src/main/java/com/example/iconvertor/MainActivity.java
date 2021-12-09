package com.example.iconvertor;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ListView lv;
    ImageButton menu,timkiem,chieudai,thetich,dientich,thoigian,goc,trongluong,bmi,doam,nhietdo,vantoc,giatoc,luc,tiente,kichco,sohoc;
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
        menu=findViewById(R.id.menu);

        drawerLayout=findViewById(R.id.drawebleLayout);
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

        }
    }
    public void ClickMenu(View view){
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout) {
    drawerLayout.openDrawer(GravityCompat.START);
    }
    public void ClickLogo(View view){
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }
    public void ClickHome(View view){
        recreate();
    }
    public void ClickDashboard(View v){
        Share();
    }
    public void ClickAboutUs(View view){
        redirectActivity(this,AboutUs.class);
    }
    public  void ClickExit(View view){
Logout(this);
    }
    public static void Logout(Activity activity){
        AlertDialog.Builder builder=new AlertDialog.Builder(activity);
        builder.setTitle("Thoát");
        builder.setMessage("Bạn muốn thoát khỏi ứng dụng?");
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                activity.finishAffinity();
                System.exit(0);
            }
        });
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }
    public void Search(View view){
        redirectActivity(this,Timkiem.class);
    }
    public static void redirectActivity(Activity activity,Class a){
        Intent i=new Intent(activity,a);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(i);
    }
    public void Share(){
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        String sharebody="https://github.com/tientran2000/Convertor.git";
        intent.putExtra(Intent.EXTRA_TEXT,sharebody);
        startActivity(Intent.createChooser(intent,"Chia sẻ với"));
    }
}