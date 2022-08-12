package com.example.EComApplicationJPA.brand;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.EComApplicationJPA.category.Category;
import com.example.EComApplicationJPA.product.Product;



public interface BrandRepository extends JpaRepository<Brand,Long>
{
	 public Brand findByBrandname(String brandname);
	
}
