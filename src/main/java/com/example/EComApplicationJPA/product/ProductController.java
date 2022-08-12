package com.example.EComApplicationJPA.product;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController
{
	@Autowired
	private ProductService productService;
	
	@Autowired
    public ProductController(ProductService productService)
	{
        this.productService = productService;
    }
	
	
	// add product
	@PostMapping("/addproduct")
	public Product AddProduct(@RequestBody Product product)
    {
		Product pro =productService.addtProduct(product);
		return pro;
    }
	
	@GetMapping("/getAllProduct")
	public List<Product> getAllProduct()
	{
		return productService.getAllProduct();
		
	}
	
	@DeleteMapping("/deleteProduct/{proid}")
	public void deleteProduct(@PathVariable ("proid")Long proid)
	{
		productService.deleteProduct(proid);
	}
}