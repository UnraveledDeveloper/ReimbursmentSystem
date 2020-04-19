package dev.agboneni.DAOs;

import java.util.List;

import dev.agboneni.entities.Manager;

public interface ManagerDAO {
	
	Manager createManager(Manager magr);
	
	Manager getManagerById(int id);
	Manager getManagerByName(String name);
	List<Manager> getAllManagers();
	
	
	Manager updateManager(Manager magr);
	
	boolean deleteManager(Manager magr);
	
	Manager validateLogin(String username, String password);
}
