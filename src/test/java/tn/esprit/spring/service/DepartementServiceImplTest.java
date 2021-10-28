package tn.esprit.spring.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.services.IDepartementService;

public class DepartementServiceImplTest {
	@Autowired
	IDepartementService deps; 

	@Test
	public void testRetrieveAllDepartements() {
		List<Departement> listDeps = deps.retrieveAllDepartements(); 
		// if there are 7 users in DB : 
		Assert.assertEquals(15, listDeps.size());
	}
	
	
	@Test
	public void testAddUser() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-23");
		User u = new User("Mayssa1", "Mayssa1", d, Role.INGENIEUR); 
		User userAdded = us.addUser(u); 
		Assert.assertEquals(u.getLastName(), userAdded.getLastName());
	}
 
	@Test
	public void testModifyUser() throws ParseException   {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-23");
		User u = new User(5L, "Mayssa122222222", "Mayssa", d, Role.INGENIEUR); 
		User userUpdated  = us.updateUser(u); 
		Assert.assertEquals(u.getLastName(), userUpdated.getLastName());
	}

	@Test
	public void testRetrieveUser() {
		User userRetrieved = us.retrieveUser("1"); 
		Assert.assertEquals(1L, userRetrieved.getId().longValue());
	}
	
	@Test
	public void testDeleteUser() {
		us.deleteUser("3");
		Assert.assertNull(us.retrieveUser("3"));
	}

}
