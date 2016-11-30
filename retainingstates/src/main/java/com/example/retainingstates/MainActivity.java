package com.example.retainingstates;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_NAME = "Name";
    private static final String KEY_PRICE = "1234";
    private static final String KEY_CASHBACK = "qwerty";
    private Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       findViewById(R.id.btnOkay).setOnClickListener(this::clicked);
    }

    private void clicked(View view) {

        if(view.getId() == R.id.btnOkay)
            product = getMeProduct();
        ((TextView)findViewById(R.id.textInfo)).setText(product.getName());
    }

    private Product getMeProduct(){

        product =new Product();
        product.setName("Laptop");
        product.setPrice(45000);
        product.setCashback(4500);

        return product;

    }

    @Override
    protected void onRestart() {
        displaymsg("On Restart");
        super.onRestart();
    }

    @Override
    protected void onStop() {
        displaymsg("On Stop");
        super.onStop();
    }

    @Override
    protected void onPause() {
        displaymsg("On Pause");
        super.onPause();
    }

    @Override
    protected void onStart() {
        displaymsg("On Start");
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        displaymsg("On Destroy");
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(KEY_NAME,product.getName());
        outState.putFloat(KEY_PRICE,product.getPrice());
        outState.putInt(KEY_CASHBACK,product.getCashback());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if(savedInstanceState!=null)
            ((TextView)findViewById(R.id.textInfo))
                    .setText(savedInstanceState.getString(KEY_NAME)+"->"+
                            savedInstanceState.getFloat(KEY_PRICE));
    }

    private void displaymsg(String msg)
    {
        Toast.makeText(this, msg , Toast.LENGTH_SHORT).show();
    }
}
