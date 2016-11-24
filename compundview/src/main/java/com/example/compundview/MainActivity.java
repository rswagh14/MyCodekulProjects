package com.example.compundview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout layoutroot = (LinearLayout)findViewById(R.id.layoutroot);

        layoutroot.addView(giveMeSocialCard("asdfg"));
        layoutroot.addView(giveMeSocialCard("qwerty"));
        layoutroot.addView(giveMeSocialCard("zxcvb"));
    }

    private View giveMeSocialCard(String status) {

//        LinearLayout layoutRoot = (LinearLayout) findViewById(R.id.layoutroot);
//
//        LayoutInflater inflater = (LayoutInflater)
//                getSystemService(LAYOUT_INFLATER_SERVICE);

        //LayoutInflater inflater = LayoutInflater.from(this);

        LayoutInflater inflater = getLayoutInflater();

        View compoundview = inflater.inflate(R.layout.social_media,null,false);
        TextView textstatus = (TextView)compoundview.findViewById(R.id.textStatus);
        textstatus.setText(status);

        return compoundview;
    }
}
