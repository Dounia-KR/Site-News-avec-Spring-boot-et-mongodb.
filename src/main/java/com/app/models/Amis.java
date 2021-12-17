package com.app.models;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Amis {
	@Id
    private String Id;
    private String moi;
    private ArrayList<String> amis;
    
	public Amis() {
		super();
	}
	public Amis(String moi, ArrayList<String> amis) {
		super();
		this.moi = moi;
		this.amis = amis;
	}
	public Amis(String moi) {
		super();
		this.moi = moi;
	}
	public String getId() {
		return Id;
	}
	public String getMoi() {
		return moi;
	}
	public void setMoi(String moi) {
		this.moi = moi;
	}
	public ArrayList<String> getAmis() {
		return amis;
	}
	public void setAmis(ArrayList<String> amis) {
		this.amis = amis;
	}
	@Override
	public String toString() {
		return "Amis [Id=" + Id + ", moi=" + moi + ", amis=" + amis + "]";
	}
    
    
    
}
