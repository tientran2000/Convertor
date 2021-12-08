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

public class Vantoc extends AppCompatActivity {
    Spinner sp;
    TextView mms,ms,kms,kmh,mps,mph,fts,knot;
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
        setContentView(R.layout.activity_vantoc);
        Init();
        arrayList.add("mm/s");
        arrayList.add("m/s");

        arrayList.add("km/s");
        arrayList.add("km/h");
        arrayList.add("mps");
        arrayList.add("mph");
        arrayList.add("fts");
        arrayList.add("kn");

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
        kmh=findViewById(R.id.tvkmph);
        mms=findViewById(R.id.tvmmps);
        ms=findViewById(R.id.tvmps);
        mph=findViewById(R.id.tvmph);
        mps=findViewById(R.id.tvmips);
        fts=findViewById(R.id.tvfts);
        kms=findViewById(R.id.tvkmps);
        knot=findViewById(R.id.tvknot);
        cd=findViewById(R.id.edtchieudai);
        chuyen=findViewById(R.id.btchuyen);


        arrayList=new ArrayList<String>();
    }
    public void SetData(float c,int i){
        float skms,smms,sms,smph,skmh,sknot,smps,sfts;
        //float n=Float.valueOf(cd.getText().toString());
        if(arrayList.get(i)=="mm/s"){
            smms= (float) c;
            sms=(float)(c*0.001);
            skms= (float)(c*1.0E-6);
            skmh=(float) (c*3.6E-6);
            smps= (float) (c*6.21371E-7);
            smph= (float) (c*0.00224);
            sfts= (float) (c*0.00328);
            sknot=(float) (c*0.00194);
            kmh.setText(""+skmh);
            kms.setText(""+skms);
            mms.setText(""+smms);
            ms.setText(""+sms);
            mps.setText(""+smps);
            mph.setText(""+smph);
            fts.setText(""+sfts);
            knot.setText(""+sknot);
        }
        if(arrayList.get(i)=="m/s"){
            smms= (float) c*1000;
            sms=(float)c;
            skms= (float)(c*0.001);
            skmh=(float) (c*3.6);
            smps= (float) (c*0.00062);
            smph= (float) (c*2.23694);
            sfts= (float) (c*3.28084);
            sknot=(float) (c*194384);
            kmh.setText(""+skmh);
            kms.setText(""+skms);
            mms.setText(""+smms);
            ms.setText(""+sms);
            mps.setText(""+smps);
            mph.setText(""+smph);
            fts.setText(""+sfts);
            knot.setText(""+sknot);
        }
        if(arrayList.get(i)=="km/s"){
            smms= (float) c*1000000;
            sms=(float)(c*1000);
            skms= (float)c;
            skmh=(float) (c*3600);
            smps= (float) (c*0.62137);
            smph= (float) (c*2236.93629);
            sfts= (float) (c*3280.8399);
            sknot=(float) (c*1943.84449);
            kmh.setText(""+skmh);
            kms.setText(""+skms);
            mms.setText(""+smms);
            ms.setText(""+sms);
            mps.setText(""+smps);
            mph.setText(""+smph);
            fts.setText(""+sfts);
            knot.setText(""+sknot);
        }
        if(arrayList.get(i)=="km/h"){
            smms= (float) (c*277.77778);
            sms=(float)(c*0.27778);
            skms= (float)(c*0.00028);
            skmh=(float) c;
            smps= (float) (c*0.00017);
            smph= (float) (c*0.62137);
            sfts= (float) (c*0.91134);
            sknot=(float) (c*0.53996);
            kmh.setText(""+skmh);
            kms.setText(""+skms);
            mms.setText(""+smms);
            ms.setText(""+sms);
            mps.setText(""+smps);
            mph.setText(""+smph);
            fts.setText(""+sfts);
            knot.setText(""+sknot);
        }
        if(arrayList.get(i)=="mps"){
            smms= (float) (c*1609344);
            sms=(float)(c*1609.344);
            skms= (float)(c*1.60934);
            skmh=(float) (c*5793.6384);
            smps= (float) c;
            smph= (float) (c*3600);
            sfts= (float) (c*5280);
            sknot=(float) (c*3128.31447);
            kmh.setText(""+skmh);
            kms.setText(""+skms);
            mms.setText(""+smms);
            ms.setText(""+sms);
            mps.setText(""+smps);
            mph.setText(""+smph);
            fts.setText(""+sfts);
            knot.setText(""+sknot);
        }
        if(arrayList.get(i)=="mph"){
            smms= (float) (c*447.04);
            sms=(float)(c*0.44704);
            skms= (float)(c*0.00045);
            skmh=(float) (c*1.60934);
            smps= (float) (c*0.00028);
            smph= (float) c;
            sfts= (float) (c*1.46667);
            sknot=(float) (c*0.86898);
            kmh.setText(""+skmh);
            kms.setText(""+skms);
            mms.setText(""+smms);
            ms.setText(""+sms);
            mps.setText(""+smps);
            mph.setText(""+smph);
            fts.setText(""+sfts);
            knot.setText(""+sknot);
        }
        if(arrayList.get(i)=="fts"){
            smms= (float) (c*304.8);
            sms=(float)(c*0.3048);
            skms= (float)(c*0.0003);
            skmh=(float) (c*1.09728);
            smps= (float) (c*0.00019);
            smph= (float) (c*0.68182);
            sfts= (float) c;
            sknot=(float) (c*0.59248);
            kmh.setText(""+skmh);
            kms.setText(""+skms);
            mms.setText(""+smms);
            ms.setText(""+sms);
            mps.setText(""+smps);
            mph.setText(""+smph);
            fts.setText(""+sfts);
            knot.setText(""+sknot);
        }
        if(arrayList.get(i)=="kn"){
            smms= (float) (c*514.44444);
            sms=(float)(c*0.51444);
            skms= (float)(c*0.00051);
            skmh=(float) (c*1.852);
            smps= (float) (c*0.00032);
            smph= (float) (c*1.15078);
            sfts= (float) (c*1.68781);
            sknot=(float) c;
            kmh.setText(""+skmh);
            kms.setText(""+skms);
            mms.setText(""+smms);
            ms.setText(""+sms);
            mps.setText(""+smps);
            mph.setText(""+smph);
            fts.setText(""+sfts);
            knot.setText(""+sknot);
        }

    }
    public void reSet(){
        kmh.setText("");
        kms.setText("");
        mms.setText("");
        ms.setText("");
        mps.setText("");
        mph.setText("");
        fts.setText("");
        knot.setText("");
    }
}