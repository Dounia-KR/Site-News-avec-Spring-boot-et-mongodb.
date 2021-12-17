package com.app.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Comment {
	@Id
	private String id;
	
    private String comment;
    private String date;
    private User user;
    private News news;
    
	public Comment() {
		super();
	}
	
	public Comment(String comment) {
		super();
		this.comment = comment;
	}
     

	public Comment(String comment, String date) {
		super();
		this.comment = comment;
		this.date = date;
	}
	
	public Comment(String comment, String date, User user, News news) {
		super();
		this.comment = comment;
		this.date = date;
		this.user = user;
		this.news = news;
	}
	
	public Comment(String comment, String date, News news) {
		super();
		this.comment = comment;
		this.date = date;
		this.news = news;
	}
	public Comment(String comment, String date, User user) {
		super();
		this.comment = comment;
		this.date = date;
		this.user = user;
	}
	public String getId() {
		return id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public News getnews() {
		return news;
	}
	public void setNews(News news) {
		this.news = news;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", comment=" + comment + ", date=" + date + ", user=" + user + ", news=" + news
				+ "]";
	}
	
    
    
    
}
