package com.example.NguyenMinhThuan_KienTrucPhanMem_ThiGK.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.NguyenMinhThuan_KienTrucPhanMem_ThiGK.model.Product;
import com.example.NguyenMinhThuan_KienTrucPhanMem_ThiGK.repository.ProductRepository;
@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getAllProduct() {
		return productRepository.getAllProduct();
	}
	
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}
}
