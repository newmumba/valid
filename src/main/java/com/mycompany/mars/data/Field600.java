package com.mycompany.mars.data;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.util.ArrayList;

public class Field600 {
    private String i1;
    private String i2;
    private ArrayList<String> a;
    private ArrayList<String> b;
    private ArrayList<String> c;
    private ArrayList<String> d;
    private ArrayList<String> f;
    private ArrayList<String> g;
    private ArrayList<String> p;
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

    public ArrayList<String> getB() {
        return b;
    }

    public void setB(ArrayList<String> b) {
        this.b = b;
    }

    public ArrayList<String> getC() {
        return c;
    }

    public void setC(ArrayList<String> c) {
        this.c = c;
    }

    public ArrayList<String> getD() {
        return d;
    }

    public void setD(ArrayList<String> d) {
        this.d = d;
    }

    public ArrayList<String> getF() {
        return f;
    }

    public void setF(ArrayList<String> f) {
        this.f = f;
    }

    public ArrayList<String> getG() {
        return g;
    }

    public void setG(ArrayList<String> g) {
        this.g = g;
    }

    public ArrayList<String> getP() {
        return p;
    }

    public void setP(ArrayList<String> p) {
        this.p = p;
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