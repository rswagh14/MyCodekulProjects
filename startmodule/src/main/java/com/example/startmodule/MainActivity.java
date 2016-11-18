package com.example.startmodule;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainActivity mainActivity = this;
        Context context = mainActivity;
        context = this;

        LinearLayout.LayoutParams paramsRoot = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayout rootlayout = new LinearLayout(this); //or new LinearLayout(context);
        rootlayout.setLayoutParams(paramsRoot);
        rootlayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(rootlayout);

        // Create Button

        LinearLayout.LayoutParams paramsbtn = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        Button btnOkay = new Button(this);
        btnOkay.setLayoutParams(paramsbtn);
        btnOkay.setText("Click");
        rootlayout.addView(btnOkay);


        //Create Textview
        final TextView text = new TextView(this);
        LinearLayout.LayoutParams paramstext = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        text.setLayoutParams(paramstext);
        text.setText("Hello Text View");
        rootlayout.addView(text);


        //method 1
        //anonemus inner type
        btnOkay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                text.setText("Clicked");
            }
        });

      /*  btnOkay.setOnClickListener(v->{
            text.setText("lambda");
        }); //lambda

        */

        /*
        btnOkay.setOnClickListener(this::okayClicked);//method reference
       */

        //method 2
        // btnOkay.setOnClickListener(new Click());

        //method 3
        //  View.OnClickListener lis = new Click();
        // btnOkay.setOnClickListener(lis);
    }


    public void okayClicked(){

        text.setText("Method Reference");
    }

    /*
    private class Click implements View.OnClickListener{

        @Override
        public void onClick(View v) {

        }
    } */
}

