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
		//Assert.assertEquals(15, listUsers.size());
	}



	@Test
	public void testAddEmploye() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Boolean d = false;
		System.out.println("***"+uc.retrieveContrat("1") );
		Employe u = new Employe("mohamed", "mselmi", "mohamed.mselmi1@esprit.tn","123456", d, Role.INGENIEUR,uc.retrieveContrat("1")); 
		Employe employeAdded = us.addEmploye(u); 
	//	Assert.assertEquals(u.getLastName(), userAdded.getLastName());
	}

	


	@Test
	public void testRetrieveEmploye() {
		Employe userRetrieved = us.retrieveEmploye("14");
		System.out.println("resultat retrieve :" +userRetrieved);
	//	Assert.assertEquals(1L, userRetrieved.getId());
	}
	


	@Test
	public void testModifyEmploye() throws ParseException   {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-23");
		Employe u = new Employe( Long. valueOf("12"),"test1", "test1", "mohamed.mselmi1@esprit.tn","20251825", true, Role.INGENIEUR,uc.retrieveContrat("2"));
		Employe employeUpdated  = us.updateEmploye(u);
		//Assert.assertEquals(u.getLastName(), userUpdated.getLastName());
	}


	

	@Test
	public void testDeleteEmploye() {
		us.deleteEmploye("13");
	//	Assert.assertNull(us.retrieveEmploye("3"));
	}

}
