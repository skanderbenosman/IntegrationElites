package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.EmployeRepository;



@Service
public class EmployeServiceImpl implements IEmployeService {

	@Autowired
	EmployeRepository employeRepository;
	
	private static final Logger l = LogManager.getLogger(EmployeServiceImpl.class);
	@Override
	public List<Employe> retrieveAllEmployes() {
		List<Employe> employes = null; 
		try {
	
			l.info("In retrieveAllUsers() : ");
			employes = (List<Employe>) employeRepository.findAll();  
			for (Employe employe : employes) {
				l.debug("employe +++ : " + employe);
			} 
			l.info("Out of retrieveAllUsers() : ");
		}catch (Exception e) {
			l.error("Error in retrieveAllUsers() : " + e);
		}

		return employes;
	}

	@Override
	public Employe addEmploye(Employe u) {

		return employeRepository.save(u); 
	}

	@Override
	public void deleteEmploye(String id) {

		employeRepository.deleteById(Long.parseLong(id));	
	}

	@Override
	public Employe updateEmploye(Employe u) {

		return employeRepository.save(u);
	}

	@Override
	public Employe retrieveEmploye(String id) {
		l.info("in  retrieveUser id = " + id);

		Employe u =  employeRepository.findById(Long.parseLong(id)).orElse(null); 
		l.info("employe returned : " + u);
		return u; 
	}

}
