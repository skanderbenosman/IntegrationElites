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

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IContratService;
import tn.esprit.spring.services.IEmployeService;
import tn.esprit.spring.services.IUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeServiceImplTest {
	@Autowired
	IEmployeService us; 
	@Autowired
	IContratService uc;

	@Test
	public void testRetrieveAllUsers() {
		List<Employe> listUsers = us.retrieveAllEmployes();
		System.out.println("resultat:***"+listUsers);
		// if there are 7 users in DB : 
		Assert.assertEquals(2, listUsers.size());
	}

	

	@Test
	public void testAddEmploye() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Boolean d = false;
	//	System.out.println("***"+uc.retrieveContrat("1") );
		Employe u = new Employe("med", "mselmi", "mohamed.mselmi1@esprit.tn","123456", d, Role.INGENIEUR,uc.retrieveContrat("2")); 
		Employe employeAdded = us.addEmploye(u); 
	Assert.assertEquals(u.getNom(), employeAdded.getNom());
	}

	


	@Test
	public void testRetrieveEmploye() {
		Employe userRetrieved = us.retrieveEmploye("88");
		System.out.println("resultat retrieve :" +userRetrieved);
		Assert.assertEquals(88, userRetrieved.getId().longValue());
	}
	



	@Test
	public void testModifyEmploye() throws ParseException   {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-23");
		Employe u = new Employe( Long. valueOf("88"),"test1", "test1", "mohamed.mselmi1@esprit.tn","20251825", true, Role.INGENIEUR,uc.retrieveContrat("1"));
		Employe employeUpdated  = us.updateEmploye(u);
		Assert.assertEquals(u.getNom(), employeUpdated.getNom());
		Assert.assertEquals(u.getPrenom(), employeUpdated.getPrenom());
	}

	
	@Test
	public void testDeleteEmploye() {
		us.deleteEmploye("87");
	Assert.assertNull(us.retrieveEmploye("87"));
	}

	

}
