package com.register.registerrol.controller;


	import java.util.List;
import java.util.regex.Pattern;

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

import com.register.registerrol.entities.Agent;
import com.register.registerrol.entities.Roles;
import com.register.registerrol.service.AgentService;
import com.register.registerrol.util.BaseResponse;
import com.register.registerrol.util.CommonConstant;

import jakarta.websocket.server.PathParam;

	@RestController
	public class AgentController {
		@Autowired
		private AgentService agentService;
		
		@GetMapping("/agentList")
		public List<Agent> getAgent()
		{
			return this.agentService.getAgent();
			
		}
		
		@PostMapping("/addAgent")
		public ResponseEntity<BaseResponse<Agent>>  addAgent(@RequestBody Agent agent) 
		{
			BaseResponse<Agent> br = new BaseResponse<Agent>();
			String reasonCode = "";
//			return this.agentService.addAgent(agent);
			try {
				 reasonCode = checkRoleValidation(agent);
				 if (reasonCode.equalsIgnoreCase("")) {
			    this.agentService.addAgent(agent);
				br.setStatus(CommonConstant.SUCCESS);
				br.setReasonCode("200");
				br.setReasonText("Data add successfully.");
				br.setResponseObject(agent);
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
		
		@PutMapping("/updateAgent")
		public ResponseEntity<BaseResponse<Agent>>updateAgent(@RequestBody Agent agent)
		{
			BaseResponse<Agent> br = new BaseResponse<Agent>();
			String reasonCode = "";
			
			//return this.agentService.updateAgent(agent);
			try {
				 reasonCode = checkRoleValidation(agent);
				 if (reasonCode.equalsIgnoreCase("")) {
			    this.agentService.updateAgent(agent);
				br.setStatus(CommonConstant.SUCCESS);
				br.setReasonCode("200");
				br.setReasonText("Data add successfully.");
				br.setResponseObject(agent);
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
		
		private String checkRoleValidation(Agent agent) {
			String reasonCode = "";
			final Pattern alphabetPattern = Pattern.compile("[A-Za-z ]++$");
			final Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");
			final Pattern passwordPattern = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
			final Pattern contactPattern = Pattern.compile("^\\+?[1-9][0-9]{7,9}$");
			
			if (agent.getName() == null || agent.getName().isEmpty()) {
				reasonCode = ("Agent name should not be empty.");
				}
			else if ((agent.getName() != null && !agent.getName().isEmpty())
					&& !alphabetPattern.matcher(agent.getName()).matches()) {
				reasonCode = ("Agent name validation.");
				}
			else if(agent.getSurname() == null || agent.getSurname().isEmpty()) {
				reasonCode = ("Agent surname should not be empty.");
			}
			else if ((agent.getSurname() != null && !agent.getSurname().isEmpty())
					&& !alphabetPattern.matcher(agent.getSurname()).matches()) {
				reasonCode = ("Agent surname validation.");
				}
			else if(agent.getEmail() == null || agent.getEmail().isEmpty()) {
				reasonCode = ("Agent Email Id should not be empty.");
			}
			else if ((agent.getEmail() != null && !agent.getEmail().isEmpty())
					&& !emailPattern.matcher(agent.getEmail()).matches()) {
				reasonCode = ("Agent Email Id validation.");
				}
			else if(agent.getPassword() == null || agent.getPassword().isEmpty()) {
				reasonCode = ("Agent password should not be empty.");
			}
			else if ((agent.getPassword() != null && !agent.getPassword().isEmpty())
					&& !passwordPattern.matcher(agent.getPassword()).matches()) {
				reasonCode = ("Agent password validation.");
				}
			else if (agent.getContact() == null || agent.getContact().isEmpty()) {
			    reasonCode = "Agent contact number should not be empty.";
			}
			else if ((agent.getContact() != null && !agent.getContact().isEmpty())
					&& !contactPattern.matcher(agent.getContact()).matches()) {
				reasonCode = ("Agent contact number validation.");
				}
			

		return reasonCode ;
	}
		
//		@DeleteMapping("/deleteAgent/{id}")
//		public Agent deleteAgent(@PathVariable Agent id) 
//		{
//			return this.agentService.deleteAgent(id);
//			
//		}

	}


