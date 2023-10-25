package com.register.registerrol.service;

import java.util.List;

import com.register.registerrol.entities.Roles;

public interface RoleService {
	public List<Roles> grtRole();
	
	public Roles addRole(Roles roles);

	public Roles updateRole(Roles roles);

	public Roles deleteRole(Roles id);


}