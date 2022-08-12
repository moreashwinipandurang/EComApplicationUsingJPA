package com.example.EComApplicationJPA.brand;

import javax.persistence.*;

@Entity
@Table(name="tablebrand")
public class Brand
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long brandid;

    @Column(name="Brandname")
    private String brandname;

    @Column(name="Brandlogo")
    private String brandlogo;

    @Column(name="categoryid")
    private long categoryid;

    public Brand()
    {

    }



    public Brand(Long brandid, String brandname, String brandlogo, long categoryid) {
        super();
        this.brandid = brandid;
        this.brandname = brandname;
        this.brandlogo = brandlogo;
        this.categoryid = categoryid;
    }



    public Long getBrandid() {
        return brandid;
    }

    public void setBrandid(Long brandid) {
        this.brandid = brandid;
    }

    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }

    public String getBrandlogo() {
        return brandlogo;
    }

    public void setBrandlogo(String brandlogo) {
        this.brandlogo = brandlogo;
    }

    public long getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(long categoryid) {
        this.categoryid = categoryid;
    }

    @Override
    public String toString() {
        return "Brand [brandid=" + brandid + ", Brandname=" + brandname + ", Brandlogo=" + brandlogo + ", categoryid="
                + categoryid + "]";
    }



	


	


}
