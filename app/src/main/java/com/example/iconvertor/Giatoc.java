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

public class Giatoc extends AppCompatActivity {
    Spinner sp;
    TextView cms,ms,ins,gal,g,fts;
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
        setContentView(R.layout.activity_giatoc);
        Init();
        arrayList.add("cm/s²");
        arrayList.add("m/s²");

        arrayList.add("in/s²");
        arrayList.add("ft/s²");
        arrayList.add("gal");
        arrayList.add("g");

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
        cms=findViewById(R.id.tvcmpss);
        gal=findViewById(R.id.tvgal);
        ms=findViewById(R.id.tvmpss);
        g=findViewById(R.id.tvdvg);
        ins=findViewById(R.id.tvinss);
        fts=findViewById(R.id.tvftss);

        cd=findViewById(R.id.edtchieudai);
        chuyen=findViewById(R.id.btchuyen);


        arrayList=new ArrayList<String>();
    }
    public void SetData(float c,int i){
        float scms,sgal,sms,sg,sins,sfts;
        //float n=Float.valueOf(cd.getText().toString());
        if(arrayList.get(i)=="cm/s²"){
            scms= (float) c;
            sms=(float)(c*0.01);
            sins= (float)(c*0.394);
            sfts=(float) (c*0.033);
            sg= (float) (c*0.001);
            sgal= (float) (c);

            ms.setText(""+sms);
            cms.setText(""+scms);
            g.setText(""+sg);
            ins.setText(""+sins);
            gal.setText(""+sgal);
            fts.setText(""+sfts);
        }
        if(arrayList.get(i)=="m/s²"){
            scms= (float) c*36;
            sms=(float)(c*1);
            sins= (float)(c*0.37);
            sfts=(float) (c*3.281 );
            sg= (float) (c*0.102 );
            sgal= (float) (c*100);

            ms.setText(""+sms);
            cms.setText(""+scms);
            g.setText(""+sg);
            ins.setText(""+sins);
            gal.setText(""+sgal);
            fts.setText(""+sfts);
        }
        if(arrayList.get(i)=="in/s²"){
            scms= (float) (c*2.54 );
            sms=(float)(c*0.025 );
            sins= (float)(c);
            sfts=(float) (c*0.083);
            sg= (float) (c*0.003);
            sgal= (float) (c*2.54 );

            ms.setText(""+sms);
            cms.setText(""+scms);
            g.setText(""+sg);
            ins.setText(""+sins);
            gal.setText(""+sgal);
            fts.setText(""+sfts);
        }
        if(arrayList.get(i)=="ft/s²"){
            scms= (float) (c*980.665 );
            sms=(float)(c*9.807 );
            sins= (float)(c*386.089);
            sfts=(float) (c);
            sg= (float) (c);
            sgal= (float) (c*980.665 );

            ms.setText(""+sms);
            cms.setText(""+scms);
            g.setText(""+sg);
            ins.setText(""+sins);
            gal.setText(""+sgal);
            fts.setText(""+sfts);
        }
        if(arrayList.get(i)=="gal"){
            scms= (float) c;
            sms=(float)(c*0.01);
            sins= (float)(c*0.394);
            sfts=(float) (c*0.033);
            sg= (float) (c*0.001);
            sgal= (float) (c);

            ms.setText(""+sms);
            cms.setText(""+scms);
            g.setText(""+sg);
            ins.setText(""+sins);
            gal.setText(""+sgal);
            fts.setText(""+sfts);
        }
        if(arrayList.get(i)=="g"){
            scms= (float) (c*980.665);
            sms=(float)(c*9.807 );
            sins= (float)(c*386.089 );
            sfts=(float) (c*32.174);
            sg= (float) (c);
            sgal= (float) (c*980.665);

            ms.setText(""+sms);
            cms.setText(""+scms);
            g.setText(""+sg);
            ins.setText(""+sins);
            gal.setText(""+sgal);
            fts.setText(""+sfts);
        }


    }
    public void reSet(){
        ms.setText("");
        cms.setText("");
        g.setText("");
        ins.setText("");
        gal.setText("");
        fts.setText("");
    }
}