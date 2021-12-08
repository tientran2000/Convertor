package com.example.iconvertor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Sohoc extends AppCompatActivity {
EditText edtbin,edthex,edtdec,edtoct;
Button btclear;
String value;
View.OnFocusChangeListener onFocusChangeListener;
int focusedViewid;
TextWatcher textWatcher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sohoc);
        Init();
        btclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Clear();
            }
        });
       textWatcher=new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                value=((EditText) findViewById(focusedViewid)).getText().toString().trim();
                if(value.length()>0){
                    convertNumber();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
       onFocusChangeListener=new View.OnFocusChangeListener() {
           @Override
           public void onFocusChange(View v, boolean hasFocus) {
               if(hasFocus){
                   focusedViewid=v.getId();
                   ((EditText) findViewById(focusedViewid)).addTextChangedListener(textWatcher);
//                   GradientDrawable gradientDrawable=new GradientDrawable( GradientDrawable.Orientation.TR_BL,
//                           new int[]{Color.parseColor("#CCCC30"),Color.parseColor("#000000")});
//                   gradientDrawable.setShape(GradientDrawable.RECTANGLE);
//                   gradientDrawable.setCornerRadius(10);
                   if(focusedViewid==R.id.edtdec){
                        //gradientDrawable.setStroke(8, ContextCompat.getColor(getApplicationContext(), android.R.color.holo_blue_light));
                   }else {
                       ///gradientDrawable.setStroke(8, ContextCompat.getColor(getApplicationContext(), android.R.color.holo_green_light));

                   }
                   //v.setBackground(gradientDrawable);
               }else {
                   ((EditText) findViewById(focusedViewid)).removeTextChangedListener(textWatcher);

                   if(focusedViewid==R.id.edtdec){
                       //v.setBackground();
                   }
               }
           }
       };
       edtoct.setOnFocusChangeListener(onFocusChangeListener);
        edtbin.setOnFocusChangeListener(onFocusChangeListener);
        edtdec.setOnFocusChangeListener(onFocusChangeListener);
        edthex.setOnFocusChangeListener(onFocusChangeListener);

    }

    private void convertNumber() {
        try{
            long num=0;
            switch (focusedViewid){
                case R.id.edtdec:
                    num=Long.parseLong(value);
                    edtbin.setText(String.valueOf(Long.toBinaryString(num)));
                    edtoct.setText(String.valueOf(Long.toOctalString(num)));
                    edthex.setText(String.valueOf(Long.toHexString(num)).toUpperCase());
                    break;
                case R.id.edtbin:
                    num=Long.parseLong(value,2);
                    edtdec.setText(String.valueOf(num));
                    edtoct.setText(String.valueOf(Long.toOctalString(num)));
                    edthex.setText(String.valueOf(Long.toHexString(num)).toUpperCase());
                    break;
                case R.id.edtoct:
                    num=Long.parseLong(value,8);
                    edtbin.setText(String.valueOf(Long.toBinaryString(num)));
                    edtdec.setText(String.valueOf(num));
                    edthex.setText(String.valueOf(Long.toHexString(num)).toUpperCase());
                    break;
                case R.id.edthex:
                    num=Long.parseLong(value,16);
                    edtbin.setText(String.valueOf(Long.toBinaryString(num)));
                    edtoct.setText(String.valueOf(Long.toOctalString(num)));
                    edtdec.setText(String.valueOf(num));
                    break;

            }

        }catch (NumberFormatException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void Init() {
        edtbin=findViewById(R.id.edtbin);
        edtdec=findViewById(R.id.edtdec);
        edthex=findViewById(R.id.edthex);
        edtoct=findViewById(R.id.edtoct);
        btclear=findViewById(R.id.btclear);
    }
    private void Clear(){
        edthex.setText("");
        edtdec.setText("");
        edtbin.setText("");
        edtoct.setText("");
    }
}