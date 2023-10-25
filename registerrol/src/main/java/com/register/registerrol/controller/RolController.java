package com.register.registerrol.controller;


import java.util.List;
import java.util.regex.Pattern;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.register.registerrol.entities.Roles;
import com.register.registerrol.service.RoleService;
import com.register.registerrol.util.BaseResponse;
import com.register.registerrol.util.CommonConstant;


@RestController
public class RolController {
	@Autowired
	private RoleService roleService;
	
	
	
//	@SuppressWarnings("null")
	@PostMapping("/addAdmin")
	public ResponseEntity<BaseResponse<Roles>> addRole(@RequestBody Roles roles) 
	{
		BaseResponse<Roles> br = new BaseResponse<Roles>();
		String reasonCode = "";
		try {
			 reasonCode = checkRoleValidation(roles);
			 if (reasonCode.equalsIgnoreCase("")) {
			this.roleService.addRole(roles);
			br.setStatus(CommonConstant.SUCCESS);
			br.setReasonCode("200");
			br.setReasonText("Data add successfully.");
			br.setResponseObject(roles);
			 }
			 else {
					br.setStatus(CommonConstant.FAIL);
					br.setReasonText(reasonCode);
			 }
			
		} catch (Exception e) {
		   br.setStatus(CommonConstant.FAIL);
			br.setReasonText("Reason is :: " + e.getMessage());
		}
		
		return new ResponseEntity<>(br, null, HttpStatus.OK);
	}


	@PutMapping("/updateAdmin")
	public ResponseEntity<BaseResponse<Role>>  updateRole(@RequestBody Roles roles)
	{
		
//		return this.roleService.updateRole(roles);
		BaseResponse<Role> br = new BaseResponse<Role>();
		String reasonCode = "";
		try {
			 reasonCode = checkRoleValidation(roles);
			 if (reasonCode.equalsIgnoreCase("")) {
		    this.roleService.updateRole(roles);
		  
			br.setStatus(CommonConstant.SUCCESS);
			br.setReasonCode("200");
			br.setReasonText("Data update successfully.");
			br.setResponseObject(roles);
			 }
			 else {
					br.setStatus(CommonConstant.FAIL);
					br.setReasonText(reasonCode);
			 }
			 
		} catch (Exception e) {
		   br.setStatus(CommonConstant.FAIL);
			br.setReasonText("Reason is :: " + e.getMessage());
		}
		
		return new ResponseEntity<>(br, null, HttpStatus.OK);
	
			
	}
	
	@GetMapping("/adminList")
	public List<Roles> getRole()
	{
		return this.roleService.grtRole();
		
	}
	@DeleteMapping("/deleteAdmin/{id}")
	public ResponseEntity<BaseResponse<Roles>>  deleteRole(@PathVariable Roles id) 
	{
		//return this.roleService.deleteRole(id);
		BaseResponse<Roles> br = new BaseResponse<Roles>();
		try {
			
			this.roleService.deleteRole(id);
			br.setStatus(CommonConstant.SUCCESS);
			br.setReasonCode("200");
			br.setReasonText("Data delete successfully.");
			br.setResponseObject(id);
			
		}
		catch (Exception e) {
		   br.setStatus(CommonConstant.FAIL);
			br.setReasonText("Reason is :: " + e.getMessage());
		}
		
		return new ResponseEntity<>(br, null, HttpStatus.OK);
		
	}
	
	private String checkRoleValidation(Roles roles) {
		String reasonCode = "";
		final Pattern alphabetPattern = Pattern.compile("[A-Za-z ]++$");
		final Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");
		final Pattern passwordPattern = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
		final Pattern contactPattern = Pattern.compile("^\\+?[1-9][0-9]{7,9}$");
		
		if (roles.getName() == null || roles.getName().isEmpty()) {
			reasonCode = ("Admin name should not be empty.");
			}
		else if ((roles.getName() != null && !roles.getName().isEmpty())
				&& !alphabetPattern.matcher(roles.getName()).matches()) {
			reasonCode = ("Admin name validation.");
			}
		else if(roles.getSurname() == null || roles.getSurname().isEmpty()) {
			reasonCode = ("Admin surname should not be empty.");
		}
		else if ((roles.getSurname() != null && !roles.getSurname().isEmpty())
				&& !alphabetPattern.matcher(roles.getSurname()).matches()) {
			reasonCode = ("Admin surname validation.");
			}
		else if(roles.getEmail() == null || roles.getEmail().isEmpty()) {
			reasonCode = ("Admin Email Id should not be empty.");
		}
		else if ((roles.getEmail() != null && !roles.getEmail().isEmpty())
				&& !emailPattern.matcher(roles.getEmail()).matches()) {
			reasonCode = ("Admin Email Id validation.");
			}
		else if(roles.getPassword() == null || roles.getPassword().isEmpty()) {
			reasonCode = ("Admin password should not be empty.");
		}
		else if ((roles.getPassword() != null && !roles.getPassword().isEmpty())
				&& !passwordPattern.matcher(roles.getPassword()).matches()) {
			reasonCode = ("Admin password validation.");
			}
		else if (roles.getContact() == null || roles.getContact().isEmpty()) {
		    reasonCode = "Admin contact number should not be empty.";
		}
		else if ((roles.getContact() != null && !roles.getContact().isEmpty())
				&& !contactPattern.matcher(roles.getContact()).matches()) {
			reasonCode = ("Admin contact number validation.");
			}
		

	return reasonCode ;
}

}
