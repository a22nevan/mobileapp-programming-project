package com.example.project;

public class Produce {

    private String ID, name, category, auxData;
    private int size, cost;

    public Produce(){
        ID = "Missing ID";
        name = "Missing name";
        category = "Missing category";
        size = 0;
        cost = 0;
        auxData = "Missing auxData";
    }

    public Produce(String n, String c, int s, int co, String aD){
        name = n;
        category = c;
        size = s;
        cost = co;
        auxData = aD;
    }

    public void setName(String n){
        name = n;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return name;
    }
}
