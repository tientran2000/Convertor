package com.example.iconvertor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Array;
import java.util.ArrayList;

public class Tiente extends AppCompatActivity {
TextView tvfromcountry,tvtocountry,tvresults;
EditText edt;
ArrayList<String> arrayList;
Dialog fromDialog,toDialog;
Button btconvert;
String fromvalue,tovalue,value;
String [] country={"EUR","VND","USD","CNY","GBP","BTC","JPY","EGP","SYP","CAD","AUD","THB","SGD","HKD","INR","ARS","KRW","CHF"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiente);
        Init();
    }

    public void Convert(View view) {
        try{
            Double amount=Double.parseDouble(Tiente.this.edt.getText().toString());
            getConversion(fromvalue,tovalue,amount);
        }catch (Exception e){

        }
    }
    public void Init(){
        tvfromcountry=findViewById(R.id.tvfrom);
        tvtocountry=findViewById(R.id.tvto);
        tvresults=findViewById(R.id.tvkq);
        edt=findViewById(R.id.edtfrom);
        btconvert=findViewById(R.id.chuyentien);
        arrayList=new ArrayList<>();
        for (String i:country){
            arrayList.add(i);
        }
        tvfromcountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fromDialog=new Dialog(Tiente.this);
                fromDialog.setContentView(R.layout.from_sp);
                fromDialog.getWindow().setLayout(650,800);
                fromDialog.show();

                EditText editText=fromDialog.findViewById(R.id.edittext);
                ListView listView=fromDialog.findViewById(R.id.lvcountry);

                ArrayAdapter<String> adapter=new ArrayAdapter<>(Tiente.this, android.R.layout.simple_list_item_1,arrayList);
                listView.setAdapter(adapter);
                editText.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        adapter.getFilter().filter(s);
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        tvfromcountry.setText(adapter.getItem(position));
                        fromDialog.dismiss();
                        fromvalue=adapter.getItem(position);
                    }
                });
            }
        });
        tvtocountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toDialog=new Dialog(Tiente.this);
                toDialog.setContentView(R.layout.to_sp);
                toDialog.getWindow().setLayout(650,800);
                toDialog.show();

                EditText editText=toDialog.findViewById(R.id.edittext);
                ListView listView=toDialog.findViewById(R.id.lvcountry);

                ArrayAdapter<String> adapter=new ArrayAdapter<>(Tiente.this, android.R.layout.simple_list_item_1,arrayList);
                listView.setAdapter(adapter);
                editText.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        adapter.getFilter().filter(s);
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        tvtocountry.setText(adapter.getItem(position));
                        toDialog.dismiss();
                        tovalue=adapter.getItem(position);
                    }
                });
            }
        });

    }
    public  String getConversion(String cvfrom,String cvto,Double amount){
        RequestQueue queue= Volley.newRequestQueue(this);
        String url="https://free.currconv.com/api/v7/convert?q="+cvfrom+"_"+cvto+"&compact=ultra&apiKey=23aae9838378ea1276b0";
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(response);
//                    double gt=Math.round((Double) jsonObject.get(cvfrom + "_" + cvto)*100)/100;
//                    value=""+Math.round(gt*amount*100)/100;
                    Double cvValue = round(((Double) jsonObject.get(cvfrom + "_" + cvto)), 2);
                    value = "" + round((cvValue * amount), 2);
                    tvresults.setText(value);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(stringRequest);
        return null;
    }
    public static double round(Double value,int place){
        if(place<0) throw new IllegalArgumentException();
        BigDecimal bigDecimal=BigDecimal.valueOf(value);
        bigDecimal=bigDecimal.setScale(place, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }
}