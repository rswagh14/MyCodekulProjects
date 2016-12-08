package com.example.dialog;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import static android.R.attr.tag;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnAlert).setOnClickListener(this::clicked);
        findViewById(R.id.btnTimePicker).setOnClickListener(this::clicked);
        findViewById(R.id.btnDatePicker).setOnClickListener(this::clicked);
        findViewById(R.id.btnProgress).setOnClickListener(this::clicked);
        findViewById(R.id.btnCustom).setOnClickListener(this::clicked);
    }

    private void clicked(View view) {
        if(view.getId() == R.id.btnAlert) showDialog(MyDialog.DIALOG_ALERT);
        if(view.getId() == R.id.btnTimePicker) showDialog(MyDialog.DIALOG_TIME);
        if(view.getId() == R.id.btnDatePicker) showDialog(MyDialog.DIALOG_DATE);
        if(view.getId() == R.id.btnProgress) showDialog(MyDialog.DIALOG_PROGRESS);
        if(view.getId() == R.id.btnCustom) showDialog(MyDialog.DIALOG_CUSTOM);
    }

    private void showalartdialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher)
                .setMessage("Hi")
                .setTitle("AlertDialog");

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showDialog(String tag){
        MyDialog dialogs = new MyDialog();
        dialogs.show(getSupportFragmentManager(),tag);
    }
}
