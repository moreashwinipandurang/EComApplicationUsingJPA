package com.example.EComApplicationJPA.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService 
{
   @Autowired
    private CategoryRepository categoryRepo;


    	public List<Category> getAllCategory() {
    		
    		List<Category> cat=new ArrayList<Category>();
    		categoryRepo.findAll().forEach(cat::add);
    		return cat;
    	}
    

   

    public void addcategory(Category category)
	{
		categoryRepo.save(category);
		
	}

    

    public Category getCategoryByName(String categoryname)
    {
        Category name=categoryRepo.findByCategoryname(categoryname);
        return name;
    }



	

   
}
