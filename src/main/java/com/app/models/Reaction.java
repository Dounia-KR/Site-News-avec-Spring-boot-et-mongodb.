package com.app.models;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
@Document
public class Reaction {
    @Id
	private String Id;
	private String IdNews;
	private String login;
	private int score;
	
	public Reaction() {
		super();
	}
	

	public Reaction(String IdNews, String login, int score) {
		super();
		this.IdNews = IdNews;
		this.login = login;
		this.score = score;
	}

	public String getId() {
		return Id;
	}

	public String getIdNews() {
		return IdNews;
	}

	public void setIdNews(String IdNews) {
		IdNews = IdNews;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Reaction [Id=" + Id + ", IdNews=" + IdNews + ", login=" + login + ", score=" + score + "]";
	}
	
	
	
	
}
