package com.example.NguyenMinhThuan_KienTrucPhanMem_ThiGK.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.NguyenMinhThuan_KienTrucPhanMem_ThiGK.model.Product;





@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{
	@Query("Select pd from Product pd")
	public List<Product> getAllProduct();
}
