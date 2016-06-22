package com.mycompany.mars.data;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.util.ArrayList;

public class Field463 {
    private String i1;
    private String i2;
    private ArrayList<String> a;
    private ArrayList<String> d;
    private ArrayList<String> v;
    private ArrayList<String> s1;

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

    public ArrayList<String> getD() {
        return d;
    }

    public void setD(ArrayList<String> d) {
        this.d = d;
    }

    public ArrayList<String> getV() {
        return v;
    }

    public void setV(ArrayList<String> v) {
        this.v = v;
    }
    
    @JsonGetter("1")
    public ArrayList<String> getS1() {
        return s1;
    }

    @JsonSetter("1")
    public void setS1(ArrayList<String> s1) {
        this.s1 = s1;
    }
}