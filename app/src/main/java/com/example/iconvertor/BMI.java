package com.example.iconvertor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class BMI extends AppCompatActivity {
EditText chieucao,cannang;
Button bttinh,btan;
Dialog dialog;
float cc,cn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_m_i);
        Init();

        if(chieucao.getText().toString().equals(""))
            return;
        else cc= Float.parseFloat(chieucao.getText().toString());
        if(cannang.getText().toString().equals(""))
            return;
        else cn= Float.parseFloat(cannang.getText().toString());


    }
   public  void Init(){
        chieucao=findViewById(R.id.edtchieucao);
        cannang=findViewById(R.id.edtcannang);
        bttinh=(Button)findViewById(R.id.tinh);

    }
    void Tinhtoan(){
        if(chieucao.getText().toString().equals(""))
            return;
        else cc= Float.parseFloat(chieucao.getText().toString());
        if(cannang.getText().toString().equals(""))
            return;
        else cn= Float.parseFloat(cannang.getText().toString());
        float t= (float) (cn/(Math.pow(cc*0.01,2)));

        String s="";
        if(t<18.5){
            s="Người gầy";
        }
        if(18.5<=t&&t<=24.9){
            s="Bình thường";
        }
        if(t==25)
            s="Thừa cân";
        if(25<t&&t<29.9)
            s="Tiền béo phì";
        if(30<=t&&t<=34.9)
            s="Béo phì độ I";
        if(35<=t&&t<39.9)
            s="Béo phì độ II";
        if(t>=40) s="Béo phì độ III";
        AlertDialog.Builder builder = new AlertDialog.Builder(BMI.this);
        // Message.
        builder.setTitle("Kết quả");
        builder.setMessage("Chỉ số BMI là "+t+"\n"+s);
        builder.setCancelable(true);
        builder.setIcon(R.drawable.bmi);
        // Create "OK" button with OnClickListener.
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });

        // Create AlertDialog:
        AlertDialog alert = builder.create();
        alert.show();

    }

    public void Chuyen(View view) {
        Tinhtoan();

    }
}