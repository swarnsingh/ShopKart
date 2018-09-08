package com.arya.cart.model;

/**
 * @author Swarn Singh.
 */
public class Product {

    private String url;

    private String productName;

    private String productDescription;

    private String productPrice;

    private boolean isWishListProduct;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public boolean isWishListProduct() {
        return isWishListProduct;
    }

    public void setWishListProduct(boolean wishListProduct) {
        isWishListProduct = wishListProduct;
    }
}
