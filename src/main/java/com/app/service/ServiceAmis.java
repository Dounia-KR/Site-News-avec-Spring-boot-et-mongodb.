package com.app.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.app.models.Amis;
import com.app.models.Comment;
import com.app.models.News;
import com.app.models.User;
import com.app.repositories.AmisRepository;
import com.app.repositories.UserRepository;
import com.mongodb.client.result.UpdateResult;

@Service
public class ServiceAmis {
	    @Autowired
	    MongoTemplate mongoTemplate;
	    @Autowired
	    AmisRepository repository;
	    @Autowired
	    UserRepository userrep;
	    
	    public long updateAmis(String moi,String ami) {
		   System.out.println("-1");
		   Amis amis = repository.findByMoi(moi);
		   ArrayList<String> a = new ArrayList<String>();
		   a=amis.getAmis();
		   a.add(ami);
		  Query query = new Query(Criteria.where("moi").is(moi));
		  System.out.println("-2");
		    
	        Update update = new Update();
	        System.out.println("-3");
	        update.set("amis", a);
	        System.out.println("-4");

	        UpdateResult result = this.mongoTemplate.updateFirst(query, update, Amis.class);
	        System.out.println("-5");
	        if (result != null) {
	        	 System.out.println("-6");
	            return result.getModifiedCount();
	        }
            
	        return 0;
	    }
	    
	    public ArrayList<User> nonamis(String login) {
	    	
	    	ArrayList<User> listUser=(ArrayList)userrep.findAll();
	    	ArrayList<User> liste=new ArrayList<>();
            
	    	if(!(repository.existsByMoi(login))) {
        		for(User users : listUser) {
        			if((users.getLogin()).equals(login)) {
        				continue;
        			}
        			liste.add(users);
        		}
        		return liste;
        	}
        	Amis ami =repository.findByMoi(login);
        	ArrayList<String> mesamis=ami.getAmis();
        	
        	
        			for(User userr: listUser){
        				int i=0;
        				for(String a : mesamis){
        				
        			if((a.equals(userr.getLogin())) || ((userr.getLogin()).equals(login))){
        				i=1;
        				continue;
        			}
        		
        		} if(i==0) {
        			liste.add(userr);
        		}
        	
        	}
        	
        	return liste;
        }
	    
	    public ArrayList<User> amis(String login){

	    	ArrayList<User> listUser=(ArrayList)userrep.findAll();
        	
            
        	if(!(repository.existsByMoi(login))) {
        		return new ArrayList<>();
        	}
        	Amis ami =repository.findByMoi(login);
        	ArrayList<String> mesamis=ami.getAmis();
        	ArrayList<User> liste=new ArrayList<>();
        	
        			for(User userr: listUser){
        				int i=0;
        				for(String a : mesamis){
        				
        			if((a.equals(userr.getLogin())) && (!(userr.getLogin()).equals(login))){
        				i=1;
        				continue;
        			}
        		
        		} if(i==1) {
        			liste.add(userr);
        		}
        	
        	}
        	
        	return liste;
	    }
	    
}