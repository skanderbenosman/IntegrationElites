
package tn.esprit.spring.service;

 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

		@Autowired
		IUserService us; 
	
		@Test
		public void testRetrieveAllUsers() {
			us.retrieveAllUsers();
		}
		
		
		@Test
		public void testAddUser() throws ParseException {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date d = dateFormat.parse("2015-03-23");
			User u = new User("Mayssa1", "Mayssa1", d, Role.INGENIEUR); 
			us.addUser(u);
		}
	 
		@Test
		public void testModifyUser() throws ParseException   {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date d = dateFormat.parse("2015-03-23");
			User u = new User(5L, "Mayssa122222222", "Mayssa", d, Role.INGENIEUR); 
			us.updateUser(u);
		}
	
		@Test
		public void testRetrieveUser() {
			us.retrieveUser("3");
		}
		
		/*@Test
		public void testDeleteUser() {
			us.deleteUser("2");
			//Assert.assertNull(us.retrieveUser("2"));
		}
		*/
		// 5 tests unitaires  
 
}





