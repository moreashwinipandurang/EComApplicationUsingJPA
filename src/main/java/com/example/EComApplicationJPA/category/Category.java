package com.example.EComApplicationJPA.category;

import javax.persistence.*;

@Entity
@Table(name="tableCategory")
public class Category
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long categoryid;

    @Column(name="categoryname")
    private String categoryname;

    @Column(name="categoryenable")
    private String categoryenable;

    public Category() {
    }





    public Category(long categoryid, String categoryname, String categoryenable) {
        super();
        this.categoryid = categoryid;
        this.categoryname = categoryname;
        this.categoryenable = categoryenable;
    }





    public long getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(long categoryid) {
        this.categoryid = categoryid;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public String getCategoryenable() {
        return categoryenable;
    }

    public void setCategoryenable(String categoryenable) {
        this.categoryenable = categoryenable;
    }

    @Override
    public String toString() {
        return "Category [categoryid=" + categoryid + ", categoryname=" + categoryname + ", categoryenable="
                + categoryenable + "]";
    }





	

}


