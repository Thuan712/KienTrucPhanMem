package com.example.NguyenMinhThuan_KienTrucPhanMem_ThiGK.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.NguyenMinhThuan_KienTrucPhanMem_ThiGK.model.Permission;
import com.example.NguyenMinhThuan_KienTrucPhanMem_ThiGK.repository.PermissionRepository;


@Service
public class PermissionService {
	@Autowired
	private PermissionRepository repository;
	
	public Permission findByName(String name) {
		Permission permission = repository.findByName(name);
		return permission;
	}
}
