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
    private String productName;
    private int productPrice;
    private int quantity;

    public CartModelClass(int type, int productImage, String productName, int productPrice,
                          int quantity) {
        this.type = type;
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    ///Final cart Details
    private int no_of_items;
    private int total_item_price;
    private int delivery_price;
    private int total_amount;

    public CartModelClass(int type, int no_of_items, int total_item_price, int delivery_price,
                          int total_amount) {
        this.type = type;
        this.no_of_items = no_of_items;
        this.total_item_price = total_item_price;
        this.delivery_price = delivery_price;
        this.total_amount = total_amount;
    }

    public int getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(int total_amount) {
        this.total_amount = total_amount;
    }

    public int getNo_of_items() {
        return no_of_items;
    }

    public void setNo_of_items(int no_of_items) {
        this.no_of_items = no_of_items;
    }

    public int getTotal_item_price() {
        return total_item_price;
    }

    public void setTotal_item_price(int total_item_price) {
        this.total_item_price = total_item_price;
    }

    public int getDelivery_price() {
        return delivery_price;
    }

    public void setDelivery_price(int delivery_price) {
        this.delivery_price = delivery_price;
    }
}
