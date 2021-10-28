package tn.esprit.spring.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;


@Service
public class ContratServiceImpl implements IContratService {
	@Autowired
	ContratRepository contratRepository;
	
	private static final Logger l = LogManager.getLogger(ContratServiceImpl.class);
	@Override
	public Contrat retrieveContrat(String id) {
		l.info("in  retrieveUser id = " + id);
	
		Contrat u =  contratRepository.findById(Long.parseLong(id)).orElse(null); 
		l.info("contrat returned : " + u);
		return u; 
	}

}
