package com.example.EComApplicationJPA.product;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EComApplicationJPA.brand.Brand;
import com.example.EComApplicationJPA.brand.BrandRepository;
import com.example.EComApplicationJPA.brand.BrandService;
import com.example.EComApplicationJPA.category.CategoryRepository;
import com.example.EComApplicationJPA.exception.ResourseNotFoundException;



@Service
public class ProductService 
{
	@Autowired
	private ProductRepository proRepo;
	
	@Autowired
	private BrandRepository brandRepo;
	
	Logger logger = LoggerFactory.getLogger(ProductService.class);

//adding product
	public Product addtProduct(Product product) {
		
		List<Product> productobj=proRepo.findAll();
		List<Brand> brandobj=brandRepo.findAll();
		Product pro=new Product();
		
		for(Product p:productobj)
		{
			if(product.getProductname().equals(p.getProductname()))
			{
				throw new ResourseNotFoundException("Product is already exists...");
			}
			for(Brand b:brandobj)
			{
				if(b.getBrandid()!=(product.getBrandid()) && product.getCategoryid()!=(b.getCategoryid()))
				{
					//throw new ResourseNotFoundException("Product not added...");
				}
				else
				{
					logger.info("product added");
					pro= proRepo.save(product);
				}
			}
		}
		
		return pro;
	}

	
	
	//get product
	public List<Product> getAllProduct() {
		
		List<Product> pro=new ArrayList<Product>();
		proRepo.findAll().forEach(pro::add);
		return pro;
	}



	public void deleteProduct(Long proid)
	{
		proRepo.deleteById(proid);	
	}

}
