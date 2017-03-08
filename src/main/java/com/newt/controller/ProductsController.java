package com.newt.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.newt.entity.Products;

import com.newt.service.ProductsService;

@RestController
@RequestMapping("/products")
public class ProductsController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductsController.class);
	/*String serviceName = "CustomerMicroService";
	String url = "http://" + serviceName;*/

	@Autowired
	ProductsService productsService;

	@RequestMapping(value="/add",method = RequestMethod.POST)
	public Products addProducts(@RequestBody Products products) {
		LOGGER.info("format", products);
		return productsService.addProducts(products);
	}

	@RequestMapping(value = "/{productId}", method = RequestMethod.GET)
	public Products getProductByProductId(@PathVariable("productId") int productId) {
		return productsService.getProductsByProductId(productId);
	}

	@RequestMapping(value="/allProducts",method = RequestMethod.GET)
	public List<Products> getAllProducts() {
		return productsService.getAllProducts();
	}

	@RequestMapping(value="/update",method = RequestMethod.PUT)
	public Products updateProducts(@RequestBody Products products) {

		return productsService.updateProducts(products);

	}

	@RequestMapping(value = "Delete/{productId}", method = RequestMethod.DELETE)
	public void deleteOrder(@PathVariable("productId") int productId) {
		productsService.deleteProducts(productId);
	}
	
	@RequestMapping(value = "/ByName/{productName}", method = RequestMethod.GET)
	public Products getProductByproductName(@PathVariable("productName") String productName) {
		return productsService.getProductsByProductName(productName);
	}
}
