package com.app.service;

import org.springframework.stereotype.Service;

import com.app.models.News;
import com.app.models.Reaction;
import com.app.repositories.NewsRepository;
import com.app.repositories.ReactionRepository;

import static org.springframework.data.mongodb.core.mapreduce.MapReduceOptions.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapreduce.MapReduceOptions;
import org.springframework.data.mongodb.core.mapreduce.MapReduceResults;

@Service
public class ServiceReaction {
    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    private ReactionRepository reactionrep;
    @Autowired
    private NewsRepository newsrep;
    
    public void fonction() {
    	
	    String map = "function () { emit(this.IdNews, this.score); }";
	
	    String reduce = "function (key, values) { return Array.sum( values ); }";
	
	    MapReduceResults<Reaction> results = mongoTemplate.mapReduce("reaction", map, reduce,
			new MapReduceOptions().outputCollection("score"), Reaction.class);
	
    }
    
    public ArrayList<News> newsaime(String login){
    	ArrayList<Reaction> reactions=(ArrayList)reactionrep.findAll();
    	ArrayList<News> news =(ArrayList) newsrep.findAll();
    	ArrayList<News> listenews= new ArrayList<>();
    	    for(Reaction r: reactions) {
    	    	for(News n: news) {
    	    		if( ((r.getIdNews()).equals(n.getId())) && ((r.getLogin()).equals(login)) && (r.getScore() == 1)){
    	    			
    	    			listenews.add(n);
    	    			continue;
    	    		}
    	    	}
    	    }
    	return listenews;
    }
    
    public ArrayList<String> loginAime(String idnews){
    	ArrayList<Reaction> reactions=(ArrayList)reactionrep.findAll();
    	
    	ArrayList<String> listelogin= new ArrayList<>();
    	    for(Reaction r: reactions) {
    	    	
    	    		if( ((r.getIdNews()).equals(idnews))  && (r.getScore() == 1)){
    	    			
    	    			listelogin.add(r.getLogin());
    	    			continue;
    	    		}
    	    	
    	    }
    	    for(String login : listelogin) {
    	    	System.out.println("login : "+ login);
    	    }
    	return listelogin;
    }
    
    public ArrayList<String> logindeteste(String idnews){
    	ArrayList<Reaction> reactions=(ArrayList)reactionrep.findAll();
    	
    	ArrayList<String> listelogin= new ArrayList<>();
    	    for(Reaction r: reactions) {
    	    	
    	    		if( ((r.getIdNews()).equals(idnews))  && (r.getScore() == -1)){
    	    			
    	    			listelogin.add(r.getLogin());
    	    			continue;
    	    		}
    	    	
    	    }
    	    for(String login : listelogin) {
    	    	System.out.println("login : "+ login);
    	    }
    	return listelogin;
    }
    
    public boolean verficationReaction(String login,String IdNews) {
    	List<Reaction> reactions = reactionrep.findByLogin(login);
    	for(Reaction r:reactions) {
    		System.out.println(r);
    	}
    	
    	for(Reaction r: reactions) {
    		if( ((r.getIdNews()).equals(IdNews)) ) {
    			return true;
    		}
    	}
    	
    	
    	return false;
    }
    
}
