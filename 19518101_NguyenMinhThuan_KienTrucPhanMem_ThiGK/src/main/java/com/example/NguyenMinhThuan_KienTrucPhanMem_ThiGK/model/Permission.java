package com.example.NguyenMinhThuan_KienTrucPhanMem_ThiGK.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Permission {
	@Id
	@GeneratedValue
	private int id;
	@Column
	private String name;
	public Permission(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Permission() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
