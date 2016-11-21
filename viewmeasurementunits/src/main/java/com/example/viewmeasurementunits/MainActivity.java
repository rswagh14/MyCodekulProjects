package com.example.viewmeasurementunits;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      /*  btnconvert = (Button) findViewById(R.id.btnconvert);
        btnconvert.setOnClickListener(this::clicked); */

        /* on click listener shortcut method using java8 */

        findViewById(R.id.btnconvertToPx).setOnClickListener(this::clicked);

        findViewById(R.id.btnconvertToDp).setOnClickListener(this::clicked);

    }

    public void clicked(View view){

        if(view.getId() == R.id.btnconvertToDp)
        {
            setTextInfo(""+convertToDp(getEditValue(),240));
        }else
        {
            setTextInfo(""+convertToPx(getEditValue(),240));
        }
    }

    private int getEditValue(){

       /*  EditText editvalue = (EditText)findViewById(R.id.edttext);
        int val = Integer.parseInt(editvalue.getText().toString());
        return val;
        */

        /* Or by good developer method i.e. one line code  */
        return Integer.parseInt(((EditText)findViewById(R.id.edttext))
                .getText()
                .toString());
    }


    public int convertToPx(int val,int dpi){

        return val * (dpi/160);
    }

    public int convertToDp(int val, int dpi){
        return (val* 160)/dpi;
    }

    public void setTextInfo(String info){
        TextView text = (TextView)findViewById(R.id.text);
        text.setText(info);
    }
}
