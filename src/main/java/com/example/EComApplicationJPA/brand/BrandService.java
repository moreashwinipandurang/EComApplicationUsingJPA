package com.example.EComApplicationJPA.brand;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EComApplicationJPA.category.Category;
import com.example.EComApplicationJPA.category.CategoryRepository;
import com.example.EComApplicationJPA.exception.ResourseNotFoundException;
import com.example.EComApplicationJPA.product.Product;
import com.example.EComApplicationJPA.product.ProductRepository;



@Service
public class BrandService
{
	@Autowired
    private BrandRepository brandRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private CategoryRepository  categoryRepo;
    
	Logger logger = LoggerFactory.getLogger(BrandService.class);
	
// get all brand	
	public List<Brand> getAllBrand() 
	{
        List<Brand> c = new ArrayList<Brand>();
        brandRepo.findAll().forEach(c::add);
        return c;
    }

   
//add brand 
    public void addBrand(Brand brand)
    {
    	List<Brand> b1 =brandRepo.findAll();
    	List<Category> c1=categoryRepo.findAll();;
    	
    	for(Brand obj:b1)
    	{
    		if (obj.getBrandname().equals(brand.getBrandname()))
			{
    			logger.error("you can not add brand its already exist");
				throw new ResourseNotFoundException("Brand is already exists...");
			}
			 else if(brand.getBrandname() == " " && brand.getBrandname()== null)
			{
				 logger.error("Enter valid name");
				 throw new ResourseNotFoundException("Enter valid name ...not empty string or not null...");
			}
    		
			 /*for(Category catobj:c1)
			 {
				 //if(obj.getCategoryid()!=catobj.getCategoryid())
				 if(catobj.getCategoryid()!=obj.getCategoryid())
				 {
					 logger.error("you can not add...");
					 throw new ResourseNotFoundException("category is not present ...so u cant add this brand"); 
		
				 }*/
				 else 
				 {
					 logger.info("brand added ");
					 brandRepo.save(brand);
			 	}
			}
    	
    }

  //get  brand by brandname  

    public Brand getBrandByName(String brandname)
    {
        Brand name=brandRepo.findByBrandname(brandname);
        return name;
    }


//delete brand
	public void deleteById(long brandid)
	{
		List<Brand> blist= brandRepo.findAll();
		List<Product>plist= productRepo.findAll();
		
		for(Brand obj:blist)
		{
			if(obj.getBrandid().equals(brandid)&& brandid !=0)
			{
				for(Product objp:plist)
				{
					if(objp.getBrandid()!=obj.getBrandid())
					{
						logger.error("u cant delete this brand");
						throw new ResourseNotFoundException("you can't delete this brand it's product is present...");
					}
				}
			}
		}
		logger.info("brand deleted....");
		brandRepo.deleteById(brandid);;
	}

    
	/*//get brand by categoryid
	public List<Object> getBrandByCategoryId(Long catid)
	{
		List<Object>b=brandRepo.findById(catid);
		
     return b;
        
		
	}*/

//update
	public Brand updateBrand(Long id, Brand brand) 
	{
		if(brand.getBrandid()!=id)
    		throw new ResourseNotFoundException("id is not exist");
		Brand existingBrand = this.brandRepo.findById(id)
        		.orElseThrow(()->new ResourseNotFoundException("Brand is not present of this id:" +id));
		
		existingBrand.setBrandname(brand.getBrandname());
		existingBrand.setBrandlogo(brand.getBrandlogo());
		existingBrand.setCategoryid(brand.getCategoryid()); 
		
		logger.error("brandid  is  not present");
    	return brandRepo.save(brand);
	}
}

