package com.example.login_fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        runFragmentTransaction(new MainFragment(), "MainFragment");
    }

    public void runFragmentTransaction(Fragment frag,String name){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction txn = fm.beginTransaction();
        txn.addToBackStack(name);
        txn.replace(R.id.framContrainer,frag);
        txn.commit();
    }
}
