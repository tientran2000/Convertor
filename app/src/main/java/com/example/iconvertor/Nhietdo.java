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

public class Nhietdo extends AppCompatActivity {
    Spinner sp;
    TextView doc,dok,dor,dof,rankine;
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
        setContentView(R.layout.activity_nhietdo);
        Init();
        arrayList.add("ºC");
        arrayList.add("ºF");
        arrayList.add("K");
        arrayList.add("ºR");
        arrayList.add("Rankine");

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
        doc=findViewById(R.id.tvdoc);
        dok=findViewById(R.id.tvdok);
        dof=findViewById(R.id.tvdof);
        dor=findViewById(R.id.tvdor);
        rankine=findViewById(R.id.tvrankine);

        cd=findViewById(R.id.edtchieudai);
        chuyen=findViewById(R.id.btchuyen);


        arrayList=new ArrayList<String>();
    }
    public void SetData(float c,int i){
        float dc,dk,dr,df,rk;
        //float n=Float.valueOf(cd.getText().toString());
        if(arrayList.get(i)=="ºC"){
            dc= (float) (c);
            dk=(float)(c*274.15 );
            df= (float)(c*33.8);
            dr=(float) (c*0.8);
            rk= (float) (c*493.47);

            doc.setText(""+dc);
            dok.setText(""+dk);
            dof.setText(""+df);
            dor.setText(""+dr);
            rankine.setText(""+rk);
        }
        if(arrayList.get(i)=="ºF"){
            dc= (float) (c*-17.22222);
            dk=(float)(c*255.92778 );
            df= (float)(c);
            dr=(float) (c*-13.77778);
            rk= (float) (c*460.67);

            doc.setText(""+dc);
            dok.setText(""+dk);
            dof.setText(""+df);
            dor.setText(""+dr);
            rankine.setText(""+rk);
        }
        if(arrayList.get(i)=="K"){
            dc= (float) (c*-272.15);
            dk=(float)(c);
            df= (float)(c*-457.87);
            dr=(float) (c*-217.72);
            rk= (float) (c*1.8);

            doc.setText(""+dc);
            dok.setText(""+dk);
            dof.setText(""+df);
            dor.setText(""+dr);
            rankine.setText(""+rk);
        }
        if(arrayList.get(i)=="ºR"){
            dc= (float) (c*1.25);
            dk=(float)(c*274.4 );
            df= (float)(c*34.25);
            dr=(float) (c);
            rk= (float) (c*493.92);

            doc.setText(""+dc);
            dok.setText(""+dk);
            dof.setText(""+df);
            dor.setText(""+dr);
            rankine.setText(""+rk);
        }
        if(arrayList.get(i)=="Rankine"){
            dc= (float) (c*-272.59444);
            dk=(float)(c*0.55556 );
            df= (float)(c*-458.67);
            dr=(float) (c*-21807556);
            rk= (float) (c);

            doc.setText(""+dc);
            dok.setText(""+dk);
            dof.setText(""+df);
            dor.setText(""+dr);
            rankine.setText(""+rk);
        }




    }
    public void reSet(){
        doc.setText("");
        dok.setText("");
        dof.setText("");
        dor.setText("");
        rankine.setText("");
    }
}