package com.example.iconvertor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Goc extends AppCompatActivity {
    Spinner sp;
    TextView doc,rad,vq,mil,grad,gon;
    ArrayList<String> arrayList;
    ArrayAdapter adapter;
    EditText cd;
    Button chuyen;
    float n;
    String s;
    int p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goc);
        Init();
        arrayList.add("Độ");
        arrayList.add("Phút");
        arrayList.add("Giây");
        arrayList.add("Radian");
        arrayList.add("Vòng quay");
        arrayList.add("Mil(NATO)");
        arrayList.add("Grad");
        arrayList.add("Gon");
        adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                chuyen.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        s=cd.getText().toString();
                        //Toast.makeText(Dientich.this,s,Toast.LENGTH_SHORT).show();
                        if(s.equals("")) reSet();
                        else {

                            n=Float.valueOf(s);
                            SetData(n,position);
                        }

                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
    public void Init(){
        sp=findViewById(R.id.spChieudai);
        doc=findViewById(R.id.tvdo);

        rad=findViewById(R.id.tvradian);
        gon=findViewById(R.id.tvGon);
        grad=findViewById(R.id.tvgrad);
        mil=findViewById(R.id.tvmil);
        vq=findViewById(R.id.tvvongquay);

        cd=findViewById(R.id.edtchieudai);
        chuyen=findViewById(R.id.btchuyen);


        arrayList=new ArrayList<String>();
    }
    public void SetData(float c,int i){
        float dc,srad,svq,sgon,smil,sgrad;
        //float n=Float.valueOf(cd.getText().toString());
        if(arrayList.get(i)=="Độ"){
            dc= (float) (c);

            srad=(float) (c*0.0174533 );
            svq= (float) (c/360);
            smil=(float)(c*17.77778);
            sgrad=(float)(c*1.11111);
            sgon=(float)(c*1.11111);
            doc.setText(""+dc);

            rad.setText(""+srad);
            grad.setText(""+sgrad);
            gon.setText(""+sgon);
            mil.setText(""+smil);
            vq.setText(""+svq);
        }
        if(arrayList.get(i)=="Radian"){
            dc= (float) (c*180/Math.PI);
            srad=(float) (c);
            svq= (float) (c*0.15915);
            smil=(float)(c*1018.59164);
            sgrad=(float)(c*63.66198);
            sgon=(float)(c*63.66198);
            doc.setText(""+dc);

            rad.setText(""+srad);
            grad.setText(""+sgrad);
            gon.setText(""+sgon);
            mil.setText(""+smil);
            vq.setText(""+svq);
        }
        if(arrayList.get(i)=="Vòng quay"){
            dc= (float) (c*360);
            srad=(float) (c*6.28319);
            svq= (float) (c);
            smil=(float)(c*6400);
            sgrad=(float)(c*400);
            sgon=(float)(c*400);
            doc.setText(""+dc);

            rad.setText(""+srad);
            grad.setText(""+sgrad);
            gon.setText(""+sgon);
            mil.setText(""+smil);
            vq.setText(""+svq);
        }
        if(arrayList.get(i)=="Mil(NATO)"){
            dc= (float) (c*0.05625);
            srad=(float) (c*0.00098);
            svq= (float) (c*0.00016);
            smil=(float)(c*1);
            sgrad=(float)(c*0.0625);
            sgon=(float)(c*0.0625);
            doc.setText(""+dc);

            rad.setText(""+srad);
            grad.setText(""+sgrad);
            gon.setText(""+sgon);
            mil.setText(""+smil);
            vq.setText(""+svq);
        }
        if(arrayList.get(i)=="Grad"){
            dc= (float) (c*0.9);
            srad=(float) (c*0.01571);
            svq= (float) (c*0.0025);
            smil=(float)(c*16);
            sgrad=(float)(c*1);
            sgon=(float)(c*1);
            doc.setText(""+dc);

            rad.setText(""+srad);
            grad.setText(""+sgrad);
            gon.setText(""+sgon);
            mil.setText(""+smil);
            vq.setText(""+svq);
        }
        if(arrayList.get(i)=="Gon"){
            dc= (float) (c*0.9);
            srad=(float) (c*0.01571);
            svq= (float) (c*0.0025);
            smil=(float)(c*16);
            sgrad=(float)(c*1);
            sgon=(float)(c*1);
            doc.setText(""+dc);

            rad.setText(""+srad);
            grad.setText(""+sgrad);
            gon.setText(""+sgon);
            mil.setText(""+smil);
            vq.setText(""+svq);
        }
    }
    public void reSet(){
        doc.setText("");

        rad.setText("");
        grad.setText("");
        gon.setText("");
        mil.setText("");
        vq.setText("");
    }
}