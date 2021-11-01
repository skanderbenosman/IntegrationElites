package tn.esprit.spring.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;
import tn.esprit.spring.services.IDepartementService;

public class DepartementServiceImplTest {
	@Autowired
	IDepartementService DepService; 
	@Autowired
    EntrepriseRepository entrepriseRepoistory;
	@Autowired
	DepartementRepository deptRepoistory;
	
	@Test
	public void testGetAllDepartements()  {
		
		List <Departement> listDep = DepService.retrieveAllDepartements();
		assertNotNull(listDep);
	}
	
	@Test
	public void testAjouterDepartement(){
		Departement d = new Departement ("IT Dep");
		Departement dAdded = DepService.addDep(d);
		assertEquals(d.getName(), dAdded.getName());
	}
	@Test
	public void testAffecterDepartementAEntreprise() {
		int entrepriseId = 3 ;
		int depId = 3;  
		Departement Dep = deptRepoistory.findById(depId).orElse(null);
		Entreprise Ent = entrepriseRepoistory.findById(entrepriseId).orElse(null);
		if (Dep != null){
		Dep.setEntreprise(Ent);
		Departement dep = DepService.affecterDepartementAEntreprise(depId, entrepriseId);
		Assert.assertEquals (Dep.getEntreprise().getId(),dep.getEntreprise().getId());
		}
			
	}
	@Test
	public void testDesaffecterDepartementDuEntreprise () {
		int entId = 1 ;
		int depId = 1 ;
	    DepService.desaffecterDepartementAEntreprise(depId, entId);
	    Departement Dep = deptRepoistory.findById(depId).orElse(null);
	    if(Dep != null){
		assertNull (Dep.getEntreprise());
	    }
	}
	@Test
	  public void testGetDepartementById(){
		int depId = 2;//+1
		Departement dep= DepService.retrieveDepartement(depId);
		
		assertEquals(2, dep.getId());
	}
	
	
	@Test
	public void testDeleteDepartementById(){
		int depId = 49 ;
		int i = DepService.deleteDepartement(depId);
		assertEquals(0, i);
		
		

	}

}
