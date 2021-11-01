package tn.esprit.spring.service;

import static org.junit.Assert.assertEquals;



import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.services.IDepartementService;

public class DepartementServiceImplTest {
	@Autowired
	IDepartementService DepService; 

	
	@Test
	public void testGetAllDepartements()  {
		
		List <Departement> listDep = DepService.retrieveAllDepartements();
		Assert.assertEquals(3, listDep.size());
	}
	
	@Test
	public void testAjouterDepartement(){
		Departement d = new Departement ("IT Dep");
		Departement dAdded = DepService.addDep(d);
		assertEquals(d.getName(), dAdded.getName());
	}
/*	@Test
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
	} */
	@Test
	  public void testGetDepartementById(){
		int depId = 2;//+1
		Departement dep= DepService.retrieveDepartement(depId);
		
		assertEquals(2, dep.getId());
	}
	
	
	@Test
	public void testDeleteDepartementById(){
		DepService.deleteDepartementById(2);
		
		Assert.assertNull(DepService.retrieveDepartement(2));
		
		

	}

}
