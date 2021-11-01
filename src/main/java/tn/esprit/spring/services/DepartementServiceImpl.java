package tn.esprit.spring.services;

import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;

public class DepartementServiceImpl implements IDepartementService{

	@Autowired
	DepartementRepository depRepository;
	@Autowired
	EntrepriseRepository entrepriseRepository;

	private static final Logger l = LogManager.getLogger(DepartementServiceImpl.class);	
	
	@Override
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
	@Override
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

	
	

	@Override
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
	@Override
	public Departement addDep(Departement dep) {
		return depRepository.save(dep); 
	}
	@Override
	public Departement updateDepartement(Departement dep) { 
		return depRepository.save(dep);
	}

	@Override
	public void deleteDepartementById(int depId) {
		depRepository.deleteById(depId);

	}
	@Override
	public Departement retrieveDepartement(int id) {
		l.info("in  retrieveDepartement id = " + id);

		Departement dep =  depRepository.findById(id).get(); 
		l.info("deprtement returned : " + dep);
		return dep; 
	}


}
