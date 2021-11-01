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

import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.services.IMissionService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MissionServiceImplTest {
	@Autowired
	IMissionService mc;
	
	@Test
	public void testRetrieveAllMissions() {
		List<Mission> listMissions = mc.retrieveAllMissions();
		System.out.println("resultat:***"+listMissions);
		// if there are 7 users in DB 7+1 : 
		Assert.assertEquals(13, listMissions.size());
	}
	
	@Test
	public void testAddMission() throws ParseException {
		Mission m = new Mission("wassim", "gabtni"); 
		Mission missionAdded = mc.addMission(m); 
	Assert.assertEquals(m.getName(), missionAdded.getName());
	}
	
	@Test
	public void testRetrieveMission() {
		Mission missionRetrieved = mc.retrieveMission("2");
		System.out.println("resultat retrieve :" +missionRetrieved);
		Assert.assertEquals(2L, missionRetrieved.getId().longValue());
	}
	
	@Test
	public void testModifyMission() throws ParseException   {
		
		Mission m=new Mission("aaa","bbbb");
		Mission missionUpdated  = mc.updateMission(m);
		Assert.assertEquals(m.getName(), missionUpdated.getName());
		Assert.assertEquals(m.getDescription(), missionUpdated.getDescription());
	}

	@Test
	public void testDeleteMission() {
		mc.deleteUMission("50");
	Assert.assertNull(mc.retrieveMission("50"));
	//delete an existing id 
	}

}
