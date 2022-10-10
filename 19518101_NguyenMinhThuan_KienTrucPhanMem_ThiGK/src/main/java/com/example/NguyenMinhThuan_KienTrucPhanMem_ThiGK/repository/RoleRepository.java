package com.example.NguyenMinhThuan_KienTrucPhanMem_ThiGK.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.NguyenMinhThuan_KienTrucPhanMem_ThiGK.model.Role;



@Repository
public interface RoleRepository extends CrudRepository<Role, Integer>{
	Role findByName(String name);
}
