package com.joseph.entities;

public class Tecnico extends Entity{
	
	private String username;
	private String password;
	
	public Tecnico() {}
	
	public Tecnico(int id, String username, String password) {
		super(id);
		this.username = username;
		this.password = password;
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
		return "Tecnico [username=" + username + ", password=" + password + "] ---- "+ super.toString()+"\n";
	}
	
	
	
	
	
	

}
