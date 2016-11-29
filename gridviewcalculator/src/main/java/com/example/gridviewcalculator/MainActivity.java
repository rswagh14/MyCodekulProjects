package com.example.gridviewcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String []nums = {"+","-","*","/","1","2","3","4","5","6","7","8","9","0"};
        Calc_Adapter adapter = new Calc_Adapter(this, nums,this::onDigitClick);
        ((GridView)findViewById(R.id.gridCalc)).setAdapter(adapter);
    }

    public void onDigitClick(String Digit){
        ((EditText)findViewById(R.id.edtNum)).setText(Digit);
    }
}

