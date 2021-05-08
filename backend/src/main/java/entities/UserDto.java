package entities;

import core.entities.abstracts.Entity;

public class UserDto implements Entity {
	
	private String eMail;
	private String password;
		
	
	public UserDto(String eMail, String password) {
		super();
		this.eMail = eMail;
		this.password = password;
	}	
	
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
