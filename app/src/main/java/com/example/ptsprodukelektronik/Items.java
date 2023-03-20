package com.example.ptsprodukelektronik;

public class Items {
    private String name;
    private String price;
    private int posterImg;
    private String description;

    public Items(String name, String price, int posterImg, String description) {
        this.name = name;
        this.price = price;
        this.posterImg = posterImg;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosterImg() {
        return posterImg;
    }

    public void setPosterImg(int posterImg) {
        this.posterImg = posterImg;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
