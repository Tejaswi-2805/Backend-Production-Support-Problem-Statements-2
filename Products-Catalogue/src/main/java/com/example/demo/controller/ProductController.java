package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
//@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	ProductService productService;
	
	@RequestMapping("/hello")
	public String Hello() {
		return "HELLO";
	}
	
	@GetMapping("/getAllProducts")
	List<Product> getAll(){
		List<Product> products=productService.getAllProducts();
		return products;
	}
	
	@GetMapping("/{ProductId}")
	public Optional<Product> searchProduct(@PathVariable int ProductId) {
		Optional<Product> product=productService.searchProduct(ProductId);
		return product;
	}
	@DeleteMapping("/{ProductId}")
	public ResponseEntity<Void> deleteProduct(@PathVariable int ProductId) {
		productService.deleteProduct(ProductId);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/addproduct")
	public Product addProduct(@RequestBody Product productList ) {
		return productService.addProduct(productList);
	}

}
