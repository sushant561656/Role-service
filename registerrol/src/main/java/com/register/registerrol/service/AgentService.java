package com.register.registerrol.service;


	import java.util.List;

import com.register.registerrol.entities.Agent;


public interface  AgentService {
		public List<Agent> getAgent();
		
		public Agent addAgent(Agent agent);

		public Agent updateAgent(Agent agent);

//		public Agent deleteAgent(Agent id);


	}


