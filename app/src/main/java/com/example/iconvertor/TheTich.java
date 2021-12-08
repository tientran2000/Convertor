package com.example.iconvertor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class TheTich extends AppCompatActivity {
    Spinner sp;
    TextView km,mm,l,m,ml,yd,in,ft,kl,gal,pt,fl;
    ArrayList<String> arrayList;
    ArrayAdapter adapter;
    EditText cd;
    Button chuyen;
    float n;
    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_tich);
        Init();
        arrayList.add("mm³");
        arrayList.add("m³");
        arrayList.add("km³");
        arrayList.add("ml");
        arrayList.add("l");
        arrayList.add("kl");
        arrayList.add("yd³");
        arrayList.add("ft³");
        arrayList.add("in³");
        arrayList.add("gal");
        arrayList.add("pt");
        arrayList.add("fl_oz");
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
        gal=findViewById(R.id.tvgallon);
        ml=findViewById(R.id.tvml);
        yd=findViewById(R.id.tvyard);
        ft=findViewById(R.id.tvfoot);
        in=findViewById(R.id.tvinch);
        kl=findViewById(R.id.tvkl);
        m=findViewById(R.id.tvm);
        pt=findViewById(R.id.tvpint);
        fl=findViewById(R.id.tvounce);
        l=findViewById(R.id.tvl);
        cd=findViewById(R.id.edtchieudai);
        chuyen=findViewById(R.id.btchuyen);


        arrayList=new ArrayList<String>();
    }
    public void SetData(float c,int i){
        float skm,smm,sml,sm,skl,syd,sin,sft,sl,sgal,spt,sfl;
        //float n=Float.valueOf(cd.getText().toString());
        if(arrayList.get(i)=="mm³"){
            skm= (float) (c*1.0E-18);
            smm=c;
            sm= (float) (c*1.0E-9);
            sml= (float) (c*0.001);;
            skl=(float) (c*1.0E-9);
            sl=(float) (c*1.0E-6);;
            sgal=(float) (c*2.64172E-7);;
            spt=(float) (c*2.113375999994E-6);;
            sfl=(float) (c*3.3814E-5);
            sin= (float) (c*6.10237E-5);
            syd= (float) (c*1.30795E-9);
            sft= (float) (c*3.53147E-8);
            km.setText(""+skm);
            mm.setText(""+smm);
            m.setText(""+sm);
            ft.setText(""+sft);
            yd.setText(""+syd);
            in.setText(""+sin);
            gal.setText(""+sgal);
            pt.setText(""+spt);
            fl.setText(""+sfl);
            ml.setText(""+sml);
            kl.setText(""+skl);
            l.setText(""+sl);

        }
        if(arrayList.get(i)=="m³"){
            skm= (float) (c*1.0E-9);
            smm=(float) (c*1000000000);
            sm= c;
            sml= (float) (c*1000000);;
            skl=c;
            sl=(float) (c*1000);;
            sgal=(float) (c*264.172);;
            spt=(float) (c*2113.376);;
            sfl=(float) (c*33814);
            sin= (float) (c*61023.7);
            syd= (float) (c*1.308);
            sft= (float) (c*35.315);
            km.setText(""+skm);
            mm.setText(""+smm);
            m.setText(""+sm);
            ft.setText(""+sft);
            yd.setText(""+syd);
            in.setText(""+sin);
            gal.setText(""+sgal);
            pt.setText(""+spt);
            fl.setText(""+sfl);
            ml.setText(""+sml);
            kl.setText(""+skl);
            l.setText(""+sl);

        }if(arrayList.get(i)=="km³"){
            skm= c;
            smm=(float)(c*1.0E+18);
            sm= (float) (c*1000000000);
            sml=(float)(c*1.0E+15);
            skl=(float) (c*1000000000);
            sl= (float) (c*1000000000000.0);
            sgal= (float) (c*264172000000.0);
            spt=(float) (c*2113375999994.0);
            sfl=(float) (c*33814000000000.0);
            sin= (float) (c*61023700000000.0);
            syd= (float) (c*1307950000);
            sft= (float) (c*35314700000.0);
            km.setText(""+skm);
            mm.setText(""+smm);
            m.setText(""+sm);
            ft.setText(""+sft);
            yd.setText(""+syd);
            in.setText(""+sin);
            gal.setText(""+sgal);
            pt.setText(""+spt);
            fl.setText(""+sfl);
            ml.setText(""+sml);
            kl.setText(""+skl);
            l.setText(""+sl);

        }if(arrayList.get(i)=="ml"){
            skm= (float) (c*1.0E-15);
            smm=c*1000;
            sm= (float) (c*1.0E-6);
            sml= c;
            skl=(float) (c*1.0E-6);
            sl= (float) (c*0.001);
            sgal= (float) (c*0.000264172);
            spt=(float) (c*0.002113375999994);
            sfl=(float)(c*0.033814);
            sin= (float) (c*0.0610237);
            syd= (float) (c*1.30795E-6);
            sft= (float) (c*3.53147E-5);
            km.setText(""+skm);
            mm.setText(""+smm);
            m.setText(""+sm);
            ft.setText(""+sft);
            yd.setText(""+syd);
            in.setText(""+sin);
            gal.setText(""+sgal);
            pt.setText(""+spt);
            fl.setText(""+sfl);
            ml.setText(""+sml);
            kl.setText(""+skl);
            l.setText(""+sl);

        }if(arrayList.get(i)=="l"){
            skm= (float) (c*1.0E-12);
            smm=c*1000000;
            sm= (float) (c*0.001);
            sml= c*1000;
            skl=(float) (c*0.001);
            sl= c;
            sgal= (float) (c*0.264172);
            spt=(float) (c*2.113);
            sfl=(float)(c*33.814);
            sin= (float) (c*61.024);
            syd= (float) (c*0.00130795);
            sft= (float) (c*0.0353147);
            km.setText(""+skm);
            mm.setText(""+smm);
            m.setText(""+sm);
            ft.setText(""+sft);
            yd.setText(""+syd);
            in.setText(""+sin);
            gal.setText(""+sgal);
            pt.setText(""+spt);
            fl.setText(""+sfl);
            ml.setText(""+sml);
            kl.setText(""+skl);
            l.setText(""+sl);

        }if(arrayList.get(i)=="kl"){
            skm= (float) (c*1.0E-9);
            smm=(float) (c*1000000000);
            sm= c;
            sml= (float) (c*1000000);;
            skl=c;
            sl=(float) (c*1000);;
            sgal=(float) (c*264.172);;
            spt=(float) (c*2113.376);;
            sfl=(float) (c*33814);
            sin= (float) (c*61023.7);
            syd= (float) (c*1.308);
            sft= (float) (c*35.315);
            km.setText(""+skm);
            mm.setText(""+smm);
            m.setText(""+sm);
            ft.setText(""+sft);
            yd.setText(""+syd);
            in.setText(""+sin);
            gal.setText(""+sgal);
            pt.setText(""+spt);
            fl.setText(""+sfl);
            ml.setText(""+sml);
            kl.setText(""+skl);
            l.setText(""+sl);

        }if(arrayList.get(i)=="yd³"){
            skm= (float) (c*7.6455522000076E-10);
            smm=(float) (c*764555220.001);;
            sm= (float) (c*0.76455522000076);
            sml= (float) (c*764555.22);;
            skl=(float) (c*0.76455522000076);
            sl=(float) (c*764.555);;
            sgal=(float) (c*201.974);;
            spt=(float) (c*1615.793);;
            sfl=(float) (c*25852.67);
            sin= (float) (c*46655.988);
            syd= c;
            sft= (float) (c*27);
            km.setText(""+skm);
            mm.setText(""+smm);
            m.setText(""+sm);
            ft.setText(""+sft);
            yd.setText(""+syd);
            in.setText(""+sin);
            gal.setText(""+sgal);
            pt.setText(""+spt);
            fl.setText(""+sfl);
            ml.setText(""+sml);
            kl.setText(""+skl);
            l.setText(""+sl);

        }if(arrayList.get(i)=="in³"){
            skm= (float) (c*1.6387075841026E-14);
            smm= (float) (c*16387.076);
            sm= (float) (c*1.6387075841026E-5);
            sml= (float) (c*16.387);
            skl=(float) (c*1.6387075841026E-5);
            sl= (float) (c*0.016387075841026);
            sgal= (float) (c*0.0043290065990754);
            spt=(float) (c*0.034632052792505);
            sfl=(float)(c*0.55411258248844);
            sin= c;
            syd= (float) (c*2.143347584627E-5);
            sft= (float) (c*0.00057870466720307);
            km.setText(""+skm);
            mm.setText(""+smm);
            m.setText(""+sm);
            ft.setText(""+sft);
            yd.setText(""+syd);
            in.setText(""+sin);
            gal.setText(""+sgal);
            pt.setText(""+spt);
            fl.setText(""+sfl);
            ml.setText(""+sml);
            kl.setText(""+skl);
            l.setText(""+sl);

        }if(arrayList.get(i)=="ft³"){
            skm= (float) (c*2.8316819907857E-11);
            smm=(float) (c*28316819.908);
            sm= (float) (c*0.028316819907857);
            sml= (float) (c*28316.82);;
            skl= (float) (c*0.028316819907857);
            sl=(float) (c*28.317);;
            sgal=(float) (c*7.481);;
            spt=(float) (c*59.844);;
            sfl=(float) (c*957.505);
            sin= (float) (c*1727.997);
            syd= (float) (c*0.037036984598482);
            sft= c;
            km.setText(""+skm);
            mm.setText(""+smm);
            m.setText(""+sm);
            ft.setText(""+sft);
            yd.setText(""+syd);
            in.setText(""+sin);
            gal.setText(""+sgal);
            pt.setText(""+spt);
            fl.setText(""+sfl);
            ml.setText(""+sml);
            kl.setText(""+skl);
            l.setText(""+sl);

        }if(arrayList.get(i)=="gal"){
            skm= (float) (c*3.785412534258E-12);
            smm=(float) (c*3785412.534);
            sm= (float) (c*0.003785412534258);
            sml= (float) (c*3785.413);;
            skl= (float) (c*0.003785412534258);
            sl=(float) (c*3.785);
            sgal=c;
            spt=(float) (c*8);;
            sfl=(float) (c*128);
            sin= (float) (c*231);
            syd= (float) (c*0.0049511303241827);
            sft= (float) (c*0.13368070802356);
            km.setText(""+skm);
            mm.setText(""+smm);
            m.setText(""+sm);
            ft.setText(""+sft);
            yd.setText(""+syd);
            in.setText(""+sin);
            gal.setText(""+sgal);
            pt.setText(""+spt);
            fl.setText(""+sfl);
            ml.setText(""+sml);
            kl.setText(""+skl);
            l.setText(""+sl);

        }
        if(arrayList.get(i)=="pt"){
            skm= (float) (c*4.731765667836E-13);
            smm=(float) (c*473176.567);
            sm= (float) (c*0.0004731765667836);
            sml= (float) (c*473.177);;
            skl= (float) (c*0.0004731765667836);
            sl=(float) (c*0.4731765667836);;
            sgal= (float) (c*0.12500000000036);;
            spt=c;
            sfl=(float) (c*16);
            sin= (float) (c*28.875);
            syd= (float) (c*0.0006188912905246);
            sft= (float) (c*0.016710088502993);
            km.setText(""+skm);
            mm.setText(""+smm);
            m.setText(""+sm);
            ft.setText(""+sft);
            yd.setText(""+syd);
            in.setText(""+sin);
            gal.setText(""+sgal);
            pt.setText(""+spt);
            fl.setText(""+sfl);
            ml.setText(""+sml);
            kl.setText(""+skl);
            l.setText(""+sl);

        }
        if(arrayList.get(i)=="fl_oz"){
            skm= (float) (c*2.9573549417401E-14);
            smm=(float) (c*29573.549);
            sm= (float) (c*2.9573549417401E-5);
            sml= (float) (c*29.574);;
            skl= (float) (c*2.9573549417401E-5);
            sl=(float) (c*0.029573549417401);;
            sgal=(float) (c*0.0078125036966937);;
            spt=(float) (c*0.062500029573371);;
            sfl=c;
            sin= (float) (c*1.805);
            syd= (float) (c*3.868072396049E-5);
            sft= (float) (c*0.0010443810256107);
            km.setText(""+skm);
            mm.setText(""+smm);
            m.setText(""+sm);
            ft.setText(""+sft);
            yd.setText(""+syd);
            in.setText(""+sin);
            gal.setText(""+sgal);
            pt.setText(""+spt);
            fl.setText(""+sfl);
            ml.setText(""+sml);
            kl.setText(""+skl);
            l.setText(""+sl);

        }
    }
    public void reSet(){
        km.setText("");
        mm.setText("");
        m.setText("");
        ft.setText("");
        yd.setText("");
        in.setText("");
        gal.setText("");
        pt.setText("");
        fl.setText("");
        ml.setText("");
        kl.setText("");
        l.setText("");
    }

}