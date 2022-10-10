package com.example.NguyenMinhThuan_KienTrucPhanMem_ThiGK.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "proid")
	private int ProId;
	@Column
	private String name;
	@Column
	private double price;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int proId, String name, double price) {
		super();
		ProId = proId;
		this.name = name;
		this.price = price;
	}
	public int getProId() {
		return ProId;
	}
	public void setProId(int proId) {
		ProId = proId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
