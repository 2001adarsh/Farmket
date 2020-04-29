package com.adarsh.farmket.helperClass;

public class CartModelClass {
    //final
    public static final int item = 0;
    public static final int TotalAmount = 1;

    public int type;

    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }

    //Item particular
    private int productImage;
    private int productName;
    private String productPrice;
    private int quantity;

    public CartModelClass(int productImage, int productName, String productPrice, int quantity) {
        this.productImage = productImage;
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
    }

    public static int getItem() {
        return item;
    }

    public static int getTotalAmount() {
        return TotalAmount;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public int getProductName() {
        return productName;
    }

    public void setProductName(int productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    ///Final cart Details
    private String no_of_items;
    private int total_item_price;
    private String delivery_cart;

    public CartModelClass(String no_of_items, int total_item_price, String delivery_cart) {
        this.no_of_items = no_of_items;
        this.total_item_price = total_item_price;
        this.delivery_cart = delivery_cart;
    }

    public String getNo_of_items() {
        return no_of_items;
    }

    public void setNo_of_items(String no_of_items) {
        this.no_of_items = no_of_items;
    }

    public int getTotal_item_price() {
        return total_item_price;
    }

    public void setTotal_item_price(int total_item_price) {
        this.total_item_price = total_item_price;
    }

    public String getDelivery_cart() {
        return delivery_cart;
    }

    public void setDelivery_cart(String delivery_cart) {
        this.delivery_cart = delivery_cart;
    }
}
