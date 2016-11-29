package com.example.gridviewcalculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

/**
 * Created by Rahul on 11/29/2016.
 */

public class Calc_Adapter extends BaseAdapter {


    private Context context;
    private String []nums;
    private LayoutInflater inflater;
    private OnDigitclicklistener digitclicklistener;

    public interface OnDigitclicklistener{
        void onDigitClick(String Digit);
    }

    public Calc_Adapter(Context context, String[] nums, OnDigitclicklistener digitclicklistener) {
        this.context = context;
        this.nums = nums;
        this.digitclicklistener = digitclicklistener;

        inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return nums.length;
    }

    @Override
    public Object getItem(int position) {
        return nums[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = null;

        if(convertView == null) view = inflater.inflate(R.layout.calc_item,null,false);
        else view = convertView;

        ((Button)view.findViewById(R.id.btnCalc)).setText(nums[position]);

        view.findViewById(R.id.btnCalc).setOnClickListener(this::onclicked);

        return view;
    }

    private void onclicked(View view) {
        Button btn = (Button) view;
        if(digitclicklistener!= null) digitclicklistener.onDigitClick(btn.getText().toString());
    }
}
