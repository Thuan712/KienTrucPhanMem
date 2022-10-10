package com.example.NguyenMinhThuan_KienTrucPhanMem_ThiGK.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.NguyenMinhThuan_KienTrucPhanMem_ThiGK.model.User;



@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
}