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

public class Dientich extends AppCompatActivity {
    Spinner sp;
    TextView km,mm,cm,m,ha,yd,in,ft,mi;
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
        setContentView(R.layout.activity_dientich);
        Init();
        arrayList.add("mm²");
        arrayList.add("cm²");

        arrayList.add("m²");
        arrayList.add("ha");
        arrayList.add("km²");
        arrayList.add("yd²");
        arrayList.add("ft²");
        arrayList.add("in²");
        arrayList.add("mi²");
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
//         sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//             @Override
//             public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                 p=position;
//                    cd.addTextChangedListener(new TextWatcher() {
//                        @Override
//                        public void beforeTextChanged(CharSequence ss, int start, int count, int after) {
//                            ss=cd.getText().toString();
//
//                            if(ss.equals("")) reSet();
//                            else {
//                                float m=Float.valueOf(ss.toString());
//                                SetData(m,p);
//                            }
//
//
//                        }
//
//                        @Override
//                        public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//                        }
//
//                        @Override
//                        public void afterTextChanged(Editable s) {
//
//                        }
//                    });
//             }

//             @Override
//             public void onNothingSelected(AdapterView<?> parent) {
//
//             }
//         });

    }
    public void Init(){
        sp=findViewById(R.id.spChieudai);
        km=findViewById(R.id.tvkm);
        mm=findViewById(R.id.tvmm);
        cm=findViewById(R.id.tvcm);
        ha=findViewById(R.id.tvha);
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
        if(arrayList.get(i)=="mm²"){
            skm= (float) (c*1.0E-12);
            smm=c;
            scm= c/100;
            sdm=(float) (c*1.0E-10);
            sm= (float) (c*1.0E-6);
            sin= (float) (c*0.00155000310001);
            syd= (float) (c*1.1959900463E-6);
            smi=(float) (c*3.86102159E-13);
            sft= (float) (c*1.07639104167E-5);
            km.setText(""+skm);
            mm.setText(""+smm);
            cm.setText(""+scm);
            ha.setText(""+sdm);
            m.setText(""+sm);
            ft.setText(""+sft);
            yd.setText(""+syd);
            mi.setText(""+smi);
            in.setText(""+sin);
        }
        if(arrayList.get(i)=="cm²"){
            skm= (float) (c*1.0E-10);
            smm=c*100;
            scm= c;
            sdm=(float) (c*1.0E-8);
            sm= (float) (c*0.0001);
            sin= (float) (c*0.155000310001);
            syd= (float) (c*0.00011959900463);
            smi=(float) (c*3.86102159E-11);
            sft= (float) (c*0.00107639104167);
            km.setText(""+skm);
            mm.setText(""+smm);
            cm.setText(""+scm);
            ha.setText(""+sdm);
            m.setText(""+sm);
            ft.setText(""+sft);
            yd.setText(""+syd);
            mi.setText(""+smi);
            in.setText(""+sin);
        }
        if(arrayList.get(i)=="ha"){
            skm= (float) (n*0.01);
            smm= (float) (n*10000000000.0);
            scm= n*100000000;
            sdm=n;
            sm=n*10000;
            sin= (float) (n*15500031);
            syd= (float) (n*11959.9);
            smi=(float) (n*0.00386102159);
            sft= (float) (n*107639.104);
            km.setText(""+skm);
            mm.setText(""+smm);
            cm.setText(""+scm);
            ha.setText(""+sdm);
            m.setText(""+sm);
            ft.setText(""+sft);
            yd.setText(""+syd);
            mi.setText(""+smi);
            in.setText(""+sin);
        }
        if(arrayList.get(i)=="m²"){
            skm= (float) (n*1.0E-6);
            smm=n*1000000;
            scm= n*10000;
            sdm= (float) (n*0.0001);
            sm=n;
            sin= (float) (n*1550.003);
            syd= (float) (n*1.196);
            smi=(float) (n*3.86102159E-7);
            sft= (float) (n*10.764);
            km.setText(""+skm);
            mm.setText(""+smm);
            cm.setText(""+scm);
            ha.setText(""+sdm);
            m.setText(""+sm);
            ft.setText(""+sft);
            yd.setText(""+syd);
            mi.setText(""+smi);
            in.setText(""+sin);
        }
        if(arrayList.get(i)=="km²"){
            skm= n;
            smm= (float) (n*1000000000000.0);
            scm= (float) (n*10000000000.0);
            sdm=n*100;
            sm=n*1000000;
            sin= (float) (n*1550003100.01);
            syd= (float) (n*1195990.046);
            smi=(float) (n*0.386102159);
            sft= (float) (n*10763910.417);
            km.setText(""+skm);
            mm.setText(""+smm);
            cm.setText(""+scm);
            ha.setText(""+sdm);
            m.setText(""+sm);
            ft.setText(""+sft);
            yd.setText(""+syd);
            mi.setText(""+smi);
            in.setText(""+sin);
        }
        if(arrayList.get(i)=="in²"){
            skm= (float) (n*6.4515999999842E-10);
            smm= (float) (n*645.16);
            scm= (float) (n*6.452);
            sdm= (float) (n*6.4515999999842E-8);
            sm= (float) (n*0.00064515999999842);
            sin= n;
            syd= (float) (n*0.00077160493826902);
            smi=(float) (n*2.4909766889983E-10);
            sft= (float) (n*0.0069444444444211);
            km.setText(""+skm);
            mm.setText(""+smm);
            cm.setText(""+scm);
            ha.setText(""+sdm);
            m.setText(""+sm);
            ft.setText(""+sft);
            yd.setText(""+syd);
            mi.setText(""+smi);
            in.setText(""+sin);
        }
        if(arrayList.get(i)=="ft²"){
            skm= (float) (n*9.2903040000084E-8);
            smm= (float) (n*92903.04);
            scm= (float) (n*929.03);
            sdm= (float) (n*9.2903040000084E-6);
            sm= (float) (n*0.092903040000084);
            sin= n*144;
            syd= (float) (n*0.11111111111111);
            smi=(float) (n*3.5870064321696E-8);
            sft= n;
            km.setText(""+skm);
            mm.setText(""+smm);
            cm.setText(""+scm);
            ha.setText(""+sdm);
            m.setText(""+sm);
            ft.setText(""+sft);
            yd.setText(""+syd);
            mi.setText(""+smi);
            in.setText(""+sin);
        }
        if(arrayList.get(i)=="yd²"){
            skm= (float) (n*8.3612736000076E-7
            );
            smm= (float) (n*836127.36);
            scm= (float) (n*8361.274);
            sdm= (float) (n*8.3612736000076E-5);
            sm= (float) (n*0.83612736000076);
            sin= n*1296;
            syd= n;
            smi= (float) (n*3.2283057889526E-7);
            sft= n*9;
            km.setText(""+skm);
            mm.setText(""+smm);
            cm.setText(""+scm);
            ha.setText(""+sdm);
            m.setText(""+sm);
            ft.setText(""+sft);
            yd.setText(""+syd);
            mi.setText(""+smi);
            in.setText(""+sin);
        }
        if(arrayList.get(i)=="mi²"){
            skm= (float) (n*2.59);
            smm= (float) (n*2589988107266.7);
            scm= (float) (n*25899881072.667);
            sdm= (float) (n*258.999);
            sm= (float) (n*2589988.107);
            sin= (float) (n*4014489595.252);
            syd= (float) (n*3097599.996);
            smi=n;
            sft= (float) (n*27878399.967);
            km.setText(""+skm);
            mm.setText(""+smm);
            cm.setText(""+scm);
            ha.setText(""+sdm);
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
        ha.setText("");
        m.setText("");
        ft.setText("");
        yd.setText("");
        mi.setText("");
        in.setText("");
    }
}