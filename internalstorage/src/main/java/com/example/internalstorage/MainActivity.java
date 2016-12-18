package com.example.internalstorage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fewImpMethods();
        findViewById(R.id.btnSave).setOnClickListener(this::clicked);
        findViewById(R.id.btnDisplay).setOnClickListener(this::clicked);

    }

    private void clicked(View view) {
        if(view.getId()== R.id.btnSave) saveData();
        else
            displayPrivateFiles();
    }

    private void saveData() {
        try {
            FileOutputStream fos = openFileOutput("my.txt",MODE_APPEND);
            fos.write("Hello, Rahul".getBytes());
            fos.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void displayUsingGetFilesDir() {
        try {
            File file = new File(getFilesDir(),"my.txt");
            FileInputStream fis = new FileInputStream(file);
            StringBuilder builder = new StringBuilder();
            while(true){
                int ch = fis.read();
                if(ch == -1) break;
                else builder.append((char)ch);
            }

            ((TextView)findViewById(R.id.textData))
                    .setText(builder.toString());
            fis.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    private void fewImpMethods() {
        StringBuilder builder = new StringBuilder();
        builder.append("Cache Dir - ").append(getCacheDir().getAbsolutePath()).append("\n")
                .append("Files Dir - ").append(getFilesDir().getAbsolutePath());

        Log.i("@codekul",""+builder.toString());
        ((TextView)findViewById(R.id.textData)).setText(builder.toString());
    }


    private void displayPrivateFiles() {

        ((TextView)findViewById(R.id.textData)).setText("");

        String[] fileNames = fileList();

        for (String fileName : fileNames) {
            ((TextView)findViewById(R.id.textData)).append("\n"+fileName);
        }

    }


}
