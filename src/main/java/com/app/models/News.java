package com.app.models;

import java.util.ArrayList;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class News {
  @Id
  private String id;
  
  private String URL;
  
  private String dateajout;
  
  private String titre;
  
  private int scoreTotal;
  
  private int scoreamie;
  
  private int scoredeteste;
  
  private User user;
  
  private ArrayList<Comment> comments;
  
  public News() {
	super();
   }
 

  public News(String uRL) {
	super();
	this.URL = uRL;
}




  public News(String uRL, String dateajout, String titre) {
	super();
	URL = uRL;
	this.dateajout = dateajout;
	this.titre = titre;
   }
  
	public News(String uRL, String dateajout, String titre, User user, ArrayList<Comment> comments) {
	super();
	URL = uRL;
	this.dateajout = dateajout;
	this.titre = titre;
	this.user = user;
	this.comments = comments;
    }

    public News(String uRL, String titre) {
	super();
	URL = uRL;
	this.titre = titre;
    }
    public News(String uRL, String dateajout, String titre, User user) {
	super();
	URL = uRL;
	this.dateajout = dateajout;
	this.titre = titre;
	this.user = user;
    }
  
    public News(String uRL, String dateajout, String titre, int scoreTotal, User user) {
		super();
		URL = uRL;
		this.dateajout = dateajout;
		this.titre = titre;
		this.scoreTotal = scoreTotal;
		this.user = user;
	}
    

	public String getId() {
	return id;
    }

    public String getURL() {
	return URL;
    }
    public void setURL(String uRL) {
	URL = uRL;
   }
 
   
    public String getDateajout() {
	return dateajout;
    }
    public void setDateajout(String dateajout) {
	this.dateajout = dateajout;
    }
    public String getTitre() {
	return titre;
    }
    public void setTitre(String titre) {
	this.titre = titre;
    }
    
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public ArrayList<Comment> getComments() {
		return comments;
	}



	public void setComments(ArrayList<Comment> comments) {
		this.comments = comments;
	}
     


	public int getScoreTotal() {
		return scoreTotal;
	}

	public void setScoreTotal(int scoreTotal) {
		this.scoreTotal = scoreTotal;
	} 

	public int getScoreamie() {
		return scoreamie;
	}


	public void setScoreamie(int scoreamie) {
		this.scoreamie = scoreamie;
	}


	public int getScoredeteste() {
		return scoredeteste;
	}


	public void setScoredeteste(int scoredeteste) {
		this.scoredeteste = scoredeteste;
	}


	@Override
	public String toString() {
		return "News [id=" + id + ", URL=" + URL + ", dateajout=" + dateajout + ", titre=" + titre + ", user=" + user
				+ "]";
	}
	
	        
    
      
    
  
  
}
