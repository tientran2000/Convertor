package com.example.iconvertor;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.iconvertor.Retrofit.RetrofitBuilder;
import com.example.iconvertor.Retrofit.RetrofitInterface;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Currency extends AppCompatActivity {
    Button button;
    EditText currencyToBeConverted;
    EditText currencyConverted;
    Spinner convertToDropdown;
    Spinner convertFromDropdown;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.currency);

        //Initialization
        currencyConverted = (EditText) findViewById(R.id.currency_converted);
        currencyToBeConverted = (EditText) findViewById(R.id.currency_to_be_converted);
        convertToDropdown = (Spinner) findViewById(R.id.convert_to);
        convertFromDropdown = (Spinner) findViewById(R.id.convert_from);
        button = (Button) findViewById(R.id.button);

        //Adding Functionality
        String[] dropDownList = {"EUR","VND","USD","CNY","GBP","BTC","JPY","EGP","SYP","CAD","AUD","THB","SGD","HKD","INR","ARS","KRW","CHF"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, dropDownList);
        convertToDropdown.setAdapter(adapter);
        convertFromDropdown.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RetrofitInterface retrofitInterface = RetrofitBuilder.getRetrofitInstance().create(RetrofitInterface.class);
                Call<JsonObject> call = retrofitInterface.getExchangeCurrency(convertFromDropdown.getSelectedItem().toString());
                call.enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        JsonObject res = response.body();
                        JsonObject rates = res.getAsJsonObject("rates");
                        double currency = Double.valueOf(currencyToBeConverted.getText().toString());
                        double multiplier = Double.valueOf(rates.get(convertToDropdown.getSelectedItem().toString()).toString());
                        double result = currency * multiplier;
                        currencyConverted.setText(String.valueOf(result));
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {

                    }
                });
            }
        });



    }
}

