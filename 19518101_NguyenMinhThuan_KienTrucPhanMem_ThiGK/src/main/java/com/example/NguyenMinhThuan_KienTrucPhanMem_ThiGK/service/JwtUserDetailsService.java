package com.example.NguyenMinhThuan_KienTrucPhanMem_ThiGK.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.NguyenMinhThuan_KienTrucPhanMem_ThiGK.model.Permission;
import com.example.NguyenMinhThuan_KienTrucPhanMem_ThiGK.model.Role;
import com.example.NguyenMinhThuan_KienTrucPhanMem_ThiGK.model.User;
import com.example.NguyenMinhThuan_KienTrucPhanMem_ThiGK.model.UserDto;
import com.example.NguyenMinhThuan_KienTrucPhanMem_ThiGK.repository.UserRepository;




@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userDao;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private PermissionService permissionService ;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}

	private Set<SimpleGrantedAuthority> getAuthority(User user) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		user.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));

		});
		return authorities;
	}

	public List<User> findAll(){
		List<User> list = new ArrayList<User>();
		userDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}
	
	public User save(UserDto user) {
		User newUser = new User();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		
		Permission permission = permissionService.findByName("READ");
		Set<Permission> permissions = new HashSet<>();
		permissions.add(permission);
		
		Role role = roleService.findByName("USER");
		Set<Role> roles = new HashSet<>();
		roles.add(role);
		
		if(newUser.getUsername().equals("admin")) {
			role = roleService.findByName("ADMIN");
			roles.add(role);
		}
		newUser.setRoles(roles);
		newUser.setPermissions(permissions);
		return userDao.save(newUser);
	}
}