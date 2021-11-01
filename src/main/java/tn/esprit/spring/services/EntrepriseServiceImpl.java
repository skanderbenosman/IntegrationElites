package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities. Entreprise;

import tn.esprit.spring.repository. EntrepriseRepository;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService {
	@Autowired
	 EntrepriseRepository EntrepriseRepository;

	private static final Logger l = LogManager.getLogger(EntrepriseServiceImpl.class);

	@Override
	public List<Entreprise> retrieveAllEntreprises() {
		List<Entreprise> Entreprises = null; 
		try {
	
			l.info("In retrieveAllEntreprises() : ");
			Entreprises = (List<Entreprise>) EntrepriseRepository.findAll();  
			for (Entreprise En : Entreprises) {
				l.debug("Entreprise +++ : " + En);
			} 
			l.info("Out of retrieveAllEntreprises() : ");
		}catch (Exception e) {
			l.error("Error in retrieveAllEntreprise() : " + e);
		}

		return Entreprises;
	}

	@Override
	public Entreprise addEntreprise(Entreprise u) {
		return EntrepriseRepository.save(u); 
	}

	@Override
	public void deleteEntreprise(String id) {
		EntrepriseRepository.deleteById(Long.parseLong(id));
		
	}

	@Override
	public Entreprise updateEntreprise(Entreprise u) {
		return EntrepriseRepository.save(u); 
	}

	@Override
	public Entreprise retrieveEntreprise(String id) {
		l.info("in  retrieveEntreprise id = " + id);
		//User u =  userRepository.findById(Long.parseLong(id)).orElse(null);
		//int i = 1/0; 
		Entreprise u = EntrepriseRepository.findById(Long.parseLong(id)).get(); 
		l.info("Entreprise returned : " + u);
		return u; 
	}



}
