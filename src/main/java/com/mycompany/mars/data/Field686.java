package com.mycompany.mars.data;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.util.ArrayList;

public class Field686 {
    private String i1;
    private String i2;
    private ArrayList<String> a;
    private ArrayList<String> v;
    private ArrayList<String> s2;

    public String getI1() {
        return i1;
    }

    public void setI1(String i1) {
        this.i1 = i1;
    }

    public String getI2() {
        return i2;
    }

    public void setI2(String i2) {
        this.i2 = i2;
    }

    public ArrayList<String> getA() {
        return a;
    }

    public void setA(ArrayList<String> a) {
        this.a = a;
    }

    public ArrayList<String> getV() {
        return v;
    }

    public void setV(ArrayList<String> v) {
        this.v = v;
    }

    @JsonGetter("2")
    public ArrayList<String> getS2() {
        return s2;
    }

    @JsonSetter("2")
    public void setS2(ArrayList<String> s2) {
        this.s2 = s2;
    }
}