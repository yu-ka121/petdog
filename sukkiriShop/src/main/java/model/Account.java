package model;

public class Account {
	private String name; 
	private String pass;
	private String mail; 
	private String birthdate; 
	private String userId; 
	private String petname; 
	private String petbirthdate; 
	private String petgender;

  public Account(String name, String pass, String mail,
		  String birthdate, String userId, String petname,
		  String petbirthdate, String petgender) {
	  this.name = name; 
	  this.pass = pass; 
	  this.mail = mail; 
	  this.birthdate = birthdate; 
	  this.userId = userId; 
	  this.petname = petname; 
	  this.petbirthdate = petbirthdate;
	  this.petgender = petgender;
  }

public String getName() {
		return name;
  }

  public String getPass() {
	  	return pass;
  }

  public String getMail() {
	  	return mail;
  }

  public String getBirthdate() {
	  	return birthdate;
  }

  public String getUserId() {
	    return userId;
  }
  
  public String getPetname() {
	    return petname;
  }
  
  public String getPetbirthdate() {
	    return petbirthdate;
	  }
  public String getPetgender() {
	    return petgender;
}
  
}