package tn.esprit.spring.services;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;
import tn.esprit.spring.repository.UserRepository;

public class DepartementServiceImpl {

	@Autowired
	DepartementRepository depRepository;
	EntrepriseRepository entrepriseRepository;

	private static final Logger l = LogManager.getLogger(DepartementServiceImpl.class);	
	public List<Departement> retrieveAllDepartements() { 
		List<Departement> deps = null; 
		try {
	
			l.info("In retrieveAllDepartements() : ");
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
	public Departement affecterDepartementAEntreprise(int depId, int entrepriseId) {
		try {
			     l.info("In affecterDepartementAEntreprise :  ");	
				 Entreprise entrepriseManagedEntity = entrepriseRepository.findById(entrepriseId).orElse(null);
			     l.debug("get entrepriseManagedEntity ");
		         Departement depManagedEntity = depRepository.findById(depId).orElse(null);
		         l.debug("get depManagedEntity ");   
				if(depManagedEntity!=null){
					 l.debug("In If ");
					 depManagedEntity.setEntreprise(entrepriseManagedEntity);
					 l.debug("Affecter ");
				     Departement d = depRepository.save(depManagedEntity);
				     l.debug("Save");	
				     l.info("Out of affecterDepartementAEntreprise.  ");
				     return d ;
					}
		
					return null ;
					}catch (Exception e) {
						l.error("erreur In affecterDepartementAEntreprise() : Failed to affect " + e);
						return null ; }
		 
					}

	
	

	@Transactional
	public Departement desaffecterDepartementDuEntreprise (int depId , int entId){
		try {
			l.info("In desaffecterDepartementDuEntreprise :  ");
			Entreprise ent = entrepriseRepository.findById(entId).orElse(null);
			l.info("get ent ");
			Departement depManagedEntity = depRepository.findById(depId).orElse(null);
			l.info("get depManagedEntity ");
			if (depManagedEntity != null){
		  if (depManagedEntity.getEntreprise() == ent )
		    {
			l.debug("In if.. ");
			depManagedEntity.setEntreprise(null);
		
			l.debug("Removed. ");
		    }
	
		    l.info("Out of desaffecterDepartementDuEntreprise.  ");
		    return depManagedEntity ;
			}
			return null; 
	
		}catch (Exception e) {
			l.error("erreur In affecterDepartementAEntreprise() : Failed to affect " + e);
			return null ; 
		}
		}

	public Departement addDep(Departement dep) {
		return depRepository.save(dep); 
	}

	public Departement updateDepartement(Departement dep) { 
		return depRepository.save(dep);
	}

	@Transactional
	public int deleteDepartementById(int depId) {
		try {
			  l.info("In deleteDepartmentById  :  ");
			  
			  l.info(" department id= " + depId);
			  Departement depA = depRepository.findById(depId).orElse(null);
			  if (depA != null )
			  {		
		depRepository.delete(depRepository.findById(depId).orElse(null));	
		 l.info("Out of deleteDepartmentById.  ");
		  return 0;}
		  else { return -1; }
		 
		} 
		catch (Exception e) {
			
			l.error("erreur In deleteDepartementById() : could not be found " + e); 
			return -1 ;
			 }
			  
	}

	public Departement retrieveDepartement(int id) {
		l.info("in  retrieveDepartement id = " + id);
		//User u =  userRepository.findById(Long.parseLong(id)).orElse(null);
		//int i = 1/0; 
		Departement dep =  depRepository.findById(id).get(); 
		l.info("deprtement returned : " + dep);
		return dep; 
	}
}
