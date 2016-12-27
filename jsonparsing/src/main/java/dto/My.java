package dto;

import junit.runner.Version;

import java.util.ArrayList;

/**
 * Created by Rahul on 12/27/2016.
 */

public class My {

    private String name;
    private String os;
    private double var;
    private Versions allVersions;
    private ArrayList<Devices> devices;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public double getVar() {
        return var;
    }

    public void setVar(double var) {
        this.var = var;
    }

    public Versions getAllVersions() {
        return allVersions;
    }

    public void setAllVersions(Versions allVersions) {
        this.allVersions = allVersions;
    }

    public ArrayList<Devices> getDevices() {
        return devices;
    }

    public void setDevices(ArrayList<Devices> devices) {
        this.devices = devices;
    }
}
