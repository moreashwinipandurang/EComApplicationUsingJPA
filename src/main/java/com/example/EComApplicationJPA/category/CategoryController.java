package com.example.EComApplicationJPA.category;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.EComApplicationJPA.exception.ResourseNotFoundException;

import java.util.List;

@RestController
public class CategoryController
{
    @Autowired
    public CategoryService categoryService;
    
    @Autowired
    public CategoryRepository catRepo;

    
    Logger logger = LoggerFactory.getLogger(CategoryController.class);
    

    //get all category
    @GetMapping("/AllCategory")
    public List<Category> getAllCategory()
    {
    	logger.error("provide valid url");
        return categoryService.getAllCategory();
    }

    //get category by perticular id

    @GetMapping("/getPerticularId/{id}")
    public Category getCategoryById(@PathVariable ("id")Long id)
    {
    	if(id==0)
    		throw new ResourseNotFoundException("Enter non zero number");
    	
      return this.catRepo.findById(id)
        		.orElseThrow(()->new ResourseNotFoundException("Category is  not found of this id :" +id));
        
       
    }

    // add category
    @PostMapping("/AddCategory")
    public void AddCategory(@RequestBody Category category)
    {
    	//logger.info("Category is added");
          categoryService.addcategory(category);
    }

    
    
    // update category if id is present
    @PutMapping("/updateCategory/{id}")
    public Category updateCategory(@PathVariable Long id,@RequestBody Category category)
    {
    	if(category.getCategoryid()!=id)
    		throw new ResourseNotFoundException("id is not exist");
    	Category existingCategory = this.catRepo.findById(id)
        		.orElseThrow(()->new ResourseNotFoundException("Category is not present of this id:" +id));
    	existingCategory.setCategoryname(category.getCategoryname());
    	existingCategory.setCategoryenable(category.getCategoryenable());
    	
    	
    	logger.error("categoryid  is  not present");
    	return catRepo.save(existingCategory);
    }
    
    
    

    // delete category by id
    @DeleteMapping("/deleteCategory/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable Long id)
    {
    	Category existing = this.catRepo.findById(id)
		.orElseThrow(()->new ResourseNotFoundException("This "  +id+" not Present in database"));
        this.catRepo.delete(existing);
        
       logger.error("id not present in database");
        return ResponseEntity.ok().build();
    }


    // get category by name
    @GetMapping("/getCategoryByName/{name}")
    public Category getCategoryByName(@PathVariable ("name")String categoryname)
    {
    	if(categoryname.isEmpty())
    		throw new ResourseNotFoundException("Category name is not empty or null");
        Category c=categoryService.getCategoryByName(categoryname);
        logger.error("name is not exists");
        return c;
    }

}
