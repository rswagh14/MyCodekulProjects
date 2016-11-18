package com.example.rahul.mycodekulprojects;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btngood,btnbetter,btnbest;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.text);

        btngood = (Button)findViewById(R.id.btngood);
        btngood.setOnClickListener(this::goodClicked);

        btnbetter = (Button)findViewById(R.id.btnbetter);
        btnbetter.setOnClickListener(this::betterClicked);

        btnbest = (Button)findViewById(R.id.btnbest);
        btnbest.setOnClickListener(this::bestClicked);

    }

    private void goodClicked(View view){
        textView.setText("Good Clicked");
    }

    private void betterClicked(View view){
        textView.setText("Better Clicked");
    }

    private void bestClicked(View view){
        textView.setText("Best Clicked");
    }

}
