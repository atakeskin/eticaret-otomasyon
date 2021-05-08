package core.entities.concretes;

import core.entities.abstracts.Entity;

public class User implements Entity {
	
	private int id;
	private String firstName;
	private String lastName;
	private String eMail;
	private String password;
	private boolean status = false;
	
	public User() {
		super();
	}
	
	public User(String eMail, String password) {
		this();
		this.eMail = eMail;
		this.password = password;

	}

	public User(int id, String firstName, String lastName, String eMail, String password) {
		this(eMail,password);
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		
	}
	
	public User(int id, String firstName, String lastName, String eMail, String password, boolean status) {
		this(id,firstName,lastName,eMail,password);
		this.status = status;
		
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", eMail=" + eMail
				+ ", password=" + password + "]";
	}

	
}
