package com.example.EComApplicationJPA.category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository <Category,Long>
{
   // public Category findAllCategoryid(long id);
	
    public Category findByCategoryname(String categoryname);
    
    //public Category saveAll();

	
}
