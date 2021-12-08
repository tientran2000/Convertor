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

public class Apsuat extends AppCompatActivity {
    Spinner sp;
    TextView pa,npm,kpa,mpa,bar,mbar,ksi,psi,cmh2o,atm,cmhg,torr;
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
        setContentView(R.layout.activity_apsuat);
        Init();
        arrayList.add("Pa");
        arrayList.add("kPa");
        arrayList.add("MPa");
        arrayList.add("N/m²");
        arrayList.add("Bar");
        arrayList.add("mmBar");
        arrayList.add("ksi");
        arrayList.add("psi");
        arrayList.add("cmH2O");
        arrayList.add("atm");
        arrayList.add("cmHg");
        arrayList.add("torr");


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
        pa=findViewById(R.id.tvpa);
        npm=findViewById(R.id.tvnpm);
        kpa=findViewById(R.id.tvkpa);
        mpa=findViewById(R.id.tvmpa);
        bar=findViewById(R.id.tvBar);
        mbar=findViewById(R.id.tvmilibar);
        ksi=findViewById(R.id.tvksi);
        psi=findViewById(R.id.tvpsi);
        cmh2o=findViewById(R.id.tvmh2o);
        atm=findViewById(R.id.tvatm);
        cmhg=findViewById(R.id.tvmmhg);
        torr=findViewById(R.id.tvtorr);

        cd=findViewById(R.id.edtchieudai);
        chuyen=findViewById(R.id.btchuyen);


        arrayList=new ArrayList<String>();
    }
    public void SetData(float c,int i){
        float spa,skpa,smpa,snpm,smbar,sbar,sksi,spsi,scmh2o,satm,scmhg,storr;
        //float n=Float.valueOf(cd.getText().toString());
        if(arrayList.get(i)=="Pa"){
            spa= (float) (c);
            skpa=(float)(c*0.001 );
            smpa= (float)(c*1.0E-6);
            snpm=(float) (c);
            smbar= (float) (c*0.01 );
            sbar= (float) (c*0.0001);
            sksi= (float) (c*145038E-7);
            spsi= (float) (c*0.00015);
            scmh2o= (float) (c*0.01 );
            satm= (float) (c*0.00001);
            scmhg= (float) (c*0.00075);
            storr= (float) (c*0.0075);

            pa.setText(""+spa);
            npm.setText(""+snpm);
            kpa.setText(""+skpa);
            mpa.setText(""+smpa);
            bar.setText(""+sbar);
            mbar.setText(""+smbar);
            ksi.setText(""+sksi);
            psi.setText(""+spsi);
            cmh2o.setText(""+scmh2o);
            atm.setText(""+satm);
            cmhg.setText(""+scmhg);
            torr.setText(""+storr);
        }

        if(arrayList.get(i)=="kPa"){
            spa= (float) (c*1000);
            skpa=(float)(c);
            smpa= (float)(c*0.001);
            snpm=(float) (c*1000);
            smbar= (float) (c*10);
            sbar= (float) (c*0.01);
            sksi= (float) (c*0.00015);
            spsi= (float) (c*0.14504);
            scmh2o= (float) (c*10.19744);
            satm= (float) (c*0.00987);
            scmhg= (float) (c*0.75006);
            storr= (float) (c*7.50064);

            pa.setText(""+spa);
            npm.setText(""+snpm);
            kpa.setText(""+skpa);
            mpa.setText(""+smpa);
            bar.setText(""+sbar);
            mbar.setText(""+smbar);
            ksi.setText(""+sksi);
            psi.setText(""+spsi);
            cmh2o.setText(""+scmh2o);
            atm.setText(""+satm);
            cmhg.setText(""+scmhg);
            torr.setText(""+storr);
        }
        if(arrayList.get(i)=="MPa"){
            spa= (float) (c*1000000);
            skpa=(float)(c*1000);
            smpa= (float)(c);
            snpm=(float) (c*1000000);
            smbar= (float) (c*10000);
            sbar= (float) (c*10);
            sksi= (float) (c*0.14504);
            spsi= (float) (c*145.0377);
            scmh2o= (float) (c*10197.44289);
            satm= (float) (c*9.86923);
            scmhg= (float) (c*750.0638);
            storr= (float) (c*7500.638);

            pa.setText(""+spa);
            npm.setText(""+snpm);
            kpa.setText(""+skpa);
            mpa.setText(""+smpa);
            bar.setText(""+sbar);
            mbar.setText(""+smbar);
            ksi.setText(""+sksi);
            psi.setText(""+spsi);
            cmh2o.setText(""+scmh2o);
            atm.setText(""+satm);
            cmhg.setText(""+scmhg);
            torr.setText(""+storr);
        }
        if(arrayList.get(i)=="N/m²"){
            spa= (float) (c);
            skpa=(float)(c*0.001 );
            smpa= (float)(c*1.0E-6);
            snpm=(float) (c);
            smbar= (float) (c*0.01 );
            sbar= (float) (c*0.0001);
            sksi= (float) (c*145038E-7);
            spsi= (float) (c*0.00015);
            scmh2o= (float) (c*0.01 );
            satm= (float) (c*0.00001);
            scmhg= (float) (c*0.00075);
            storr= (float) (c*0.0075);

            pa.setText(""+spa);
            npm.setText(""+snpm);
            kpa.setText(""+skpa);
            mpa.setText(""+smpa);
            bar.setText(""+sbar);
            mbar.setText(""+smbar);
            ksi.setText(""+sksi);
            psi.setText(""+spsi);
            cmh2o.setText(""+scmh2o);
            atm.setText(""+satm);
            cmhg.setText(""+scmhg);
            torr.setText(""+storr);
        }
        if(arrayList.get(i)=="mmBar"){
            spa= (float) (c*100);
            skpa=(float)(c*0.1);
            smpa= (float)(c*0.0001);
            snpm=(float) (c*100);
            smbar= (float) (c);
            sbar= (float) (c*0.001);
            sksi= (float) (c*0.00001);
            spsi= (float) (c*0.0145);
            scmh2o= (float) (c*1.01974);
            satm= (float) (c*0.00099);
            scmhg= (float) (c*0.07501);
            storr= (float) (c*0.75006);

            pa.setText(""+spa);
            npm.setText(""+snpm);
            kpa.setText(""+skpa);
            mpa.setText(""+smpa);
            bar.setText(""+sbar);
            mbar.setText(""+smbar);
            ksi.setText(""+sksi);
            psi.setText(""+spsi);
            cmh2o.setText(""+scmh2o);
            atm.setText(""+satm);
            cmhg.setText(""+scmhg);
            torr.setText(""+storr);
        }
        if(arrayList.get(i)=="Bar"){
            spa= (float) (c*100000);
            skpa=(float)(c*100);
            smpa= (float)(c*0.1);
            snpm=(float) (c*100000);
            smbar= (float) (c*1000);
            sbar= (float) (c);
            sksi= (float) (c*0.0145);
            spsi= (float) (c*14.50377);
            scmh2o= (float) (c*1019.74429);
            satm= (float) (c*0.98692);
            scmhg= (float) (c*75.00638);
            storr= (float) (c*750.0638);

            pa.setText(""+spa);
            npm.setText(""+snpm);
            kpa.setText(""+skpa);
            mpa.setText(""+smpa);
            bar.setText(""+sbar);
            mbar.setText(""+smbar);
            ksi.setText(""+sksi);
            psi.setText(""+spsi);
            cmh2o.setText(""+scmh2o);
            atm.setText(""+satm);
            cmhg.setText(""+scmhg);
            torr.setText(""+storr);
        }
        if(arrayList.get(i)=="ksi"){
            spa= (float) (c*6.89476E6);
            skpa=(float)(c*6894.75909);
            smpa= (float)(c*6.89476);
            snpm=(float) (c*6.89476E6);
            smbar= (float) (c*68947.59087);
            sbar= (float) (c*68.94759);
            sksi= (float) (c);
            spsi= (float) (c*1000);
            scmh2o= (float) (c*70308.91202);
            satm= (float) (c*68.04598);
            scmhg= (float) (c*5171.5092);
            storr= (float) (c*51715.09201);

            pa.setText(""+spa);
            npm.setText(""+snpm);
            kpa.setText(""+skpa);
            mpa.setText(""+smpa);
            bar.setText(""+sbar);
            mbar.setText(""+smbar);
            ksi.setText(""+sksi);
            psi.setText(""+spsi);
            cmh2o.setText(""+scmh2o);
            atm.setText(""+satm);
            cmhg.setText(""+scmhg);
            torr.setText(""+storr);
        }
        if(arrayList.get(i)=="psi"){
            spa= (float) (c*6894.75909);
            skpa=(float)(c*6.89476);
            smpa= (float)(c*0.00689);
            snpm=(float) (c*6894.75909);
            smbar= (float) (c*68.94759);
            sbar= (float) (c*0.06895);
            sksi= (float) (c*0.001);
            spsi= (float) (c);
            scmh2o= (float) (c*70.30891);
            satm= (float) (c*0.06805);
            scmhg= (float) (c*5.17151);
            storr= (float) (c*51.71509);

            pa.setText(""+spa);
            npm.setText(""+snpm);
            kpa.setText(""+skpa);
            mpa.setText(""+smpa);
            bar.setText(""+sbar);
            mbar.setText(""+smbar);
            ksi.setText(""+sksi);
            psi.setText(""+spsi);
            cmh2o.setText(""+scmh2o);
            atm.setText(""+satm);
            cmhg.setText(""+scmhg);
            torr.setText(""+storr);
        }
        if(arrayList.get(i)=="cmH2O"){
            spa= (float) (c*98.0638);
            skpa=(float)(c*0.09806);
            smpa= (float)(c*0.0001);
            snpm=(float) (c*98.0638);
            smbar= (float) (c*0.98064);
            sbar= (float) (c*0.00098);
            sksi= (float) (c*0.00001);
            spsi= (float) (c*0.01422);
            scmh2o= (float) (c);
            satm= (float) (c*0.00097);
            scmhg= (float) (c*0.07355);
            storr= (float) (c*0.73554);

            pa.setText(""+spa);
            npm.setText(""+snpm);
            kpa.setText(""+skpa);
            mpa.setText(""+smpa);
            bar.setText(""+sbar);
            mbar.setText(""+smbar);
            ksi.setText(""+sksi);
            psi.setText(""+spsi);
            cmh2o.setText(""+scmh2o);
            atm.setText(""+satm);
            cmhg.setText(""+scmhg);
            torr.setText(""+storr);
        }
        if(arrayList.get(i)=="atm"){
            spa= (float) (c*101324.99658);
            skpa=(float)(c*101.325);
            smpa= (float)(c*0.10132);
            snpm=(float) (c*101324.99658);
            smbar= (float) (c*1013.24997);
            sbar= (float) (c*1.01325);
            sksi= (float) (c*0.0147);
            spsi= (float) (c*14.69594);
            scmh2o= (float) (c*1033.25587);
            satm= (float) (c);
            scmhg= (float) (c*76.00021);
            storr= (float) (c*760.00212);

            pa.setText(""+spa);
            npm.setText(""+snpm);
            kpa.setText(""+skpa);
            mpa.setText(""+smpa);
            bar.setText(""+sbar);
            mbar.setText(""+smbar);
            ksi.setText(""+sksi);
            psi.setText(""+spsi);
            cmh2o.setText(""+scmh2o);
            atm.setText(""+satm);
            cmhg.setText(""+scmhg);
            torr.setText(""+storr);
        }
        if(arrayList.get(i)=="cmHg"){
            spa= (float) (c*1333.21992);
            skpa=(float)(c*1.33322);
            smpa= (float)(c*0.00133);
            snpm=(float) (c*1333.21992);
            smbar= (float) (c*13.3322);
            sbar= (float) (c*0.01333);
            sksi= (float) (c*0.00019);
            spsi= (float) (c*0.19337);
            scmh2o= (float) (c*13.59543);
            satm= (float) (c*0.01316);
            scmhg= (float) (c);
            storr= (float) (c*10);

            pa.setText(""+spa);
            npm.setText(""+snpm);
            kpa.setText(""+skpa);
            mpa.setText(""+smpa);
            bar.setText(""+sbar);
            mbar.setText(""+smbar);
            ksi.setText(""+sksi);
            psi.setText(""+spsi);
            cmh2o.setText(""+scmh2o);
            atm.setText(""+satm);
            cmhg.setText(""+scmhg);
            torr.setText(""+storr);
        }
        if(arrayList.get(i)=="torr"){
            spa= (float) (c*133.321992);
            skpa=(float)(c*0.133322);
            smpa= (float)(c*0.000133);
            snpm=(float) (c*133.321992);
            smbar= (float) (c*1.33322);
            sbar= (float) (c*0.001333);
            sksi= (float) (c*0.000019);
            spsi= (float) (c*0.019337);
            scmh2o= (float) (c*1.359543);
            satm= (float) (c*0.001316);
            scmhg= (float) (c*0.1);
            storr= (float) (c);

            pa.setText(""+spa);
            npm.setText(""+snpm);
            kpa.setText(""+skpa);
            mpa.setText(""+smpa);
            bar.setText(""+sbar);
            mbar.setText(""+smbar);
            ksi.setText(""+sksi);
            psi.setText(""+spsi);
            cmh2o.setText(""+scmh2o);
            atm.setText(""+satm);
            cmhg.setText(""+scmhg);
            torr.setText(""+storr);
        }


    }
    public void reSet(){
        pa.setText("");
        npm.setText("");
        kpa.setText("");
        mpa.setText("");
        bar.setText("");
        mbar.setText("");
        ksi.setText("");
        psi.setText("");
        cmh2o.setText("");
        atm.setText("");
        cmhg.setText("");
        torr.setText("");
    }
}