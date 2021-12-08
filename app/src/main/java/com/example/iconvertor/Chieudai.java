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

public class Chieudai extends AppCompatActivity {
    Spinner sp;
    TextView km,mm,cm,m,dm,yd,in,ft,mi;
    ArrayList<String> arrayList;
    ArrayAdapter adapter;
    EditText cd;
    Button chuyen;
    float n;
    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chieudai);
        Init();
        arrayList.add("mm");
        arrayList.add("cm");
        arrayList.add("dm");
        arrayList.add("m");
        arrayList.add("km");
        arrayList.add("yd");
        arrayList.add("ft");
        arrayList.add("in");
        arrayList.add("mi");
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
                        Toast.makeText(Chieudai.this,s,Toast.LENGTH_SHORT).show();
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
//        cd.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                s=cd.getText().toString();
//                if (s.equals("")) reSet();
//
//                else {
//                    float n=Float.valueOf(s.toString());
//                    sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//                        @Override
//                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                            Toast.makeText(Chieudai.this,arrayList.get(position),Toast.LENGTH_SHORT).show();
//                            SetData(n,position);
//                        }
//
//                        @Override
//                        public void onNothingSelected(AdapterView<?> parent) {
//
//                        }
//                    });
//                }
//
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });

    }
    public void Init(){
        sp=findViewById(R.id.spChieudai);
        km=findViewById(R.id.tvkm);
        mm=findViewById(R.id.tvmm);
        cm=findViewById(R.id.tvcm);
        dm=findViewById(R.id.tvdm);
        yd=findViewById(R.id.tvyard);
        ft=findViewById(R.id.tvfoot);
        in=findViewById(R.id.tvinch);
        mi=findViewById(R.id.tvmile);
        m=findViewById(R.id.tvm);
        cd=findViewById(R.id.edtchieudai);
        chuyen=findViewById(R.id.btchuyen);


        arrayList=new ArrayList<String>();
    }
    public void SetData(float c,int i){
        float skm,smm,scm,sm,sdm,syd,sin,sft,smi;
        //float n=Float.valueOf(cd.getText().toString());
        if(arrayList.get(i)=="mm"){
            skm= (float) (c/Math.pow(10,6));
            smm=c;
            scm= c/10;
            sdm=c/100;
            sm=c/1000;
            sin= (float) (c*0.039370);
            syd= (float) (c/914.4);
            smi=(float) (c/1.60934e6);
            sft= (float) (c/304.8);
            km.setText(""+skm);
            mm.setText(""+smm);
            cm.setText(""+scm);
            dm.setText(""+sdm);
            m.setText(""+sm);
            ft.setText(""+sft);
            yd.setText(""+syd);
            mi.setText(""+smi);
            in.setText(""+sin);
        }
        if(arrayList.get(i)=="cm"){
            skm= (float) (c/Math.pow(10,5));
            smm=c*10;
            scm= c;
            sdm=c/10;
            sm=c/100;
            sin= (float) (c*0.39370098114);
            syd= (float) (c*0.010936100483);
            smi=(float) (c*6.21371E-6);
            sft= (float) (c*0.0328083992);
            km.setText(""+skm);
            mm.setText(""+smm);
            cm.setText(""+scm);
            dm.setText(""+sdm);
            m.setText(""+sm);
            ft.setText(""+sft);
            yd.setText(""+syd);
            mi.setText(""+smi);
            in.setText(""+sin);
        }
        if(arrayList.get(i)=="dm"){
            skm= (float) (n/Math.pow(10,4));
            smm=n*100;
            scm= n*10;
            sdm=n;
            sm=n/10;
            sin= (float) (n*3.9370098114);
            syd= (float) (n*0.10936100483);
            smi=(float) (n*6.21371E-5);
            sft= (float) (n*0.328083992);
            km.setText(""+skm);
            mm.setText(""+smm);
            cm.setText(""+scm);
            dm.setText(""+sdm);
            m.setText(""+sm);
            ft.setText(""+sft);
            yd.setText(""+syd);
            mi.setText(""+smi);
            in.setText(""+sin);
        }
        if(arrayList.get(i)=="m"){
            skm= (float) (n/Math.pow(10,3));
            smm=n*1000;
            scm= n*100;
            sdm=n*10;
            sm=n;
            sin= (float) (n*39.370098114);
            syd= (float) (n*01.0936100483);
            smi=(float) (n*6.21371E-4);
            sft= (float) (n*03.28083992);
            km.setText(""+skm);
            mm.setText(""+smm);
            cm.setText(""+scm);
            dm.setText(""+sdm);
            m.setText(""+sm);
            ft.setText(""+sft);
            yd.setText(""+syd);
            mi.setText(""+smi);
            in.setText(""+sin);
        }
        if(arrayList.get(i)=="km"){
            skm= n;
            smm=n*1000000;
            scm= n*100000;
            sdm=n*10000;
            sm=n*1000;
            sin= (float) (n*39370.098114);
            syd= (float) (n*1093.6100483);
            smi=(float) (n*0.621371);
            sft= (float) (n*3280.83992);
            km.setText(""+skm);
            mm.setText(""+smm);
            cm.setText(""+scm);
            dm.setText(""+sdm);
            m.setText(""+sm);
            ft.setText(""+sft);
            yd.setText(""+syd);
            mi.setText(""+smi);
            in.setText(""+sin);
        }
        if(arrayList.get(i)=="in"){
            skm= (float) (n*2.54E-5);
            smm= (float) (n*25.4);
            scm= (float) (n*2.54);
            sdm= (float) (n*0.254);
            sm= (float) (n*0.0254);
            sin= n;
            syd= (float) (n*0.027777681557545);
            smi=(float) (n*1.5782815633346E-5);
            sft= (float) (n*0.083333292960053);
            km.setText(""+skm);
            mm.setText(""+smm);
            cm.setText(""+scm);
            dm.setText(""+sdm);
            m.setText(""+sm);
            ft.setText(""+sft);
            yd.setText(""+syd);
            mi.setText(""+smi);
            in.setText(""+sin);
        }
        if(arrayList.get(i)=="ft"){
            skm= (float) (n*0.00030479999767864);
            smm= (float) (n*304.8);
            scm= (float) (n*30.48);
            sdm= (float) (n*3.048);
            sm= (float) (n*0.30479999767864);
            sin= n*12;
            syd= (float) (n*0.33333234018318);
            smi=(float) (n*0.00018939387935758);
            sft= n;
            km.setText(""+skm);
            mm.setText(""+smm);
            cm.setText(""+scm);
            dm.setText(""+sdm);
            m.setText(""+sm);
            ft.setText(""+sft);
            yd.setText(""+syd);
            mi.setText(""+smi);
            in.setText(""+sin);
        }
        if(arrayList.get(i)=="yd"){
            skm= (float) (n*0.00091440271745352);
            smm= (float) (n*914.40271745352);
            scm= (float) (n*91.440271745352);
            sdm= (float) (n*9.1440271745352);
            sm= (float) (n*0.91440271745352);
            sin= n*36;
            syd= n;
            smi= (float) (n*0.00056818333094681);
            sft= n*3;
            km.setText(""+skm);
            mm.setText(""+smm);
            cm.setText(""+scm);
            dm.setText(""+sdm);
            m.setText(""+sm);
            ft.setText(""+sft);
            yd.setText(""+syd);
            mi.setText(""+smi);
            in.setText(""+sin);
        }
        if(arrayList.get(i)=="mi"){
            skm= (float) (n*1.609);
            smm= (float) (n*1609344.498);
            scm= (float) (n*160934.498);
            sdm= (float) (n*16093.4498);
            sm= (float) (n*1609.34498);
            sin= (float) (n*63360.051);
            syd= (float) (n*1759.995);
            smi=n;
            sft= (float) (n*5280.002);
            km.setText(""+skm);
            mm.setText(""+smm);
            cm.setText(""+scm);
            dm.setText(""+sdm);
            m.setText(""+sm);
            ft.setText(""+sft);
            yd.setText(""+syd);
            mi.setText(""+smi);
            in.setText(""+sin);
        }
    }
    public void reSet(){
        km.setText("");
            mm.setText("");
            cm.setText("");
            dm.setText("");
            m.setText("");
            ft.setText("");
            yd.setText("");
            mi.setText("");
            in.setText("");
    }
}