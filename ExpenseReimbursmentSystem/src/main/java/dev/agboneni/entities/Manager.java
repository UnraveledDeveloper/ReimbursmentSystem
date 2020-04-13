package dev.agboneni.entities;

public class Manager {
	private int managerId;
	private String name;
	private String username;
	private String password;
	
	
	public Manager(int managerId, String name, String username, String password) {
		this.managerId = managerId;
		this.name = name;
		this.username = username;
		this.password = password;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Manager [managerId=" + managerId + ", name=" + name + ", username=" + username + ", password="
				+ password + "]";
	}
	

}
