package com.app.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Score {
	@Id
    private String id;

	private int value;

	public Score() {
		super();
	}
	
	public Score(int value) {
		super();
		this.value = value;
	}


	public String getId() {
		return id;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Score [id=" + id + ", value=" + value + "]";
	}
    
	
	
}
