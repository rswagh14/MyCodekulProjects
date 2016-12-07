package com.example.toast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.toast).setOnClickListener(this::clicked);
    }

    private void clicked(View view) {
        if(view.getId() == R.id.toast) customtoast();
    }

    private void showtoast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void customtoast(){
        ImageView imageview = new ImageView(this);
        imageview.setImageResource(R.mipmap.ic_launcher);
        Toast toast = Toast.makeText(this,"",Toast.LENGTH_SHORT);
        toast.setView(imageview);
        toast.show();
    }
}
