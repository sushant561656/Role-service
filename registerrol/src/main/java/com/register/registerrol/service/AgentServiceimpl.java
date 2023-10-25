package com.register.registerrol.service;


	
	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import com.register.registerrol.entities.Agent;

import com.register.registerrol.roleDao.Dowagent;

	@Service
	public class AgentServiceimpl  implements AgentService {
		@Autowired
		private Dowagent dowagent;
		


		@Override
		public List<Agent> getAgent() {
		
		return dowagent.findAll();
		}

		@Override
		public Agent addAgent(Agent agent) {
//			list.add(roles);
			dowagent.save(agent);
			
			return agent;
		}

		@Override
		public Agent updateAgent(Agent agent) {
//			list.forEach(s ->{
//				if(s.getName()==roles.getName()) {
//					s.setSurname(roles.getSurname());
//					s.setContact(roles.getContact());
//					s.setEmail(roles.getEmail());
//					s.setPassword(roles.getPassword());
//					
//				}
//			});
			dowagent.save(agent);
			return agent;
		}

//		@Override
//		public Agent deleteAgent(Agent id) {
//			dowagent.delete(id);
//			return null;
//		}




	}


