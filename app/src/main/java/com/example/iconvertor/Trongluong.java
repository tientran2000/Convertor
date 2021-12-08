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

public class Trongluong extends AppCompatActivity {
    Spinner sp;
    TextView mg,gam,kg,yen,ta,tan,pound,ounce,stone;
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
        setContentView(R.layout.activity_trongluong);
        Init();
        arrayList.add("mg");
        arrayList.add("g");

        arrayList.add("kg");
        arrayList.add("yến");
        arrayList.add("tạ");
        arrayList.add("t");
        arrayList.add("oz");
        arrayList.add("lb");
        arrayList.add("st");

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
        mg=findViewById(R.id.tvmiligam);
        gam=findViewById(R.id.tvgam);
        kg=findViewById(R.id.tvkg);
        yen=findViewById(R.id.tvyen);
        ta=findViewById(R.id.tvta);
        tan=findViewById(R.id.tvtan);
        pound=findViewById(R.id.tvpound);
        stone=findViewById(R.id.tvstone);
        ounce=findViewById(R.id.tvounce);
        cd=findViewById(R.id.edtchieudai);
        chuyen=findViewById(R.id.btchuyen);


        arrayList=new ArrayList<String>();
    }
    public void SetData(float c,int i){
        float nmg,ngam,nkg,nta,nyen,ntan,nounce,npound,nstone;
        //float n=Float.valueOf(cd.getText().toString());
        if(arrayList.get(i)=="mg"){
            nmg=(float) c;
            ngam= (float) (c*0.001);
            nkg= (float) (c*1.0E-6);
            nta=(float) (c*1.0E-8);
            nyen= (float) (c*1.0E-7);
            ntan=(float) (c*1.0E-9);
            nounce=(float)(c*3.53E-5);
            npound=(float)(c*2.2E-6);
            nstone=(float)(c*1.57E-7);
            mg.setText(""+nmg);
            gam.setText(""+ngam);
            kg.setText(""+nkg);
            ta.setText(""+nta);
            yen.setText(""+nyen);
            tan.setText(""+ntan);
            ounce.setText(""+nounce);
            pound.setText(""+npound);
            stone.setText(""+nstone);
        }
        if(arrayList.get(i)=="g"){
            nmg=(float) c*1000;
            ngam= (float)c;
            nkg= (float) (c*1.0E-3);
            nta=(float) (c*1.0E-5);
            nyen= (float) (c*1.0E-4);
            ntan=(float) (c*1.0E-6);
            nounce=(float)(c*3.53E-2);
            npound=(float)(c*2.2E-3);
            nstone=(float)(c*1.57E-4);
            mg.setText(""+nmg);
            gam.setText(""+ngam);
            kg.setText(""+nkg);
            ta.setText(""+nta);
            yen.setText(""+nyen);
            tan.setText(""+ntan);
            ounce.setText(""+nounce);
            pound.setText(""+npound);
            stone.setText(""+nstone);
        }
        if(arrayList.get(i)=="kg"){
            nmg=(float) c*1000000;
            ngam= (float) c*1000;
            nkg= (float) c;
            nta=(float) (c*0.01);
            nyen= (float) (c*0.1);
            ntan=(float) (c*1.0E-3);
            nounce=(float)(c*35.274);
            npound=(float)(c*2.2);
            nstone=(float)(c*0.16);
            mg.setText(""+nmg);
            gam.setText(""+ngam);
            kg.setText(""+nkg);
            ta.setText(""+nta);
            yen.setText(""+nyen);
            tan.setText(""+ntan);
            ounce.setText(""+nounce);
            pound.setText(""+npound);
            stone.setText(""+nstone);
        }
        if(arrayList.get(i)=="yến"){
            nmg=(float) c*10000000;
            ngam= (float) c*10000;
            nkg= (float) c*10;
            nta=(float) (c*0.1);
            nyen=c;
            ntan=(float) (c*0.01);
            nounce=(float)(c*352.74);
            npound=(float)(c*22.05);
            nstone=(float)(c*1.575);
            mg.setText(""+nmg);
            gam.setText(""+ngam);
            kg.setText(""+nkg);
            ta.setText(""+nta);
            yen.setText(""+nyen);
            tan.setText(""+ntan);
            ounce.setText(""+nounce);
            pound.setText(""+npound);
            stone.setText(""+nstone);
        }
        if(arrayList.get(i)=="tạ"){
            nmg=(float) c*100000000;
            ngam= (float) c*100000;
            nkg= (float) c*100;
            nta=(float)c;
            nyen=c*10;
            ntan=(float) (c*0.1);
            nounce=(float)(c*3527.396);
            npound=(float)(c*220.46);
            nstone=(float)(c*15.75);
            mg.setText(""+nmg);
            gam.setText(""+ngam);
            kg.setText(""+nkg);
            ta.setText(""+nta);
            yen.setText(""+nyen);
            tan.setText(""+ntan);
            ounce.setText(""+nounce);
            pound.setText(""+npound);
            stone.setText(""+nstone);
        }
        if(arrayList.get(i)=="t"){
            nmg=(float) c*1000000000;
            ngam= (float) c*1000000;
            nkg= (float) c*1000;
            nta=(float)c*10;
            nyen=c*100;
            ntan=(float) c;
            nounce=(float)(c*35273.96);
            npound=(float)(c*2204.62);
            nstone=(float)(c*157.47);
            mg.setText(""+nmg);
            gam.setText(""+ngam);
            kg.setText(""+nkg);
            ta.setText(""+nta);
            yen.setText(""+nyen);
            tan.setText(""+ntan);
            ounce.setText(""+nounce);
            pound.setText(""+npound);
            stone.setText(""+nstone);
        }
        if(arrayList.get(i)=="oz"){
            nmg=(float) (c*28349.5231);
            ngam= (float) (c*28.35);
            nkg= (float) (c*0.028349493942109);
            nta=(float)(c*0.00028349493942109);
            nyen=(float)(c*0.0028349493942109);
            ntan=(float)(c*0.000028349493942109);
            nounce=(float)c;
            npound=(float)(c*0.0625);
            nstone=(float)(c*0.004464285714285715);
            mg.setText(""+nmg);
            gam.setText(""+ngam);
            kg.setText(""+nkg);
            ta.setText(""+nta);
            yen.setText(""+nyen);
            tan.setText(""+ntan);
            ounce.setText(""+nounce);
            pound.setText(""+npound);
            stone.setText(""+nstone);
        }
        if(arrayList.get(i)=="st"){
            nmg=(float) (c*6350293.18);
            ngam= (float) (c*6350.29318);
            nkg= (float) (c*6.35029318);
            nta=(float)(c*0.0635029318);
            nyen= (float) (c*0.635029318);
            ntan=(float) (c*0.00635);
            nounce=(float)(c*224);
            npound=(float)(c*14);
            nstone=(float)c;
            mg.setText(""+nmg);
            gam.setText(""+ngam);
            kg.setText(""+nkg);
            ta.setText(""+nta);
            yen.setText(""+nyen);
            tan.setText(""+ntan);
            ounce.setText(""+nounce);
            pound.setText(""+npound);
            stone.setText(""+nstone);
        }
        if(arrayList.get(i)=="lb"){
            nmg=(float) (c*453592.37);
            ngam= (float) (c*453.59237);
            nkg= (float) (c*0.45359);
            nta=(float)(c*0.0045359);
            nyen= (float) (c*0.045359);
            ntan=(float) (c*0.00045);
            nounce=(float)(c*16);
            npound=(float)c;
            nstone=(float)(c*0.07143);
            mg.setText(""+nmg);
            gam.setText(""+ngam);
            kg.setText(""+nkg);
            ta.setText(""+nta);
            yen.setText(""+nyen);
            tan.setText(""+ntan);
            ounce.setText(""+nounce);
            pound.setText(""+npound);
            stone.setText(""+nstone);
        }

    }
    public void reSet(){
        mg.setText("");
        gam.setText("");
        kg.setText("");
        ta.setText("");
        yen.setText("");
        tan.setText("");
        ounce.setText("");
        pound.setText("");
        stone.setText("");
    }
}