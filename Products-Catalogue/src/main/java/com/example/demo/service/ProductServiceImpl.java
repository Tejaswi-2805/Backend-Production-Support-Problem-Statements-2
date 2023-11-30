package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository repo;

	@Override
	public Product addProduct(Product productList) {
		return repo.save(productList);
	}

	


	@Override
	public Optional<Product> searchProduct(int productId) {
		Optional<Product> product=repo.findById(productId);
		return product;
	}

	@Override
	public void deleteProduct(int productId) {
		// TODO Auto-generated method stub
		if(repo.existsById(productId)) {
			repo.deleteById(productId);
		}
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		List<Product> products=repo.findAll();
		return products;
	}

}
