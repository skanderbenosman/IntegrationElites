package tn.esprit.spring.services;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.UserRepository;

public class DepartementServiceImpl {

	@Autowired
	DepartementRepository depRepository;

	private static final Logger l = LogManager.getLogger(DepartementServiceImpl.class);



	
	
	public List<Departement> retrieveAllDepartements() { 
		List<Departement> deps = null; 
		try {
	
			l.info("In retrieveAllUsers() : ");
			deps = (List<Departement>) depRepository.findAll();  
			for (Departement dep : deps) {
				l.debug("user +++ : " + dep);
			} 
			l.info("Out of retrieveAllDepartements() : ");
		}catch (Exception e) {
			l.error("Error in retrieveAllDepartements() : " + e);
		}

		return deps;
	}


	public Departement addDep(Departement dep) {
		return depRepository.save(dep); 
	}

	public Departement updateDepartement(Departement dep) { 
		return depRepository.save(dep);
	}

	public void deleteDepartement(String id) {
		depRepository.deleteById(Long.parseLong(id));
	}

	public Departement retrieveDepartement(String id) {
		l.info("in  retrieveDepartement id = " + id);
		//User u =  userRepository.findById(Long.parseLong(id)).orElse(null);
		//int i = 1/0; 
		Departement dep =  depRepository.findById(Long.parseLong(id)).get(); 
		l.info("deprtement returned : " + dep);
		return dep; 
	}
}
