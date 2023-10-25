package com.register.registerrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.register.registerrol.entities.Roles;
//
//@Repository("roleRepository")
//public interface RoleRepository extends JpaRepository<Roles, Integer> {
//
//	int countByRoleId( Long roleId);
//	
//	Roles findByRoleId(long roleId);
//    int countByRoleNameContainingIgnoreCase( String roleName);
//	
//	int countByRoleNameContainingIgnoreCaseAndRoleId(String roleName,Long roleId);
//	
//		
//}