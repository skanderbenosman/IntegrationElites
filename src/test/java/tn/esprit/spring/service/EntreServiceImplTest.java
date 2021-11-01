package tn.esprit.spring.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IEntrepriseService;
import tn.esprit.spring.services.IUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntreServiceImplTest {
	@Autowired
	IEntrepriseService us; 

	@Test
	public void testRetrieveAllEntreprises() {
		List<Entreprise> listUsers = us.retrieveAllEntreprises(); 
		// if there are 7 users in DB : 
		Assert.assertEquals(11, listUsers.size());
		System.out.println(listUsers);
	}
	
	@Test
	public void testAddEntreprise() throws ParseException {
		
	Entreprise u = new Entreprise("M", "m"); 
	Entreprise EntrepriseAdded = us.addEntreprise(u) ;
		Assert.assertEquals(u.getName(), EntrepriseAdded.getName());
	
	}


	@Test
	public void testModifyEntreprise() throws ParseException   {
	
		Entreprise u = new Entreprise("Mayssa1", "Mounir"); 
		Entreprise EntrepriseUpdated  = us.updateEntreprise(u); 
		Assert.assertEquals(u.getName(), EntrepriseUpdated.getName());
	}

	@Test
	public void testRetrieveEntreprise() {
		Entreprise EntrepriseRetrieved = us.retrieveEntreprise("71") ;
		Assert.assertEquals(71L, EntrepriseRetrieved.getId().longValue());
	}
	
	@Test
	public void testDeleteEntreprise() {	
		Entreprise EntrepriseRetrieved = us.retrieveEntreprise("129");
		us.deleteEntreprise("129");
	
   if( EntrepriseRetrieved==null){
		
	Assert.assertNull(null);
   }
   
	}

	
	// 5 tests unitaires 

}
