package com.example.NguyenMinhThuan_KienTrucPhanMem_ThiGK.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.NguyenMinhThuan_KienTrucPhanMem_ThiGK.model.Permission;


@Repository
public interface PermissionRepository extends CrudRepository<Permission, Integer>{
	Permission findByName(String name);
}
