package com.example.EComApplicationJPA.product;

import javax.persistence.*;

@Entity
@Table(name="tableproduct")
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long productid;

    @Column(name="productname")
    private String productname;

    @Column(name="productprice")
    private String productprice;

    @Column(name="categoryid")
    private long categoryid;

    @Column(name="brandid")
    private long brandid;

    public Product() {
    }



    public Product(long productid, String productname, String productprice, long categoryid, long brandid) {
        super();
        this.productid = productid;
        this.productname = productname;
        this.productprice = productprice;
        this.categoryid = categoryid;
        this.brandid = brandid;
    }



    public long getProductid() {
        return productid;
    }

    public void setProductid(long productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductprice() {
        return productprice;
    }

    public void setProductprice(String productprice) {
        this.productprice = productprice;
    }

    public long getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(long categoryid) {
        this.categoryid = categoryid;
    }

    public long getBrandid() {
        return brandid;
    }

    public void setBrandid(long brandid) {
        this.brandid = brandid;
    }

    @Override
    public String toString() {
        return "Product [productid=" + productid + ", productname=" + productname + ", productprice=" + productprice
                + ", categoryid=" + categoryid + ", brandid=" + brandid + "]";
    }


}
