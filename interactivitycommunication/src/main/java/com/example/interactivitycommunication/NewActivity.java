package com.example.interactivitycommunication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity {

    public static final String KEY_BACK = "back";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        setOs(getosFromMain());

        findViewById(R.id.btnback).setOnClickListener(this::clicked);

    }

    private void clicked(View view) {

        if(view.getId() == R.id.btnback) throwback();

    }

    private void throwback() {

        Intent intent = new Intent();
        intent.putExtra(KEY_BACK,sendText());

        setResult(RESULT_OK,intent);

        finish();

    }

    private String sendText() {

        return ((EditText)findViewById(R.id.newedit)).getText().toString();
    }

    private String getosFromMain(){

        Intent intent = getIntent();

        if(intent == null) throw new RuntimeException();

        Bundle bundle = intent.getExtras();
        String os = bundle.getString(MainActivity.KEY_MY_OS);

        return os;

    }

    private void setOs(String os){
        ((TextView)findViewById(R.id.texttwo)).setText(os);
    }

}
