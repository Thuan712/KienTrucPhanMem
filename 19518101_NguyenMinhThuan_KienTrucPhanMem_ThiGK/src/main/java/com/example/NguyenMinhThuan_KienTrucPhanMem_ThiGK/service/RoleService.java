package com.example.NguyenMinhThuan_KienTrucPhanMem_ThiGK.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.NguyenMinhThuan_KienTrucPhanMem_ThiGK.model.Role;
import com.example.NguyenMinhThuan_KienTrucPhanMem_ThiGK.repository.RoleRepository;

@Service
public class RoleService  {
	@Autowired
	private RoleRepository repository;
	public Role findByName(String name) {
		Role role = repository.findByName(name);
		return role;
	}
}
