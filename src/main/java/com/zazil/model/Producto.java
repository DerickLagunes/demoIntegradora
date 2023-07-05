package com.zazil.model;

public class Producto {
    private String media;
    private String item_name;
    private String descript;
    private int inventory;
    private double price;

    public Producto() {
    }

    public Producto(String media, String item_name, String descript, int inventory, double price) {
        this.media = media;
        this.item_name = item_name;
        this.descript = descript;
        this.inventory = inventory;
        this.price = price;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
