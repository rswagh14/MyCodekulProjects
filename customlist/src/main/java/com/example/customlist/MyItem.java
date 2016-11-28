package com.example.customlist;

/**
 * Created by Rahul on 11/28/2016.
 */

public class MyItem {

    private int flag;
    private String countryName;
    private Long id;

    public MyItem(Long id, int flag, String countryName) {
        this.flag = flag;
        this.countryName = countryName;
        this.id = id;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
