package com.example.sqlite;

public class Category {
    private String id;
    private String nameCategory;
    private int numberCPT;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public int getNumberCPT() {
        return numberCPT;
    }

    public void setNumberCPT(int numberCPT) {
        this.numberCPT = numberCPT;
    }
}
