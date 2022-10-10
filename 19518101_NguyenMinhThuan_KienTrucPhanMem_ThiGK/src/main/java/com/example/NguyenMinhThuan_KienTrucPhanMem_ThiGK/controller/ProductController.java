package com.example.NguyenMinhThuan_KienTrucPhanMem_ThiGK.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.NguyenMinhThuan_KienTrucPhanMem_ThiGK.model.Product;
import com.example.NguyenMinhThuan_KienTrucPhanMem_ThiGK.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping("/getListProduct")
	public List<Product> getAllProduct(){
		return productService.getAllProduct();
	}
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		Product product2 =  productService.addProduct(product);
		return product2;
	}
}
