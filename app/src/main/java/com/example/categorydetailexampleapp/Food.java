package com.example.categorydetailexampleapp;

public class Food {
    private String name;
    private double price;
    private String desc;
    private int imageResourceID;

    public Food(String name, double price, String desc, int imageResourceID) {
        this.name = name;
        this.price = price;
        this.desc = desc;
        this.imageResourceID = imageResourceID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImageResourceID() {
        return imageResourceID;
    }

    public void setImageResourceID(int imageResourceID) {
        this.imageResourceID = imageResourceID;
    }

    public static final Food[] myBreakfast = {
            new Food("Pancakes", 6.99, "4 pancakes", R.drawable.pancakes),
            new Food("Waffles", 7.50, "Crispy Golden Brown", R.drawable.waffles)
    };
    int[] nums = {1, 2, 3, 4};
}
