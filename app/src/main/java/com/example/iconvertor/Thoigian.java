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

public class Thoigian extends AppCompatActivity {
    Spinner sp;
    TextView giay,ms,phut,ngay,gio,tuan,thang,nam,theki,thapki;
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
        setContentView(R.layout.activity_thoigian);
        Init();
        arrayList.add("ms");
        arrayList.add("s");

        arrayList.add("min");
        arrayList.add("h");
        arrayList.add("d");
        arrayList.add("wk");
        arrayList.add("mon");
        arrayList.add("yr");
        arrayList.add("dec");
        arrayList.add("ce");

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
        giay=findViewById(R.id.tvgiay);
        ms=findViewById(R.id.tvms);
        phut=findViewById(R.id.tvphut);
        nam=findViewById(R.id.tvnam);
        gio=findViewById(R.id.tvgio);
        tuan=findViewById(R.id.tvtuan);
        thang=findViewById(R.id.tvthang);
        thapki=findViewById(R.id.tvthapki);
        theki=findViewById(R.id.tvtheki);
        ngay=findViewById(R.id.tvngay);
        cd=findViewById(R.id.edtchieudai);
        chuyen=findViewById(R.id.btchuyen);


        arrayList=new ArrayList<String>();
    }
    public void SetData(float c,int i){
        float nms,ngiay,nphut,ngio,nngay,nthang,nnam,ntuan,ntheki,nthapki;
        //float n=Float.valueOf(cd.getText().toString());
        if(arrayList.get(i)=="ms"){
            nms=c;
            ngiay= (float) (c*0.001);
            nphut= (float) (c*1.6666666666667E-5);
            ngio=(float) (c*2.7777777777778E-7);
            nngay= (float) (c*1.1574074074067E-8);
            ntuan=(float) (c*1.6534391534333E-9);
            nthang=(float)(c*3.8026486208333E-10);
            nnam=(float)(c*3.16887385E-11);
            nthapki=(float)(c*3.1709792E-12);
            ntheki=(float)(c*3.1709791666667E-13);
            ms.setText(""+nms);
            giay.setText(""+ngiay);
            phut.setText(""+nphut);
            gio.setText(""+ngio);
            ngay.setText(""+nngay);
            tuan.setText(""+ntuan);
            thang.setText(""+nthang);
            nam.setText(""+nnam);
            theki.setText(""+ntheki);
            thapki.setText(""+nthapki);
        }
        if(arrayList.get(i)=="s"){
            nms=c*1000;
            ngiay= c;
            nphut= (float) (c*0.016666666666667);
            ngio=(float) (c*0.00027777777777778);
            nngay= (float) (c*1.1574074074067E-5);
            ntuan=(float) (c*1.6534391534333E-6);
            nthang=(float)(c*3.8026486208333E-7);
            nnam=(float)(c*3.16887385E-8);
            nthapki=(float)(c*3.1709792E-9);
            ntheki=(float)(c*3.1709791666667E-10);
            ms.setText(""+nms);
            giay.setText(""+ngiay);
            phut.setText(""+nphut);
            gio.setText(""+ngio);
            ngay.setText(""+nngay);
            tuan.setText(""+ntuan);
            thang.setText(""+nthang);
            nam.setText(""+nnam);
            theki.setText(""+ntheki);
            thapki.setText(""+nthapki);
        }
        if(arrayList.get(i)=="min"){
            nms=c*60000;
            ngiay= (float) (c*60);
            nphut= c;
            ngio=(float) (c*0.016666666666667);
            nngay= (float) (c*0.000694444444444);
            ntuan=(float) (c*9.9206349206E-5);
            nthang=(float)(c*2.2815891725E-5);
            nnam=(float)(c*1.90132431E-6);
            nthapki=(float)(c*1.90258752E-7);
            ntheki=(float)(c*1.9025875E-8);
            ms.setText(""+nms);
            giay.setText(""+ngiay);
            phut.setText(""+nphut);
            gio.setText(""+ngio);
            ngay.setText(""+nngay);
            tuan.setText(""+ntuan);
            thang.setText(""+nthang);
            nam.setText(""+nnam);
            theki.setText(""+ntheki);
            thapki.setText(""+nthapki);
        }
        if(arrayList.get(i)=="h"){
            nms=c*3600000;
            ngiay= (float) (c*3600);
            nphut= (float) (c*60);
            ngio=c;
            nngay= (float) (c*0.041666666666639);
            ntuan=(float) (c*0.0059523809523599);
            nthang=(float)(c*0.0013689535035);
            nnam=(float)(c*0.0001140794586);
            nthapki=(float)(c*1.141552512E-5);
            ntheki=(float)(c*1.1415525E-6);
            ms.setText(""+nms);
            giay.setText(""+ngiay);
            phut.setText(""+nphut);
            gio.setText(""+ngio);
            ngay.setText(""+nngay);
            tuan.setText(""+ntuan);
            thang.setText(""+nthang);
            nam.setText(""+nnam);
            theki.setText(""+ntheki);
            thapki.setText(""+nthapki);
        }
        if(arrayList.get(i)=="d"){
            nms=c*86400000;
            ngiay= (float) (c*86400);
            nphut= (float) (c*1440);
            ngio=(float) (c*24);
            nngay= c;
            ntuan=(float) (c*0.14285714285673);
            nthang=(float)(c*0.032854884084021);
            nnam=(float)(c*0.0027379070064018);
            nthapki=(float)(c*0.00027397260288018);
            ntheki=(float)(c*2.7397260000018E-5);
            ms.setText(""+nms);
            giay.setText(""+ngiay);
            phut.setText(""+nphut);
            gio.setText(""+ngio);
            ngay.setText(""+nngay);
            tuan.setText(""+ntuan);
            thang.setText(""+nthang);
            nam.setText(""+nnam);
            theki.setText(""+ntheki);
            thapki.setText(""+nthapki);
        }
        if(arrayList.get(i)=="wk"){
            nms= (float) (c*604800000.002);
            ngiay= (float) (c*604800);
            nphut= (float) (c*10080);
            ngio=(float) (c*168);
            nngay= (float) (c*7);
            ntuan=(float) (c);
            nthang=(float)(c*0.22998418858881);
            nnam=(float)(c*0.019165349044867);
            nthapki=(float)(c*0.0019178082201668);
            ntheki=(float)(c*0.00019178082000068);
            ms.setText(""+nms);
            giay.setText(""+ngiay);
            phut.setText(""+nphut);
            gio.setText(""+ngio);
            ngay.setText(""+nngay);
            tuan.setText(""+ntuan);
            thang.setText(""+nthang);
            nam.setText(""+nnam);
            theki.setText(""+ntheki);
            thapki.setText(""+nthapki);
        }
        if(arrayList.get(i)=="mo"){
            nms= (float) (c*2629745999.989);
            ngiay= (float) (c*2629746);
            nphut= (float) (c*43829.1);
            ngio=(float) (c*730.485);
            nngay= (float) (c*30.437);
            ntuan=(float) (c*4.348);
            nthang=(float)(c);
            nnam=(float)(c*0.083333333315071);
            nthapki=(float)(c*0.0083388698672482);
            ntheki=(float)(c*0.000833886977959);
            ms.setText(""+nms);
            giay.setText(""+ngiay);
            phut.setText(""+nphut);
            gio.setText(""+ngio);
            ngay.setText(""+nngay);
            tuan.setText(""+ntuan);
            thang.setText(""+nthang);
            nam.setText(""+nnam);
            theki.setText(""+ntheki);
            thapki.setText(""+nthapki);
        }
        if(arrayList.get(i)=="yr"){
            nms= (float) (c*31556952006.783);
            ngiay= (float) (c*31556952.007);
            nphut= (float) (c*525949.2);
            ngio=(float) (c*8765.82);
            nngay= (float) (c*365.243);
            ntuan=(float) (c*52.178);
            nthang=(float)(c*12);
            nnam=c;
            nthapki=(float)(c*0.10006643842891);
            ntheki=(float)(c*0.010006643737701);
            ms.setText(""+nms);
            giay.setText(""+ngiay);
            phut.setText(""+nphut);
            gio.setText(""+ngio);
            ngay.setText(""+nngay);
            tuan.setText(""+ntuan);
            thang.setText(""+nthang);
            nam.setText(""+nnam);
            theki.setText(""+ntheki);
            thapki.setText(""+nthapki);
        }
        if(arrayList.get(i)=="dec"){
            nms= (float) (c*315359999838.54);
            ngiay= (float) (c*315359999.839);
            nphut= (float) (c*5255999.997);
            ngio=(float) (c*87600);
            nngay= (float) (c*3650);
            ntuan=(float) (c*521.429);
            nthang=(float)(c*119.92);
            nnam=(float)(c*9.993);
            nthapki=c;
            ntheki=(float)(c*0.0999999989488);
            ms.setText(""+nms);
            giay.setText(""+ngiay);
            phut.setText(""+nphut);
            gio.setText(""+ngio);
            ngay.setText(""+nngay);
            tuan.setText(""+ntuan);
            thang.setText(""+nthang);
            nam.setText(""+nnam);
            theki.setText(""+ntheki);
            thapki.setText(""+nthapki);
        }
        if(arrayList.get(i)=="ce"){
            nms= (float) (c*3153600031536.0);
            ngiay= (float) (c*3153600031.536);
            nphut= (float) (c*52560000.526);
            ngio=(float) (c*876000.009);
            nngay= (float) (c*36500);
            ntuan=(float) (c*5214.286);
            nthang=(float)(c*1199.203);
            nnam=(float)(c*99.934);
            nthapki=(float)(c*10);
            ntheki=c;
            ms.setText(""+nms);
            giay.setText(""+ngiay);
            phut.setText(""+nphut);
            gio.setText(""+ngio);
            ngay.setText(""+nngay);
            tuan.setText(""+ntuan);
            thang.setText(""+nthang);
            nam.setText(""+nnam);
            theki.setText(""+ntheki);
            thapki.setText(""+nthapki);
        }

    }
    public void reSet(){
        ms.setText("");
        giay.setText("");
        phut.setText("");
        gio.setText("");
        ngay.setText("");
        tuan.setText("");
        thang.setText("");
        nam.setText("");
        theki.setText("");
        thapki.setText("");
    }
}