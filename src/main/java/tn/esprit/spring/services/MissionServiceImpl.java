package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.MissionRepository;
@Service
public class MissionServiceImpl implements IMissionService{
	
	@Autowired
	MissionRepository MissionRepository;
	private static final Logger l = LogManager.getLogger(UserServiceImpl.class);

	@Override
	public List<Mission> retrieveAllMissions() {
		List<Mission> mission = null; 
		try {
	
			l.info("In retrieveAllMissions() : ");
			mission = (List<Mission>) MissionRepository.findAll();  
			for (Mission C : mission) {
				l.debug("Contrat +++ : " + C);
			} 
			l.info("Out of retrieveAllUsers() : ");
		}catch (Exception e) {
			l.error("Error in retrieveAllUsers() : " + e);
		}

		return mission;
	}

	@Override
	public Mission addMission(Mission u) {
		
		return MissionRepository.save(u); 
	}

	@Override
	public void deleteUMission(String id) {
		MissionRepository.deleteById(Long.parseLong(id));
		
	}

	@Override
	public Mission updateMission(Mission u) {
		return MissionRepository.save(u); 

	}

	@Override
	public Mission retrieveMission(String id) {
		l.info("in  retrieveContrat id = " + id);
		//User u =  userRepository.findById(Long.parseLong(id)).orElse(null);
		//int i = 1/0; 
		System.out.println("aaaaa");
		Mission c =  MissionRepository.findById(Long.parseLong(id)).orElse(null); 
		System.out.println("");
		l.info("Contrat returned : " + c);
		
		return c; 
	}

}
