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

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.services.IContratService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContratServiceImplTest {

	@Autowired
	IContratService cs;
	
	@Test
	public void testRetrieveAllContrats() {
		List<Contrat> listContrats = cs.retrieveAllContrats(); 
		 //if there are 7 users in DB : 
		Assert.assertEquals(2, listContrats.size());
	}
	@Test
	public void testAddContrat() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-23");
		Contrat c = new Contrat(d, "test", 100.5f);
		Contrat contratAdded = cs.addContrat(c);
		Assert.assertEquals(c.getTypeContrat(), contratAdded.getTypeContrat());
	}
	@Test
	public void testModifyContrat() throws ParseException   {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-23");
		Contrat c = new Contrat(5, d, "aaa", 100.6f);
		Contrat ContratUpdated  = cs.updateContrat(c); 
		Assert.assertEquals(c.getTypeContrat(), ContratUpdated.getTypeContrat());
	}

	@Test
	public void testRetrieveContrat() {
		Contrat ContratRetrieved = cs.retrieveContrat("6");
		Assert.assertEquals(6, ContratRetrieved.getReference());
	}
	/*
	@Test
	public void testDeleteContrat() {
		
		cs.deleteContrat("5");
		
		Assert.assertNull(cs.retrieveContrat("5"));
	}*/
}
