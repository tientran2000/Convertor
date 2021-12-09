package com.example.iconvertor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AboutUs extends AppCompatActivity {
DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        drawerLayout=findViewById(R.id.drawebleLayout);
    }
    public void ClickMenu(View view){
        MainActivity.openDrawer(drawerLayout);
    }
    public void ClickLogo(View view){
        MainActivity.closeDrawer(drawerLayout);
    }
    public void ClickHome(View view){
        MainActivity.redirectActivity(this,MainActivity.class);
    }
    public void ClickAboutUs(View view){
        recreate();
    }
    public void ClickDashboard(View view){
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        String sharebody="https://github.com/tientran2000/Convertor.git";
        intent.putExtra(Intent.EXTRA_TEXT,sharebody);
        startActivity(Intent.createChooser(intent,"Chia sẻ với"));
    }
    public void ClickExit(View view){
        MainActivity.Logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MainActivity.closeDrawer(drawerLayout);
    }
    public void Search(View view){
        MainActivity.redirectActivity(this,Timkiem.class);
    }
}