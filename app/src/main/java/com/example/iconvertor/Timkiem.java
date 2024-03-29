package com.example.iconvertor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Timkiem extends AppCompatActivity {
EditText edttk;
ListView lv;
ArrayList<String> arrayList,arr;
String xau;
ArrayAdapter adapter;
String [] strings={"Chiều dài","Diện tích","Thể tích","Nhiệt độ","Trọng lượng","BMI","Lực","Gia tốc","Vận tốc","Số học","Kích cỡ","Tiền tệ","Góc","Thời gian","Áp suất"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timkiem);
        edttk=findViewById(R.id.edttk);
        lv=findViewById(R.id.lvtk);
        arrayList=new ArrayList<>();
        for (String i:strings) {
            arrayList.add(i);
        }
        edttk.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                s=edttk.getText().toString().toLowerCase();
                String ten=s.toString().toLowerCase().trim();
                arr=new ArrayList<>();
                if(ten.equals(""))
                    Toast.makeText(Timkiem.this,"Nhập nội dung tìm kiếm",Toast.LENGTH_SHORT).show();
                else{
                    for (int i=0;i<arrayList.size();i++){
                        if(arrayList.get(i).toLowerCase().trim().contains(ten))
                            arr.add(ten);
                    }

                    if(arr.size()>0){
                        adapter=new ArrayAdapter(Timkiem.this, android.R.layout.simple_list_item_1,arr);
                        lv.setAdapter(adapter);
                    }
                    else Toast.makeText(Timkiem.this,"Không tìm thấy",Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i;
                xau=arr.get(position).toString();
                switch (xau.toLowerCase()){
                    case "số học":
                        i = new Intent(Timkiem.this, Sohoc.class);
                        startActivity(i);
                        break;
                    case "diện tích":
                        i = new Intent(Timkiem.this, Dientich.class);
                        startActivity(i);
                        break;
                    case "thể tích":
                        i = new Intent(Timkiem.this, TheTich.class);
                        startActivity(i);
                        break;
                    case "chiều dài":
                        i = new Intent(Timkiem.this, Chieudai.class);
                        startActivity(i);
                        break;
                    case "góc":
                        i = new Intent(Timkiem.this, Goc.class);
                        startActivity(i);
                        break;
                    case "lực":
                        i = new Intent(Timkiem.this, Luc.class);
                        startActivity(i);
                        break;
                    case "thời gian":
                        i = new Intent(Timkiem.this, Thoigian.class);
                        startActivity(i);
                        break;
                    case "tiền tệ":
                        i = new Intent(Timkiem.this, Currency.class);
                        startActivity(i);
                        break;
                    case "trọng lượng":
                        i = new Intent(Timkiem.this, Trongluong.class);
                        startActivity(i);
                        break;
                    case "bmi":
                        i = new Intent(Timkiem.this, BMI.class);
                        startActivity(i);
                        break;
                    case "áp suất":
                        i = new Intent(Timkiem.this, Apsuat.class);
                        startActivity(i);
                        break;
                    case "nhiệt độ":
                        i = new Intent(Timkiem.this, Nhietdo.class);
                        startActivity(i);
                        break;
                    case "kích cỡ":
                        i = new Intent(Timkiem.this, Kichco.class);
                        startActivity(i);
                        break;
                    case "vận tốc":
                        i = new Intent(Timkiem.this, Vantoc.class);
                        startActivity(i);
                        break;
                    case "gia tốc":
                        i = new Intent(Timkiem.this, Giatoc.class);
                        startActivity(i);
                        break;
                }

            }
        });
    }
}