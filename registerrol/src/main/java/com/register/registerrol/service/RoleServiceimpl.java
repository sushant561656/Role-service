package com.register.registerrol.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.register.registerrol.entities.Roles;
//import com.register.registerrol.repository.RoleRepository;
import com.register.registerrol.roleDao.Dowrole;



@Service
public class RoleServiceimpl implements RoleService {
	@Autowired
	private Dowrole dowrole;
//	
//	@Autowired
//	public
//	RoleRepository roleRepository;
//	List<Roles> list;
	
	public RoleServiceimpl() {
//		list=new ArrayList<>();
//		list.add(new Roles("sushant","kanwade",72183720, "sushant5616@gmail.com","sush5616"));
//		list.add(new Roles("sujit","vasagade",72183720, "sushant5616@gmail.com","sujit5616"));
	}

	@Override
	public List<Roles> grtRole() {
	
	return dowrole.findAll();
	}

	@Override
	public Roles addRole(Roles roles) {
//		list.add(roles);
//		int isRoleExistCount = 0;
//		BaseResponse<Roles> baseResponse = new BaseResponse<>();
//		isRoleExistCount =roleRepository.countByRoleNameContainingIgnoreCase(roles.getName());
//
//		if (isRoleExistCount > 0) {
//			baseResponse.setStatus(CommonConstant.FAIL);
//			baseResponse.setReasonCode("");
//			baseResponse.setReasonText("Role name already exist");
//			
//		}
		dowrole.save(roles);
		
		return roles;
	}

	@Override
	public Roles updateRole(Roles roles) {
//		list.forEach(s ->{
//			if(s.getName()==roles.getName()) {
//				s.setSurname(roles.getSurname());
//				s.setContact(roles.getContact());
//				s.setEmail(roles.getEmail());
//				s.setPassword(roles.getPassword());
//				
//			}
//		});
		dowrole.save(roles);
		return roles;
	}

	@Override
	public Roles deleteRole(Roles id) {
		dowrole.delete(id);
		return null;
	}




}
