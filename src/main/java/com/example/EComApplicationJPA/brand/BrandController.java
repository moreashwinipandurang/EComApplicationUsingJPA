package com.example.EComApplicationJPA.brand;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BrandController
{
	@Autowired
    public BrandService brandService;

    
    Logger logger = LoggerFactory.getLogger(BrandController.class);
    

    //get all Brand
    @GetMapping("/getAllBrand")
    public List<Brand> getAllBrand()
    {
    	logger.error("provide valid url");
        return this.brandService.getAllBrand();
    }

    //get brand by perticular brandname
    @GetMapping("/getBrnadByPerticularBrandname/{brandname}")
    public Brand getBrandBybrandname(@PathVariable ("barndname") String catname)
    {
    	return this.brandService.getBrandByName(catname);
    }
    
    //delete brand if category is not present in brand
    
    @DeleteMapping("/deleteById/{brandid}")
    public void deleteById(@PathVariable ("brandid") long brandid)
    {
    	this.brandService.deleteById(brandid);
    }
    
    // add brand
    @PostMapping("/addBrand")
    public void addBrand(@RequestBody Brand brand)
    {
    	brandService.addBrand(brand);
    	
    }
    
    
    // update brand by id
    @PutMapping("/updateBrand/{id}")
    public Brand updateBrand(@PathVariable("id") Long id,@RequestBody Brand brand)
    {
    	return brandService.updateBrand(id,brand);
    }
    

}

