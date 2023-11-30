package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Product;


public interface ProductService {
	List<Product> getAllProducts();
	public Product addProduct(Product productList);
	Optional<Product> searchProduct(int productId);
	void deleteProduct(int productId);
}
