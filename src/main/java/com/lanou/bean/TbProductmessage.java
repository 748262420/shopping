package com.lanou.bean;

public class TbProductmessage {
    private Integer id;

    private String productmessage;

    private Integer details;

    private Integer stock;

    private String server;

    private Integer productid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductmessage() {
        return productmessage;
    }

    public void setProductmessage(String productmessage) {
        this.productmessage = productmessage;
    }

    public Integer getDetails() {
        return details;
    }

    public void setDetails(Integer details) {
        this.details = details;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }
}