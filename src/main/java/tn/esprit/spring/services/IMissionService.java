package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Mission;

public interface IMissionService {
	
	List<Mission> retrieveAllMissions(); 
	Mission addMission(Mission u);
	void deleteUMission(String id);
	Mission updateMission(Mission u);
	Mission retrieveMission(String id);

}
