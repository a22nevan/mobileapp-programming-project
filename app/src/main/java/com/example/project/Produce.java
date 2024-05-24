package com.example.project;

public class Produce {

    private String ID, name, category, auxdata;
    private int size, cost;

    public Produce(){
        ID = "Missing ID";
        name = "Missing name";
        category = "Missing category";
        size = 0;
        cost = 0;
        auxdata = "Missing auxdata";
    }

    public Produce(String n, String c, int s, int co, String aD){
        name = n;
        category = c;
        size = s;
        cost = co;
        auxdata = aD;
    }

    public void setName(String n){
        name = n;
    }

    public String getName(){
        return name;
    }

    public String getCategory(){
        return category;
    }

    public int getSize() {
        return size;
    }

    public int getCost() {
        return cost;
    }

    public String getAuxData() {
        return auxdata;
    }

    @Override
    public String toString(){
        return name;
    }
}
