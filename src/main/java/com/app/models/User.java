package com.app.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
   @Id 	
   private String id;
   
   private String login;

   private String nom;
 
   private String prenom;
 
   private String password;

   private String re_pass;
 
   public User( String login, String nom, String prenom,String password,String re_pass) {
	super();
	this.login = login;
	this.nom = nom;
	this.prenom = prenom;
	this.password = password;
	this.re_pass = re_pass;

}

    public User(String nom, String prenom, String login, String password) {
	super();
	this.login = login;
	this.nom = nom;
	this.prenom = prenom;
	this.password = password;
}
   

public User(String login) {
	super();
	this.login = login;
}


public User(String login,String password) {
	super();
	this.login = login;
	this.password = password;
}




public String getRe_pass() {
	return re_pass;
}



public void setRe_pass(String re_pass) {
	this.re_pass = re_pass;
}



public User() {
	super();
   }

  

 



public String getLogin() {
	return login;
}



public void setLogin(String login) {
	this.login = login;
}



public String getId() {
	return id;
    }

   public String getNom() {
	return nom;
   }
   public void setNom(String nom) {
	this.nom = nom;
    }
   public String getPrenom() {
	return prenom;
    }
   public void setPrenom(String prenom) {
	this.prenom = prenom;
    }
   public String getPassword() {
	return password;
    }
   public void setPassword(String password) {
		this.password = password;
	}


   @Override
   public String toString() {
	return "User [id=" + id + ", login=" + login + ", nom=" + nom + ", prenom=" + prenom + ", password=" + password
			+ ", re_pass=" + re_pass + "]";
   }
   

    



            

 


}
