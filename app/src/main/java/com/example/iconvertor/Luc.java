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

public class Luc extends AppCompatActivity {
    Spinner sp;
    TextView mnewton,newton,knewton,dyn,jpm,papm,kip,ozf,gf;
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
        arrayList.add("mN");
        arrayList.add("N");
        arrayList.add("kN");
        arrayList.add("dyn");
        arrayList.add("J/m");
        arrayList.add("Pa/m²");
        arrayList.add("kip");
        arrayList.add("ozf");
        arrayList.add("Gf");

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
        mnewton=findViewById(R.id.tvmn);
        newton=findViewById(R.id.tvn);
        knewton=findViewById(R.id.tvkn);
        dyn=findViewById(R.id.tvdyn);
        jpm=findViewById(R.id.tvjpm);
        papm=findViewById(R.id.tvpapm);
        kip=findViewById(R.id.tvkip);
        ozf=findViewById(R.id.tvozf);
        gf=findViewById(R.id.tvgf);

        cd=findViewById(R.id.edtchieudai);
        chuyen=findViewById(R.id.btchuyen);


        arrayList=new ArrayList<String>();
    }
    public void SetData(float c,int i){
        float smnewton,snewton,sknewton,sdyn,sjpm,spapm,skip,sozf,sgf;
        //float n=Float.valueOf(cd.getText().toString());
        if(arrayList.get(i)=="mN"){
            smnewton= (float) (c);
            snewton=(float) (c*0.001 );
            sknewton= (float) (c*1.0E-6);
            sdyn=(float)(c*100);
            sjpm=(float)(c*0.001);
            spapm=(float)(c*0.001);
            skip=(float)(c*2.24809E-7);
            sozf=(float)(c*0.0036);
            sgf=(float)(c*0.0001);

            mnewton.setText(""+smnewton);
            newton.setText(""+snewton);
            knewton.setText(""+sknewton);
            dyn.setText(""+sdyn);
            jpm.setText(""+sjpm);
            papm.setText(""+spapm);
            kip.setText(""+skip);
            ozf.setText(""+sozf);
            gf.setText(""+sgf);
        }
        if(arrayList.get(i)=="N"){
            smnewton= (float) (c*1000);
            snewton=(float) (c);
            sknewton= (float) (c*1.0E-3);
            sdyn=(float)(c*100000);
            sjpm=(float)(c);
            spapm=(float)(c);
            skip=(float)(c*0.00022);
            sozf=(float)(c*3.59694);
            sgf=(float)(c*0.10197);

            mnewton.setText(""+smnewton);
            newton.setText(""+snewton);
            knewton.setText(""+sknewton);
            dyn.setText(""+sdyn);
            jpm.setText(""+sjpm);
            papm.setText(""+spapm);
            kip.setText(""+skip);
            ozf.setText(""+sozf);
            gf.setText(""+sgf);
        }
        if(arrayList.get(i)=="kN"){
            smnewton= (float) (c*1000000);
            snewton=(float) (c*1000 );
            sknewton= (float) (c);
            sdyn=(float)(c*100000000);
            sjpm=(float)(c*1000);
            spapm=(float)(c*1000);
            skip=(float)(c*0.22481);
            sozf=(float)(c*3596.94309);
            sgf=(float)(c*101.97162);

            mnewton.setText(""+smnewton);
            newton.setText(""+snewton);
            knewton.setText(""+sknewton);
            dyn.setText(""+sdyn);
            jpm.setText(""+sjpm);
            papm.setText(""+spapm);
            kip.setText(""+skip);
            ozf.setText(""+sozf);
            gf.setText(""+sgf);
        }
        if(arrayList.get(i)=="dyn"){
            smnewton= (float) (c*0.01);
            snewton=(float) (c*0.00001 );
            sknewton= (float) (c*1.0E-8);
            sdyn=(float)(c);
            sjpm=(float)(c*0.00001);
            spapm=(float)(c*0.00001);
            skip=(float)(c*2.24809E-9);
            sozf=(float)(c*0.00004);
            sgf=(float)(c*1.01972E-6);

            mnewton.setText(""+smnewton);
            newton.setText(""+snewton);
            knewton.setText(""+sknewton);
            dyn.setText(""+sdyn);
            jpm.setText(""+sjpm);
            papm.setText(""+spapm);
            kip.setText(""+skip);
            ozf.setText(""+sozf);
            gf.setText(""+sgf);
        }
        if(arrayList.get(i)=="J/m"){
            smnewton= (float) (c*1000);
            snewton=(float) (c);
            sknewton= (float) (c*1.0E-3);
            sdyn=(float)(c*100000);
            sjpm=(float)(c);
            spapm=(float)(c);
            skip=(float)(c*0.00022);
            sozf=(float)(c*3.59694);
            sgf=(float)(c*0.10197);

            mnewton.setText(""+smnewton);
            newton.setText(""+snewton);
            knewton.setText(""+sknewton);
            dyn.setText(""+sdyn);
            jpm.setText(""+sjpm);
            papm.setText(""+spapm);
            kip.setText(""+skip);
            ozf.setText(""+sozf);
            gf.setText(""+sgf);
        }
        if(arrayList.get(i)=="Pa/m²"){
            smnewton= (float) (c*1000);
            snewton=(float) (c);
            sknewton= (float) (c*1.0E-3);
            sdyn=(float)(c*100000);
            sjpm=(float)(c);
            spapm=(float)(c);
            skip=(float)(c*0.00022);
            sozf=(float)(c*3.59694);
            sgf=(float)(c*0.10197);

            mnewton.setText(""+smnewton);
            newton.setText(""+snewton);
            knewton.setText(""+sknewton);
            dyn.setText(""+sdyn);
            jpm.setText(""+sjpm);
            papm.setText(""+spapm);
            kip.setText(""+skip);
            ozf.setText(""+sozf);
            gf.setText(""+sgf);
        }
        if(arrayList.get(i)=="kip"){
            smnewton= (float) (c*4.44822E6);
            snewton=(float) (c*4448.22162 );
            sknewton= (float) (c*4.44822162);
            sdyn=(float)(c*100);
            sjpm=(float)(c*4448.22162);
            spapm=(float)(c*4448.22162);
            skip=(float)(c);
            sozf=(float)(c*16000);
            sgf=(float)(c*453.59237);

            mnewton.setText(""+smnewton);
            newton.setText(""+snewton);
            knewton.setText(""+sknewton);
            dyn.setText(""+sdyn);
            jpm.setText(""+sjpm);
            papm.setText(""+spapm);
            kip.setText(""+skip);
            ozf.setText(""+sozf);
            gf.setText(""+sgf);
        }
        if(arrayList.get(i)=="ozf"){
            smnewton= (float) (c*278.01385);
            snewton=(float) (c*0.27801 );
            sknewton= (float) (c*0.00028);
            sdyn=(float)(c*27801.3851);
            sjpm=(float)(c*0.27801);
            spapm=(float)(c*0.27801);
            skip=(float)(c*0.00006);
            sozf=(float)(c);
            sgf=(float)(c*0.02835);

            mnewton.setText(""+smnewton);
            newton.setText(""+snewton);
            knewton.setText(""+sknewton);
            dyn.setText(""+sdyn);
            jpm.setText(""+sjpm);
            papm.setText(""+spapm);
            kip.setText(""+skip);
            ozf.setText(""+sozf);
            gf.setText(""+sgf);
        }
        if(arrayList.get(i)=="Gf"){
            smnewton= (float) (c*9806.65);
            snewton=(float) (c*9.80665 );
            sknewton= (float) (c*0.00981);
            sdyn=(float)(c*980665);
            sjpm=(float)(c*9.80665);
            spapm=(float)(c*9.80665);
            skip=(float)(c*0.0022);
            sozf=(float)(c*35.27396);
            sgf=(float)(c);

            mnewton.setText(""+smnewton);
            newton.setText(""+snewton);
            knewton.setText(""+sknewton);
            dyn.setText(""+sdyn);
            jpm.setText(""+sjpm);
            papm.setText(""+spapm);
            kip.setText(""+skip);
            ozf.setText(""+sozf);
            gf.setText(""+sgf);
        }

    }
    public void reSet(){
        mnewton.setText("");
        newton.setText("");
        knewton.setText("");
        dyn.setText("");
        jpm.setText("");
        papm.setText("");
        kip.setText("");
        ozf.setText("");
        gf.setText("");
    }
}