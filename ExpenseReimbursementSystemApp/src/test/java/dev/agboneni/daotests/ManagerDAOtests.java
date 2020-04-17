package dev.agboneni.daotests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dev.agboneni.DAOs.ManagerDAO;
import dev.agboneni.DAOs.ManagerDAOmariadb;
import dev.agboneni.entities.Manager;

public class ManagerDAOtests {

	@Before
	public void setUp() throws Exception {
	}

	ManagerDAO mdao = new ManagerDAOmariadb();
	@Test
	public void createManagertest() {
	
		Manager m = new Manager();

		m.setName("Mack");
		m.setUsername("mactest");
		m.setPassword("mactestpass");

		mdao.createManager(m);
		System.out.println(m);
	}
	
	@Test
	public void getManagerTest() {
		Manager m = mdao.getManagerById(2);
		Manager name = mdao.getManagerByName("Maya");
		List<Manager> managers = mdao.getAllManagers();
		for(Manager m2 : managers) {
			System.out.println(m2);
		}
		//System.out.println(name);
		
	}
	
	@Test

	public void updateManagertest() {
		Manager m = mdao.getManagerById(2);
		m.setUsername("ricktest");


		mdao.updateManager(m);
		System.out.println(m);
		
	}

	@Test
	public void deleteManagertest() {
		Manager m = mdao.getManagerById(4);
		mdao.deleteManager(m);
		System.out.println(m);
	}


}
