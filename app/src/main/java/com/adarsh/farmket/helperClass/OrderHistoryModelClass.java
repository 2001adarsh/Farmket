package com.adarsh.farmket.helperClass;

public class OrderHistoryModelClass  {
    private int image;
    private String name;
    private String productPrice;
    private String date;

    public OrderHistoryModelClass(int image, String name, String productPrice, String date) {
        this.image = image;
        this.name = name;
        this.productPrice = productPrice;
        this.date = date;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
